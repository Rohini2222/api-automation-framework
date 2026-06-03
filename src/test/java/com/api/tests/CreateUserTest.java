package com.api.tests;

import com.api.base.BaseTest;
import com.api.utils.RequestSpecBuilderUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseTest {

       @Test
    public void createUserTest() {
        String requestBody = "{\n" +
        "\"name\":\"Rohini\",\n" +
        "\"job\":\"QA Engineer\"\n" +
        "}";
        Response response =RestAssured
        .given()
        .spec(RequestSpecBuilderUtil.getRequestSpec())
        .body(requestBody)
        .log().all()
        .when()
        .post("/users")
        .then()
        .log().all()
        .extract()
        .response();
    Assert.assertEquals(response.statusCode(), 201);

        
}}