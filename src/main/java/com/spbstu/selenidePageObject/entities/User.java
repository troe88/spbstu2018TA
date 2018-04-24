package com.spbstu.selenidePageObject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by dmitry on 04.04.2018.
 */

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String login;
    String password;
    String name;
}
