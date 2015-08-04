DESCRIPTION = "This is a library for lightweight communication between Micro Air Vehicles (swarm) and/or ground control stations. It allows for defining messages within XML files, which then are converted into appropriate source code for different languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=c085d179dcd159165b47bc200467b556"

DEPENDS = "catkin cmake python pymavlink"

SRC_URI = "https://github.com/mavlink/mavlink-gbp-release/archive/release/hydro/mavlink.tar.gz;downloadfilename=mavlink-1.0.9.tar.gz"
SRC_URI[md5sum] = "27bbbae32993b3a0b0c9354a3f32e533"
SRC_URI[sha256sum] = "70bdbbea187bd5a801bef2cc6cc8276de33c132f4d48fbffa1ca812efab2cd13"

S = "${WORKDIR}/mavlink-gbp-release-release-hydro-mavlink"

inherit catkin

INSANE_SKIP = "1"
