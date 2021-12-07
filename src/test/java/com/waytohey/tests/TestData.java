package com.waytohey.tests;

import com.github.javafaker.Faker;
import com.waytohey.pages.User;

import static com.waytohey.config.Project.projectConfig;

public class TestData {
    static Faker faker = new Faker();
    public static String nameRandom = faker.name().firstName(),
            emailRandom = faker.internet().emailAddress();
    //static String  login_correct = projectConfig.login_correct();
    //static String password_correct = projectConfig.password_correct();
    public static User userOK = new User(projectConfig.login_correct(), projectConfig.password_correct());
    public static User userWrongLog = new User("valentina715153", "qweqwe");

    public static User userRandom = new User(nameRandom, emailRandom, "34");


}
