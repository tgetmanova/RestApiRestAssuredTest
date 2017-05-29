package com.github.spb.tget.restassured.demo.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class SyncProfileRequestBaseTest {

    @BeforeClass
    public static void setupRestAssured() {

        RestAssured.port = 8080;
        RestAssured.basePath = "/profiles";
        RestAssured.baseURI = "http://localhost";
    }
}
