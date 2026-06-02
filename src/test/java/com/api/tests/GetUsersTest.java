package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUsersTest {

    @Test
    public void getUserTest() {

        Response response = RestAssured
                .given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .log().all()
                .when()
                .get("/users/1")
                .then()
                .extract()
                .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(
                response.jsonPath().getString("name"),
                "Leanne Graham"
        );
    }
}