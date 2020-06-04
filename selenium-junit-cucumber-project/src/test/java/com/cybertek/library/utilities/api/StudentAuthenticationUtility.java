package com.cybertek.library.utilities.api;

import com.cybertek.library.utilities.common.Encoder;
import com.cybertek.library.utilities.common.Environment;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StudentAuthenticationUtility implements AuthenticationUtility {
    private static Response response;
    private String token;
    private String redirectUrl;

    @Override
    public Response getLoginResponse() {
        if (response == null) {
            String username = Environment.getProperty("student_email");
            String password = Environment.getProperty("student_password");
            password = Encoder.decrypt(password);
            response = given().
                    formParam("email", username).
                    formParam("password", password).
                    log().all().
                when().
                    post(Endpoints.LOGIN).prettyPeek();
            response.then().statusCode(200);
        }
        return response;
    }

    @Override
    public String getToken() {
        if (token == null) {
            token = response.jsonPath().getString("token");
        }
        return token;
    }

    @Override
    public String getRedirectUrl() {
        if (redirectUrl == null) {
            redirectUrl = response.jsonPath().getString("redirect_uri");
        }
        return redirectUrl;
    }
}
