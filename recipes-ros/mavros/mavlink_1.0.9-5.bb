SUMMARY = "MAVLink micro air vehicle marshalling / communication library"
HOMEPAGE = "http://qgroundcontrol.org/mavlink/"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

DEPENDS = "catkin mavlink-standalone"

PV = "1.0.9-5"
SRCREV = "e2fda4025e8c776f812767f759880f36347cd582"
SRC_URI = "https://github.com/mavlink/mavlink-gbp-release/archive/release/indigo/mavlink.tar.gz;downloadfilename=${ROS_SP}.tar.gz"

S = "${WORKDIR}/mavlink-gbp-release-release-indigo-mavlink"

inherit catkin cmake pkgconfig pythonnative

SRC_URI[md5sum] = "a8c011f16edd1d47d68fb77b26c415dd"
SRC_URI[sha256sum] = "ccc833cadbc8421031aa8174d2b7675de96edbd2ab6609041eec65c6d42c2ee2"


#INSANE_SKIP_${PN} = "installed-vs-shipped " 

do_compile_prepend() {
    #Generate Mavlink messages
    cd ${WORKDIR}/build
    oe_runmake

    #Return to build directory
    cd ${S}
}

FILES_${PN} += "${datadir}/mavlink"
