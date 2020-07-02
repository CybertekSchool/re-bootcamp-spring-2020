package tests.serialzie_deserialzie;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.pojo.SpartanPojo;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class ExtractResponse {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test1(){

       Response res =
            given()
                    .log().uri()
                    .accept(ContentType.JSON).
            when()
                    .get("/spartans")

        ;

        List<String> allNames = res.jsonPath().getList("name") ;
        List<String> allPhones = res.jsonPath().getList("phone") ;


        System.out.println("allNames = " + allNames);
        System.out.println("allPhones = " + allPhones);


    }

    @Test
    public void test2(){

     SpartanPojo sp1 =
        given()
                .log().uri()
                .accept(ContentType.JSON).
        when()
                .get("/spartans/213").
        then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("name",is("EBC") )
                .extract()
                .as(SpartanPojo.class)

        ;
        System.out.println("sp1 = " + sp1);


    }


    @Test
    public void test3(){

        List listOfLinkedHashMap =
                    when()
                        .get("/spartans")
                        .as(List.class)
                ;
        System.out.println("listOfLinkedHashMap = " + listOfLinkedHashMap);


    }



    @Test
    public void test4(){

        List<SpartanPojo> listOfSpartan =
                when()
                        .get("/spartans")
                        .as(new TypeRef<List<SpartanPojo>>() {
                        })
                ;
        System.out.println("List<SpartanPojo> = " + listOfSpartan);


    }




}
