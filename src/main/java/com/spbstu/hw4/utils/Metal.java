package com.spbstu.hw4.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Metal {
    GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");
    String value;
}
