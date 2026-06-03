package com.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.api.base.BaseTest;
import com.api.utils.RequestSpecBuilderUtil;

public class GetUsersTest extends BaseTest {

    @Test
    public void getUserTest() {

        Response response = RestAssured
                .given()
                .spec(RequestSpecBuilderUtil.getRequestSpec())
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