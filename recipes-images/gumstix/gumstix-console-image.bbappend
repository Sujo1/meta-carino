ROS_INSTALL = " \
  packagegroup-ros-comm \
  python-wstool \
  python-email \
  python-distutils \
  git \
  git-perltools \
  python-rosinstall \
  rospy-tutorials \
  roscpp-tutorials \
  screen \
  urg-node \
  rosbag \
  mavros \
"

OPENCV_INSTALL = " \
  opencv \
  python-opencv \
  cv-bridge \
  image-geometry \
"

PYTHON_INSTALL = " \
  python-numpy \
  python-pyserial \
"

NETWORK_INSTALL = " \
  hostap-daemon \
"

IMAGE_INSTALL += " \
  ${ROS_INSTALL} \
  ${OPENCV_INSTALL} \
  ${PYTHON_INSTALL} \
  ${NETWORK_INSTALL} \
  ${UTILITIES_INSTALL} \
"

