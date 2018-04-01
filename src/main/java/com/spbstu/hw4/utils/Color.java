package com.spbstu.hw4.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Color {
    RED("Red"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow");
    String value;
}
