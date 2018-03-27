package com.spbstu.hw4.pages;

import com.codeborne.selenide.Selenide;

public class ElementsPage {

    private static final String PAGE_URL = "https://jdi-framework.github.io/tests/page8.htm";

    public void open() {
        Selenide.open(PAGE_URL);
    }
}
