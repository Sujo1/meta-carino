DESCRIPTION = "A custom image for the project at hand."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

LICENSE = "MIT"

inherit core-image

ROOTFS_PKGMANAGE_BOOTSTRAP = ""

IMAGE_FEATURES += "package-management"
IMAGE_ROOTFS_SIZE = "16384"
IMAGE_INSTALL += "\
	roslaunch \
	openssh \
	init-ifupdown \
	vim \
	roscpp \
	rospy \
	std-msgs \
	geometry-msgs \
	sensor-msgs \
	init-script \
"
