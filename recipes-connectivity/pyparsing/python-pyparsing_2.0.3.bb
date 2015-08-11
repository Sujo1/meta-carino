SUMMARY = "A Python Parsing Module"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://pyparsing.py;beginline=3;endline=23;md5=06277c41c36d17c011da1050c730a193"

SRCNAME = "pyparsing"

SRC_URI = "https://pypi.python.org/packages/source/p/pyparsing/pyparsing-${PV}.tar.gz"
SRC_URI[md5sum] = "0fe479be09fc2cf005f753d3acc35939"
SRC_URI[sha256sum] = "06e729e1cbf5274703b1f47b6135ed8335999d547f9d8cf048b210fb8ebf844f"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

