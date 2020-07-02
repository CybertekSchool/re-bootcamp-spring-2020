package tests.basic_test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import tests.pojo.Spartan;

public class SingleSpartan {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }
/*
* given accept header is json
* when sending a get request to /spartans/:someValidID
* we should get 200OK
* we should get json response
* we should get
* */
    @Test
    public void test1(){

        given()
                .log().uri()
                .accept(ContentType.JSON)
                .pathParam("myID",213).
        when()
                .get("/spartans/{myID}").
        then()
                .statusCode(200)
                .log().all()
                .contentType(ContentType.JSON)
                .body("name", is("EBC"))
                .body("gender", is("Male"))

        ;

    }

    @Test
    public void test2(){


        given()
                .log().uri()
                .accept(ContentType.JSON).
                        when()
                .get("/spartans/{myID}", 213).
         then()
                .log().all()
                .body("name", is("EBC"))
                ;

    }




}
