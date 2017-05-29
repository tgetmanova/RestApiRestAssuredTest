package com.github.spb.tget.restassured.demo.tests;

import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequest;
import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequestUtils;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public  class SyncProfileRequestGetTest extends SyncProfileRequestBaseTest {

    @Test
    public void getAllProfiles_ShouldReturn200Ok() {
        given()
            .when().get()
            .then().statusCode(200);
    }

    @Test
    public void newlyCreatedProfile_ShouldBeReturned() {
        SyncProfileRequest profile = SyncProfileRequestUtils.generateValidSyncProfileRequest();

        given()
                .contentType("application/json")
                .and().body(profile)
                .post();

        given()
                .when().get(profile.getUserId().toString())
                .then().statusCode(200)
                .and().body("locale", Matchers.equalTo(profile.getLocale().toString()))
                .and().body("countryIsoCode", Matchers.equalTo(profile.getCountryIsoCode().toString()))
                .and().body("userId", Matchers.equalTo(profile.getUserId().toString()));
    }

    @Test
    public void nonExistingProfile_ShouldReturn404NotFound() {
        String nonExistingUserId = UUID.randomUUID().toString();

        given()
                .when().get(nonExistingUserId)
                .then().statusCode(404)
                .and().body(Matchers.containsString(String.format("Profile with ID: %s is not found", nonExistingUserId)));
    }
}
