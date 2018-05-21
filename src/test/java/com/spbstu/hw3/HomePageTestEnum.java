package com.spbstu.hw3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
enum HomePageTestEnum {
    // constants
    LOGIN("epam"),
    PASSWORD("1234"),
    PAGE_TITLE("Index Page"),
    ERROR_STR("Actual: %s but expected: %s"),
    USER_NAME("PITER CHAILOVSKII"),
    HEADER_TEXT("EPAM FRAMEWORK WISHES…"),
    ANNOTATION("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    BENEFIT1("To include good practices\nand ideas from successful\nEPAM projec"),
    BENEFIT2("To be flexible and\ncustomizable"),
    BENEFIT3("To be multiplatform"),
    BENEFIT4("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    String value;
}
