package com.spbstu.pageObject.pages;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by dmitry on 14.03.2018.
 */
public class ContactFormPage {

    private int a;
    private int b;

    public ContactFormPage() {
        page(this);
    }
}
