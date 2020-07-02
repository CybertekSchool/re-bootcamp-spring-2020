package tests.basic_test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchQueryParam {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test1(){

        given()
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("gender","Female").
        when()
                .get("/spartans/search").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                // getting all the gender and testing the list does not contain Male
                .body("content.gender", not( contains("Male") ) )
        ;



    }

    @Test
    public void test2(){


        Response res =
            given()
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("gender","Female").
        when()
                .get("/spartans/search")

            ;
        int numOfElmField = res.jsonPath().getInt("numberOfElements") ;
        System.out.println("numOfElmField = " + numOfElmField);
        boolean pageSorted = res.jsonPath().getBoolean("pageable.sort.sorted") ;
        System.out.println("pageSorted = " + pageSorted);

        String nameOf3rdPerson = res.jsonPath().getString("content[2].name") ;
        System.out.println("nameOf3rdPerson = " + nameOf3rdPerson);

        List<String> allNames = res.jsonPath().getList("content.name");
        System.out.println("allNames = " + allNames);


    }




}
