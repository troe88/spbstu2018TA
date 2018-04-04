package com.spbstu.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.spbstu.selenidePageObject.entities.User;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by dmitry on 04.04.2018.
 */
public class ResourceLoader {

    private static Map<String, User> USERS;

    static {
        load();
    }

    @SneakyThrows
    private static void load() {
        FileReader fileReader = new FileReader(ResourceLoader.class.getClassLoader().getResource("data/users.json").getFile());
        JsonReader jsonReader = new JsonReader(fileReader);

        Type type = new TypeToken<Map<String, User>>() {
        }.getType();

        USERS = new Gson().fromJson(jsonReader, type);
    }

    public static User getUser(String userId) {
        return USERS.get(userId);
    }
}
