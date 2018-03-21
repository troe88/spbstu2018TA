package com.spbstu.lombok;

import lombok.val;

import java.util.Arrays;

/**
 * Created by dmitry on 21.03.2018.
 */
public class LombokMain {
    public static void main(String[] args) {
        val student = new Student(Arrays.asList("math", "oop"), "smyk", 12);
        System.out.println(student);
    }
}
