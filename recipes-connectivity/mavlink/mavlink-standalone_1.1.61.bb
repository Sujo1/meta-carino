#SUMMARY = "MAVLink micro air vehicle marshalling / communication library"
#HOMEPAGE = "http://qgroundcontrol.org/mavlink/"

#LICENSE = "GPLv2"
#LIC_FILES_CHKSUM = "file://README.txt;md5=2fc3900b33c4131645987a81bfe6a55f"

#DEPENDS = "python"

#SRCREV = "74c7c0f8a3aa975e9ec66182b9c09cb8f14a35d2"
#SRC_URI = "https://pypi.python.org/packages/source/p/pymavlink/#pymavlink-1.1.61.tar.gz;md5=ec69ab4e72ae26fdb2853f69d4424328"

#SRC_URI[md5sum] = "ec69ab4e72ae26fdb2853f69d4424328"
#SRC_URI[sha256sum] = "2c8f362276dc897909b4b92e9649777999bb970e67488d1c1ca78a6b71cd9565"


#S = "${WORKDIR}/pymavlink-1.1.61"

#inherit setuptools


SUMMARY = "MAVLink micro air vehicle marshalling / communication library"
HOMEPAGE = "http://qgroundcontrol.org/mavlink/"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

PV = "1.0.9"
SRCREV = "5a30dbf2546a131fd1529efeaead825e332f70cc"
SRC_URI = "git://github.com/mavlink/mavlink.git \
          "

S = "${WORKDIR}/git"

inherit cmake pythonnative

PARALLEL_MAKE = ""
OECMAKE_SOURCEPATH = "${S}"
OECMAKE_BUILDPATH = "${S}/build-${TARGET_ARCH}-${PV}"

FILES_${PN} += "${datadir}/pyshared"
FILES_${PN} += "${datadir}/mavlink"
