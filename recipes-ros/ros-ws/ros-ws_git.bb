DESCRIPTION = "ROS user workspace repository" 
SECTION = "ros" 
LICENSE = "CLOSED" 
PR = "r0" 

inherit catkin

SRC_URI = "git:///home/build/catkin_ws/src/beginners_tutorials"
SRCREV = "64197b688e7c599ac13d3076a388a3365168889a"

S = "${WORKDIR}/git"

DEPENDS += "\
	roscpp \
	rospy \
	std-msgs \
"

RDEPENDS_${PN} += "\
	roslaunch \
	rostopic \
	rosnode \
"

ROS_INSTALL_PATH = "/opt/ros/${ROSDISTRO}/lib/beginners_tutorials/"

FILES_${PN} += "\
	${ROS_INSTALL_PATH}talker \
	${ROS_INSTALL_PATH}listener \
"
