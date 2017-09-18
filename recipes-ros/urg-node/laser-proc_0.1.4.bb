DESCRIPTION = "Converts representations of sensor_msgs/LaserScan and sensor_msgs/MultiEchoLaserScan"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "catkin nodelet pluginlib rosconsole roscpp sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "14eb01b63a41e416a15f8a3c16887999"
SRC_URI[sha256sum] = "9dde874a6ae9de30ea59e37aa0d962a35e4da3ebed7e5a639225b901fe4523bd"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
