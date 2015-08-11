#!/usr/bin/env python

import rospy
from visualization_msgs.msg import Marker, MarkerArray
import visualization_msgs
import numpy as np
from gmm_slam.msg import GaussianMixtureModel
import PyKDL
from rospy.numpy_msg import numpy_msg

res = 1e3

def callback(data):
    markerArray = MarkerArray()
    for weight, i in zip(np.array(data.weights, dtype = np.float32), range(len(data.weights))):
        #painting the gaussian ellipsoid marker
        marker = Marker()
        marker.header.frame_id = "inertial"
        marker.header.stamp = rospy.Time.now ()
        marker.ns = "GMM_SLAM_ns"
        marker.id = i;
        marker.type = visualization_msgs.msg.Marker.SPHERE
        marker.action = visualization_msgs.msg.Marker.MODIFY
        marker.pose.position.x = data.gaussians[i].mean[0]
        marker.pose.position.y = data.gaussians[i].mean[1]
        marker.pose.position.z = data.gaussians[i].mean[2]
         
        #getting the distribution eigen vectors and values
        covar = np.empty((0,3))
        for row in data.gaussians[i].covariance:
            covar = np.append(covar, [row.rows], axis = 0)
        eigValues,eigVectors = np.linalg.eig (covar)
         
        #building the rotation matrix
        eigx_n=PyKDL.Vector(eigVectors[0,0],eigVectors[0,1],eigVectors[0,2])
        eigy_n=-PyKDL.Vector(eigVectors[1,0],eigVectors[1,1],eigVectors[1,2])
        eigz_n=PyKDL.Vector(eigVectors[2,0],eigVectors[2,1],eigVectors[2,2])
        eigx_n.Normalize()
        eigy_n.Normalize()
        eigz_n.Normalize()
        rot = PyKDL.Rotation (eigx_n,eigy_n,eigz_n)
        quat = rot.GetQuaternion ()
         
        #painting the Gaussian Ellipsoid Marker
        marker.pose.orientation.x =quat[0]
        marker.pose.orientation.y = quat[1]
        marker.pose.orientation.z = quat[2]
        marker.pose.orientation.w = quat[3]
        marker.scale.x = eigValues[0]*res*weight
        marker.scale.y = eigValues[1]*res*weight
        marker.scale.z =eigValues[2]*res*weight
         
        marker.color.a = 0.5
        marker.color.r = 0.0
        marker.color.g = 1.0
        marker.color.b = 0.0
        
        markerArray.markers.append(marker)

    gauss_pub.publish (markerArray)


rospy.init_node ('gmm_plot', anonymous = True)
rospy.Subscriber("/gmm_map", numpy_msg(GaussianMixtureModel), callback)
gauss_pub = rospy.Publisher ("/gmm_ellipsoids", MarkerArray, queue_size = 10)

rospy.spin()
