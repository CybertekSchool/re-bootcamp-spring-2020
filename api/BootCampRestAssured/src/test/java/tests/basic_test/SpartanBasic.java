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
public class SpartanBasic {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }
    @Test
    public void test1(){

//        give()  some request specification
//         when()  sending a request with http verb
//          then()  result should be as you expected
        given().
        when().  // RequestSpecification
                get("/hello"). // Response
        then(). // ValidatableResponse
                statusCode(200);

    }


    @Test
    public void test2(){

//        give()  some request specification
//         when()  sending a request with http verb
//          then()  result should be as you expected
        given().
//                log().all().   // this is logging request only
            log().ifValidationFails().
        when().  // RequestSpecification
                get("/hello"). // Response
        then(). // ValidatableResponse
                log().all().  // this is logging response only
                statusCode(200)
        ;

    }

    @Test
    public void test3(){

        Response res = get("/hello");
        System.out.println( res.statusCode() );
        System.out.println( res.getContentType() );
        System.out.println( res.getHeader("Date") );

        assertEquals(200, res.statusCode());


    }




}
