package com.cybertek.library.utilities.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public interface AuthenticationUtility {

    Response getLoginResponse();

    String getToken();

    String getRedirectUrl();
}
