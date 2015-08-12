DESCRIPTION = "MAVLink extendable communication node for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "boost catkin console-bridge mavlink"

SRC_URI = "https://github.com/mavlink/mavros/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5dbd9549f383acdc5b036d699fe4483f"
SRC_URI[sha256sum] = "5ca193555f2a11ee049151ab22fc7f6387fcaea4dd12e971dcd591c71fdb6d30"

S = "${WORKDIR}/mavros-${PV}/libmavconn"

inherit catkin



