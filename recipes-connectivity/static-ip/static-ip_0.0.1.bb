SUMMARY = "Make the system have a static ip address"
DESCRIPTION = "Recipe that installs configuration files to have a static ip address and a predefined hostname"
LICENSE = "CLOSED"

SRC_URI += "\
        file://20-wired.network \
"
S = "${WORKDIR}"

inherit systemd

EXTRA_OECONF_append += "-Dnetworkd=true"

SYSTEMD_PACKAGES = "${PN}"

NETWORKD_SERVICE_${PN} += "20-wired.network"

FILES_${PN} += "\
        20-wired.network \
"
networkd_system_unitdir = "/etc/systemd/network/"

do_install () {
    install -d ${D}${networkd_system_unitdir}
    install -m 0755 ${WORKDIR}/20-wired.network ${D}${networkd_system_unitdir}
}
