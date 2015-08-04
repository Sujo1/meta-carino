DESCRIPTION = "Packaging for URG Helper URG Widget URG Library urg_c Original Source at: http://sourceforge.net/projects/urgwidget This project introduces sample programs of the URG library. Applications using URG and URG library are also introduced here. URG is Scanning Laser Range Finder of Hokuyo Automatic Co., for robots, autonomous systems and security systems."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "catkin"

SRC_URI = "https://github.com/ros-drivers/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "fbcf82518cf341612518bcb8421dd72d"
SRC_URI[sha256sum] = "cb51032301515297b3839f6dec0c7124bc533936da1e7bbd28989dcb51fa1da4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
