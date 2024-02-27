package com.saucedemo.Utils;

import com.github.javafaker.Faker;

public class JavaFakerActions {

    private static final Faker faker = new Faker();

    public static String generateRandomName() {
        return faker.name().firstName();
    }

    public static String generateRandomSurname() {
        return faker.name().lastName();
    }

    public static String generateRandomPostalCode() {
        return faker.address().zipCode();
    }
}
