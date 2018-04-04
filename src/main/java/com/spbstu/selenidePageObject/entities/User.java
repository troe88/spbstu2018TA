package com.spbstu.selenidePageObject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by dmitry on 04.04.2018.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String login;
    String password;
    String name;
}
