package com.github.spb.tget.restassured.demo.tests;

import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequest;
import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequestUtils;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public  class SyncProfileRequestGetTest {

    @BeforeClass
    public static void setupRestAssured() {

        RestAssured.port = 2828;
        RestAssured.basePath = "/api/TestApi";
        RestAssured.baseURI = "http://localhost/";
    }

    @Test
    public void getAllProfiles_ShouldReturn200Ok() {
        given()
            .when().get()
            .then().statusCode(200);
    }

    @Test
    public void newlyCreatedProfile_ShouldBeReturned() {
        SyncProfileRequest profile = SyncProfileRequestUtils.generateValidSyncProfileRequest();

        RestAssured.given()
                .contentType("application/json")
                .and().body(profile)
                .post();

        given()
                .when().get(profile.getUserId().toString())
                .then().statusCode(200)
                        .and().body("Locale", Matchers.equalTo(profile.getLocale()))
                        .and().body("CountryIsoCode", Matchers.equalTo(profile.getCountryIsoCode()));
    }

}
