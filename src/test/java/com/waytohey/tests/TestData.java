package com.waytohey.tests;

import com.github.javafaker.Faker;
import com.waytohey.pages.User;

public class TestData {
   static Faker faker = new Faker();
   public static String nameRandom = faker.name().firstName(),
                     emailRandom = faker.internet().emailAddress();

   public static User userOK = new User("valentina71515","r347b7");
   public static User userWrongLog = new User("valentina715153","qweqwe");

   public static User userRandom = new User(nameRandom,  emailRandom);



}
