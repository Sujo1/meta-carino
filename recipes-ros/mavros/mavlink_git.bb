SUMMARY = "MAVLink micro air vehicle marshalling / communication library"
HOMEPAGE = "http://qgroundcontrol.org/mavlink/"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

DEPENDS = "catkin"

PV = "1.0.9-5"
SRCREV = "e2fda4025e8c776f812767f759880f36347cd582"
SRC_URI = "git://github.com/mavlink/mavlink-gbp-release;branch=release/indigo/mavlink \
          "

S = "${WORKDIR}/git"

inherit catkin

#PARALLEL_MAKE = ""
#OECMAKE_SOURCEPATH = "${S}"
#OECMAKE_BUILDPATH = "${S}/build-${TARGET_ARCH}-${PV}"

#FILES_${PN} += "${datadir}/pyshared"

INSANE_SKIP_${PN} = "installed-vs-shipped " 
