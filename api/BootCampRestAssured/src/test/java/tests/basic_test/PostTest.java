package tests.basic_test;

import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.pojo.Spartan;
import tests.pojo.SpartanPojo;


import java.io.File;
import java.util.*;

/**
 * @author : akbar
 * Created At : 7/1/20
 */
public class PostTest {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }
    @Test
    public void add1SpartanTest1(){

        String data = "{\n" +
                "  \"name\"   : \"Bootcamp user\",\n" +
                "  \"gender\" : \"Male\",\n" +
                "  \"phone\"  : 2131231231\n" +
                "}" ;

        given()
                .log().all()
                .contentType(ContentType.JSON) // extremely important for server to know whats the contenttpe you are sending
                .body(data).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
                .body("success",is("A Spartan is Born!"))
                .body("data.name",is("Bootcamp user") )
                .body("data.gender",equalTo("Male"))
        ;

    }

    @Test
    public void add1SpartanTest2(){

        Map<String,Object> data = new LinkedHashMap<>(); //HashMap
        data.put("name","Sample name");
        data.put("gender","Male");
        data.put("phone",1931231231);


        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(data).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED) // you can replace with 201
                .body("success",is("A Spartan is Born!"))
                .body("data.name",is("Sample name") )
                .body("data.gender",equalTo("Male"))
        ;

    }

    @Test
    public void add1SpartanTest3(){

        //Spartan sp = new Spartan("Sample name","Male",1931231231);
        SpartanPojo sp = new SpartanPojo("Sample name","Male",1931231231);
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .body("success",is("A Spartan is Born!"))
                .body("data.name",is("Sample name") )
                .body("data.gender",equalTo("Male"))

        ;

    }

    @Test
    public void add1SpartanTest4(){

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(new File("data.json")).
        when()
                .post("/spartans").
        then()
                .log().all()
                .statusCode(201)
       ;
    }

    @Test
    public void add1SpartanTest5(){

        SpartanPojo sp = new SpartanPojo("Sample name","Male",1931231231);
        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(sp).
        when()
                .post("/spartans").
                then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .body("success",is("A Spartan is Born!"))
                .body("data.name",is("Sample name") )
                .body("data.gender",equalTo("Male"))

        ;

    }



}
