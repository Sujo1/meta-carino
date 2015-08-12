DESCRIPTION = "MAVLink extendable communication node for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "catkin roscpp"

SRC_URI = "https://github.com/mavlink/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cd9d4e38e17fbd4d2345f1c34b9e22c6"
SRC_URI[sha256sum] = "2d5293ade18e30d6e27b1089db472fabccebab571204c7068a8037a8a2ebfc1d"

S = "${WORKDIR}/mavros-master/mavros_msgs"

inherit catkin

