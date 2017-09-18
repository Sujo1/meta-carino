DESCRIPTION = "ROS wrapper for the Hokuyo urg_c library."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "catkin roscpp rosconsole sensor-msgs urg-c nodelet dynamic-reconfigure tf laser-proc diagnostic-updater python-rospkg"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "72dd01dba0aa25b2103a76ba80ec36e8"
SRC_URI[sha256sum] = "b4691da54db803fb7f9d0bd2e2008a58de4a36fa7082dc69a1938c1702994387"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
