package tests.serialzie_deserialzie;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.pojo.Spartan;
import tests.pojo.SpartanPojo;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author : akbar
 * Created At : 7/2/20
 */
public class SingleSpartanJsonToPojo {

    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "http://52.205.194.10";
        RestAssured.port = 8000 ;
        RestAssured.basePath = "/api";
    }

    @Test
    public void test1() {


        SpartanPojo sp1 = given()
                .log().uri()
                .accept(ContentType.JSON)
                .pathParam("myID", 213).
                when()
                .get("/spartans/{myID}")
                .as(SpartanPojo.class)
         ;

        System.out.println("sp1 = " + sp1);

    }


    @Test
    public void test2() {


        SpartanPojo[] spArr =
                given()
                        .log().uri()
                        .accept(ContentType.JSON).
                        when()
                        .get("/spartans")
                        .as(SpartanPojo[].class);

        System.out.println("spArr.length = " + spArr.length );
        System.out.println("spArr[0].getName() = " + spArr[0].getName());
        System.out.println("spArr[0].getId() = " + spArr[0].getId());



    }


    @Test
    public void test3() {


                List<SpartanPojo> lst =
                given()
                        .log().uri()
                        .accept(ContentType.JSON).
                when()
                        .get("/spartans")
                        .jsonPath()
//                        .getList("") -->> this will give you List of LinkedHashmap
                        .getList("", SpartanPojo.class);

        System.out.println("lst = " + lst);
        System.out.println("lst.get(1).getName() = " + lst.get(1).getName() );


    }

    @Test
    public void test4() {


    // save the result as a map


        Map<String, Object> myMap =
        given()
                .log().uri()
                .accept(ContentType.JSON).
        when()
                .get("/spartans/213")
                .jsonPath().getMap("") ;

        System.out.println("myMap = " + myMap);


    }



}



