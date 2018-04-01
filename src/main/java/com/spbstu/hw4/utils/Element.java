package com.spbstu.hw4.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Element {
    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");
    String value;
}
