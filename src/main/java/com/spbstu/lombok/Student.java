package com.spbstu.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created by dmitry on 21.03.2018.
 */

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    List<String> tails;
    String name;

    @Getter
    Integer age;
}
