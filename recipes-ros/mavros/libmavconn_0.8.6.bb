DESCRIPTION = "MAVLink extendable communication node for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "boost catkin console-bridge mavlink pymavlink"

SRC_URI = "https://github.com/mavlink/mavros/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "cb3b2d321a2a0f77ddcff411abe402a0"
SRC_URI[sha256sum] = "140a4c36a75fff0ba4bd1feb8a09015305c42f4c89922fcf2a300222fa1b2324"

S = "${WORKDIR}/mavros-${PV}/libmavconn"

inherit catkin


