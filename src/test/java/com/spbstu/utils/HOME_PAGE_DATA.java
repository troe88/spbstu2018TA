package com.spbstu.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;

// поставить плагин Lombok, чтобы заработал декоратор
// dependency недостаточно. Он позволяет убирать констркутор
@AllArgsConstructor
@Getter
public enum HOME_PAGE_DATA {
    LOGIN("epam"), PASSWORD("1234"), USER_NAME("PITER CHAILOVSKI");

    String value;
}