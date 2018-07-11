SUMMARY = "Startup script to initialize ROS and nodes upon powerup"
DESCRIPTION = "A startup script using systemd to initialize and run ROS nodes when power is applied to the board"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://COPYING;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "\
        file://init_ros.sh \
        file://init-ros.service \
"
S = "${WORKDIR}"

inherit systemd

SYSTEMD_PACKAGES = "${PN}"

SYSTEMD_SERVICE_${PN} += "init-ros.service"

RDEPENDS_${PN} += "\
	bash \
	ros-ws \
	static-ip \	
"

#DEPENDS += "ros-ws"

FILES_${PN} += "\
	init-ros.service \
        init_ros.sh \
"


do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/init-ros.service ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/init_ros.sh ${D}${bindir}
}
