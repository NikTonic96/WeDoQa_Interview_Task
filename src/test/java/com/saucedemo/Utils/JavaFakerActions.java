package com.saucedemo.Utils;

import com.github.javafaker.Faker;

public class JavaFakerActions {

    private static final Faker faker = new Faker();

    /**
     * Provides fake random first name
     */
    public static String generateRandomName() {
        return faker.name().firstName();
    }

    /**
     * Provides fake random surname
     */
    public static String generateRandomSurname() {
        return faker.name().lastName();
    }

    /**
     * Provides fake random postal code
     */
    public static String generateRandomPostalCode() {
        return faker.address().zipCode();
    }
}