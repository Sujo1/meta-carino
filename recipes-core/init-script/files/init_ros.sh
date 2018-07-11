#!/bin/bash

export ROS_ROOT=/opt/ros
export ROS_DISTRO=indigo #Change according to conf/layer.conf
export ROS_PACKAGE_PATH=/opt/ros/indigo/share
export PATH=$PATH:/opt/ros/indigo/bin
export LD_LIBRARY_PATH=/opt/ros/indigo/lib
export PYTHONPATH=/opt/ros/indigo/lib/python2.7/site-packages
export ROS_MASTER_URI=http://localhost:11311
export CMAKE_PREFIX_PATH=/opt/ros/indigo
touch /opt/ros/indigo/.catkin

roslaunch beginners_tutorials start.launch
