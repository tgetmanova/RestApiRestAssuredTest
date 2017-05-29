package com.github.spb.tget.restassured.demo.tests;

import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequest;
import com.github.spb.tget.restassured.demo.tests.utils.SyncProfileRequestUtils;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SyncProfileRequestCreateTest extends SyncProfileRequestBaseTest {

    @BeforeClass
    public static void setupConnection(){
        RestAssured.port = 8080;
        RestAssured.basePath = "/profiles";
        RestAssured.baseURI = "http://localhost";
    }

    @DataProvider(name = "invalidLocalesAndCodes")
    public Object[][] getInvalidData() {
        return new Object[][]{{"RUU", "RUU"}, {"R3", "13"}, {"R", "L"}, {"R_", "*L"},
                {"R U", "()"}, {"", ""}, {null, null}, {"R ", "ESES"}, {"$5", "QQ"}};
    }

    @Test(dataProvider = "invalidLocalesAndCodes")
    public void invalidLocale_invalidCountryIsoCode_createSyncProfileRequest_shouldValidate(String locale, String countryIsoCode) {
        SyncProfileRequest profile = SyncProfileRequestUtils.generateValidSyncProfileRequest();
        profile.setLocale(locale);
        profile.setCountryIsoCode(countryIsoCode);

        given()
                .contentType("application/json")
                .and().body(profile)
                .when().post()
                .then().body(Matchers.containsString("The Sync Profile request is invalid:"));
    }
}
