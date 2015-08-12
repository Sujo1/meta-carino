DESCRIPTION = "MAVLink extendable communication node for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "angles boost catkin cmake-modules diagnostic-msgs diagnostic-updater libeigen eigen-conversions geometry-msgs libmavconn mavlink mavros-msgs message-runtime nav-msgs std-msgs std-srvs tf2-ros rosconsole-bridge"

SRC_URI = "https://github.com/mavlink/mavros/archive/v0.4.1.tar.gz"
SRC_URI[md5sum] = "0db082b7b0cfd32388b47bfc5c55f333"
SRC_URI[sha256sum] = "ce7e437ea8286debcdb09c2ca2989c1a58cdcaef7f6945278190a8f3335cb7af"

S = "${WORKDIR}/mavros-0.4.1"

inherit catkin

CATKIN_DEPENDS = "Boost"

