#!/usr/bin/env python

import rospy
import numpy as np
from gmm_slam.msg import GaussianMixtureModel, GaussianModel
from rospy.numpy_msg import numpy_msg

means = np.array([[4.99990800e+00,   2.50427121e+00, 0],
       [ -4.99990800e+00,   2.50427087e+00, 0 ],
       [ -6.85574204e-07,   4.99985568e+00, 0]])
       
covariances = np.array([[[  1.00551255e-03,  -2.29609384e-04, 0],
        [  -2.29609384e-04,   2.11628332e+00, 0],[  0,   0, 1e-3]],

       [[  1.00551238e-03,   2.29602694e-04, 0],
        [ 2.29602694e-04,   2.11628277e+00, 0],[  0,   0, 1e-3]],

       [[  8.37885040e+00,   7.53579120e-09, 0],
        [  7.53579124e-09,   1.00639871e-03, 0],[  0,   0, 1e-3]]])
        
weights = [ 0.3338942 ,  0.33389415,  0.33221165]

pub = rospy.Publisher('/gmm', numpy_msg(GaussianMixtureModel), queue_size=10)
rospy.init_node('gmm_publisher', anonymous=True)
rate = rospy.Rate(10) # 10hz
while not rospy.is_shutdown():
    GMM = GaussianMixtureModel()
    for mean, covariance in zip(means, covariances):
        gaussian = GaussianModel()
        gaussian.mean = mean
        gaussian.covariance = covariance.flatten()
        GMM.gaussians.append( gaussian )
    GMM.weights = weights
    pub.publish(GMM)
    rate.sleep()