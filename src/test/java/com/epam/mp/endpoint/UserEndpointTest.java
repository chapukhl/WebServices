package com.epam.mp.endpoint;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class UserEndpointTest {

    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");

        RestAssured.port = port == null ? 8080 :Integer.valueOf(port);

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/services/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

    @Test
    public void getAllUsersTest() {
        given().when().get("/users").then().statusCode(200).body(containsString("Luka_Chapukhin"));
    }

    @Test
    public void getUserTestByLogin() {
        given().when().get("/users/bordakan").then().statusCode(200).body(containsString("Bordak"));
    }

    @Test
    public void deleteUser() {
        given().when().delete("/users/chapukhl").then().statusCode(200);
    }

    @Test
    public void createUser() {
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Dima");
        user.put("lastName", "Pupkin");
        user.put("login", "pupkid");
        user.put("email", "Dima_Pupkid@epam.com");
        given().contentType("application/json").body(user).when().post("/users").then().statusCode(200);
    }
}
