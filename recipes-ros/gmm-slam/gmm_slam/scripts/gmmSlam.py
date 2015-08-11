#!/usr/bin/env python

import rospy
from gmm_slam.msg import GaussianMixtureModel, GaussianModel, CovarianceRow
from std_msgs.msg import Header
from sensor_msgs.msg import Imu, LaserScan
from mavros_extras.msg import OpticalFlowRad
from geometry_msgs.msg import PoseStamped
from rospy.numpy_msg import numpy_msg
import numpy as np
import quaternion
from GMM_filter import slam

def ImuDef(data):
    global q_k, wk
    q_k = np.quaternion(data.orientation.w,
                        data.orientation.x,
                        data.orientation.y,
                        data.orientation.z)
    wk = np.array([data.angular_velocity.x,
                   data.angular_velocity.y,
                   data.angular_velocity.z])
    SLAM.Q[5:7,5:7] = np.reshape(data.orientation_covariance, (3,3))[:2,:2]
    SLAM.Q[8,8] = np.reshape(data.angular_velocity_covariance, (3,3))[2,2]
    
def FlowDef(data):
    global VelX, VelY
    VelX = data.integrated_x
    VelY = data.integrated_y
    SLAM.Q[3:5,3:5] = np.eye(2)*(1 + (data.quality/255.0)*(0.1-1))
    
def LocalPosDef(data):
    global alt
    alt = data.pose.position.z
    
def LaserDef(data):
    global meas, laser, VelX, VelY, q_k, wk, alt
    laser = data.ranges*np.exp(np.linspace(data.angle_min, data.angle_max, data.ranges.shape[0])*1j)
    laser = np.append([laser.real],[laser.imag],axis = 0).T
    laser = np.concatenate((laser, np.zeros((laser.shape[0],1))),axis=1)
    laser = laser[np.isfinite(data.ranges)]
    if VelX != None and VelY != None and type(q_k) is np.quaternion and wk != None and alt != None:
        meas = {'laser': laser, 'alt': alt, 'flow':np.array([VelX, VelY]), 'theta':(np.log(q_k)*2).vec[:2], 'w':wk[2]}
    
    

#Create Node
rospy.init_node ('gmm_slam', anonymous = True)
SLAM = slam(numComp = 10, dt = 0.1, maxNumParticles = 20, minNumParticles = 5)
meas = None
VelX, VelY = 0, 0
q_k = None
wk = None
alt = None

#Create Subscribers
rospy.Subscriber("/mavros/imu/data", numpy_msg(Imu), ImuDef)
rospy.Subscriber("/scan", numpy_msg(LaserScan), LaserDef)
rospy.Subscriber("/mavros/optical_flow", numpy_msg(OpticalFlowRad), FlowDef)
rospy.Subscriber("/mavros/position/local", numpy_msg(PoseStamped), LocalPosDef)

#Create Publishers
map_pub = rospy.Publisher ("/gmm_map", numpy_msg(GaussianMixtureModel), queue_size = 10)
pose_pub = rospy.Publisher ("/slam_pose", numpy_msg(PoseStamped), queue_size = 10)

rate = rospy.Rate(10) # 10hz
i = 0
while not rospy.is_shutdown():
    if meas:
        SLAM.update(meas)
        header = Header()
        header.seq = i
        i += 1
        header.stamp = rospy.Time.now()
        GMM = GaussianMixtureModel()
        for mean, var, weight in zip(SLAM.map.means_, SLAM.map.covars_, SLAM.map.weights_):
            gaussian = GaussianModel()
            for m in mean:
                gaussian.mean.append(m)
            for v1 in var:
                row = CovarianceRow()
                for v2 in v1:
                    row.rows.append(v2)
                gaussian.covariance.append(row)
            GMM.gaussians.append(gaussian)
            GMM.weights.append(weight)
        map_pub.publish(GMM)
        pose = PoseStamped()
        pose.header = header
        pose.pose.position.x = SLAM.particles[:,0].mean()
        pose.pose.position.y = SLAM.particles[:,1].mean()
        pose.pose.position.z = SLAM.particles[:,2].mean()
        q = np.quaternion(0, SLAM.particles[:,5].mean(), SLAM.particles[:,6].mean(), SLAM.particles[:,7].mean())
        q = np.exp(q/2)
        pose.pose.orientation.w = q.real
        pose.pose.orientation.x = q.vec[0]
        pose.pose.orientation.y = q.vec[1]
        pose.pose.orientation.z = q.vec[2]
        pose_pub.publish(pose)
    rate.sleep()