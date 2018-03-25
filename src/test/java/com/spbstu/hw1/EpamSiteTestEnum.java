package com.spbstu.hw1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@lombok.Getter
enum EpamSiteTestEnum {

    EPAM_TEST_LINK("https://jdi-framework.github.io/tests"),
    INDEX_PAGE("Index Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    DROPDOWN_CSS_SELECTOR(".profile-photo"),
    LOGIN_CSS_SELECTOR("#Login"),
    PASSWORD_CSS_SELECTOR("#Password"),
    USERNAME_CSS_SELECTOR(".profile-photo > span"),
    USER_FULL_DISPLAY_NAME("PITER CHAILOVSKII"),
    DIAGNOSTIC_STRING("Actual: %s but expected: %s"),
    ANNOTATION_CSS_SELECTOR(".main-content > p"),
    TITLE_CSS_SELECTOR(".main-content > h3"),
    EPAM_FRAMEWORK_WISHES("EPAM FRAMEWORK WISHES…"),
    LOREM_IPSUM_DOLOR("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    WISH1("To include good practices\nand ideas from successful\nEPAM projec"),
    WISH2("To be flexible and\ncustomizable"),
    WISH3("To be multiplatform"),
    WISH4("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"),
    WISH_NOT_FOUND_DIAGNOSTIC_STRING("Text not found in the acceptable wishlist of framework "),
    ICONS_CSS_SELECTOR(".benefit-icon");

    String value;
}
