package tests.basic_test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpartanHelloTests {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test(){
        assertEquals(1, 2-1);
    }

    @Test
    public void testHello(){

        given(). //  RequestSpecification
                //  RequestSpecification
        when().
                get("/hello"). // Response
        then().       // ValidatableResponse
                statusCode(200).
                contentType(ContentType.TEXT).
                body(equalTo("Hello from Sparta"))

        ;
    }


    @Test
    public void testHelloEndPoint(){

        given(). //  RequestSpecification
        when().
                get("/hello"). // Response
        then().                     // ValidatableResponse
                statusCode(200).
                contentType(ContentType.TEXT).
                body( equalTo("Hello from Sparta") )


        ;

    }

    @Test
    public void testHelloEndPoint2(){

        given().
                log().all().
        when().
                get("/hello").
        then().
                log().all().
                statusCode(200).
                contentType(ContentType.TEXT).
                body(equalTo("Hello from Sparta"));


    }

    @Test
    public void testHelloEndPoint3(){

        given().
                log().all().
        when().
                get("/hello").
        then().
                log().all().
                statusCode( is(200) ).
                header("Content-Type","text/plain;charset=UTF-8").
                header("Date",not( nullValue() ) ). // workaround for header exists
                header("NonExistingHeader", nullValue() ).
                body(is("Hello from Sparta"));


    }



}
