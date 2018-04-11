DESCRIPTION = "A small image just capable of starting mavros."
include rpi-hwup-image.bb
inherit core-image

SPLASH = "psplash-raspberrypi"

IMAGE_FEATURES += "ssh-server-dropbear splash"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

LICENSE = "BSD"

IMAGE_ROOTFS_SIZE = "8192"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake"

IMAGE_INSTALL += " \
	roslaunch \
	mavros \
	cmake \
	vim \
	urg-node \
	hostapd \
	ros-setup \
	opencv \
"
