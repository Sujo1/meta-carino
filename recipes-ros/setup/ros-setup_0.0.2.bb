DESCRIPTON = "Setup script for ros"
LICENSE = "BSD"
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=477dfa54ede28e2f361e7db05941d7a7"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=96af5705d6f64a88e035781ef00e98a8"

# Recipe revision - don't forget to 'bump' when a new revision is created !
PR = "r0"

# Runtime dependencies
#
# Add a line similar to the following to ensure any packages needed for the scripts to run are installed in the image.
#
# RDEPENDS_${PN} = "parted"

# SRC_URI specifies the files that are to be used as the scripts.
#
# Any valid src_uri format can be used - this example assumes the
# scripts are stored in the 'files' directory below the one in
# which this file is located.
#
SRC_URI = " \
   file://setup-ros.sh \
   file://LICENSE \
   "

# This function is responsible for:
#  1) Ensuring the required directories exist in the image;
#  2) Installing the scripts in to the image;
#  3) Creating the desired runlevel links to the scripts.
#
do_install() {
    #
    # Create directories:
    #   ${D}${sysconfdir}/init.d - will hold the scripts
    #   ${D}${sysconfdir}/rcS.d  - will contain a link to the script that runs at startup
    #   ${D}${sysconfdir}/rc5.d  - will contain a link to the script that runs at runlevel=5
    #   ${D}${sbindir}           - scripts called by the above
    #
    # ${D} is effectively the root directory of the target system.
    # ${D}${sysconfdir} is where system configuration files are to be stored (e.g. /etc).
    # ${D}${sbindir} is where executable files are to be stored (e.g. /sbin).
    #
    install -d ${D}${sbindir}

    #
    # Install files in to the image
    #
    # The files fetched via SRC_URI (above) will be in ${WORKDIR}.
    #
    echo ${WORKDIR}
    install -m 0755 ${WORKDIR}/setup-ros.sh  ${D}${sbindir}/

    #
    # Symbolic links can also be installed. e.g.
    #
    # ln -s support-script-link ${D}${sbindir}/support-script

    #
    # Create symbolic links from the runlevel directories to the script files.
    # Links of the form S... and K... mean the script when be called when
    # entering / exiting the runlevel designated by the containing directory.
    # For example:
    #   rc5.d/S90run-script will be called (with %1='start') when entering runlevel 5.
    #   rc5.d/K90run-script will be called (with %1='stop') when exiting runlevel 5.
    #
}
