SUMMARY = "gbm library"
LICENSE = "MIT"
SECTION = "libs"

LIC_FILES_CHKSUM = " \
    file://gbm.c;beginline=4;endline=22;md5=5cdaac262c876e98e47771f11c7036b5"

SRCREV = "71806a392f351f9b99ab1489587c8ca6f9fbe10f"
SRC_URI = "git://github.com/renesas-rcar/libgbm;branch=match-mesa-17.3.6"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "(r8a7795|r8a7796|r8a77965|r8a77990)"
DEPENDS = "wayland-kms udev"

inherit autotools pkgconfig

PACKAGES = " \
    ${PN} \
    ${PN}-dev \
    ${PN}-dbg \
    ${PN}-staticdev \
"

FILES_${PN} = " \
    ${libdir}/libgbm.so.* \
    ${libdir}/gbm/libgbm_kms.so.* \
    ${libdir}/gbm/*.so \
    ${libdir}/*.so \
"
FILES_${PN}-dev += "${libdir}/gbm/*.la"
FILES_${PN}-dbg += "${libdir}/gbm/.debug/*"
FILES_${PN}-staticdev += "${libdir}/gbm/*.a"

INSANE_SKIP_${PN} += "dev-so"
PROVIDES += "virtual/libgbm"
