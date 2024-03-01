package com.saucedemo.api_tests;

import com.saucedemo.Utils.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class User {

    private final String token = ConfigurationReader.getProperty("token");
    private final String baseURL = ConfigurationReader.getProperty("base.url");
    private String userId;
    private final String userEndpoint = "public/v2/users/";
    private final String newUser = "{\"id\":\"67300002," +
            "\"name\":\"Bhuvaneshwar\"," +
            "\"email\":\"pothuvaal_ret_bhuvaneshwar@gleichner.test\"," +
            "\"gender\":\"female\",\"status\":\"inactive\"}";
    private final String updatedUserDetails = "{\"id\":\"673218523223323," +
            "\"name\":\"Random\"," +
            "\"email\":\"Random@gleichner.test\"," +
            "\"gender\":\"female\",\"status\":\"inactive\"}";

    @DisplayName("POST request create user")
    @Test
    public void createUserTest() {
        RestAssured.baseURI = baseURL;
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(newUser)
                .post(userEndpoint);

        userId = response.jsonPath().getString("id");

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
        System.out.println("userId = " + userId);
    }

    @DisplayName("GET request to get user details")
    @Test
    public void getUserDetails() {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .get("/public/v2/users/2139130");

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }

    @DisplayName("PUT request updates user details")
    @Test
    public void updateUserDetails() {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(updatedUserDetails)
                .put(userEndpoint + userId);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }

    @DisplayName("DELETE request deletes user")
    @Test
    public void deleteUser() {
        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(updatedUserDetails)
                .delete(userEndpoint);

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}