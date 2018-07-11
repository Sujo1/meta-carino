




do_install_append() {
	echo '127.0.0.1	odroid-xu4.localdomain		odroid-xu4' >> ${D}${sysconfdir}/hosts
}
