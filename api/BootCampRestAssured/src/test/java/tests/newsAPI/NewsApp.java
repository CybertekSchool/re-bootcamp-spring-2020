package tests.newsAPI;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;

/**
 * @author : akbar
 * Created At : 7/2/20
 */
public class NewsApp {

    public static void main(String[] args) {

        //Response result =

        List<Headline> lst = given().accept(ContentType.JSON)
                .log().all()
                .baseUri("https://newsapi.org/v2")
                .queryParam("country", "us")
                .queryParam("category", "business")
                .queryParam("apiKey", "c0feb0bc81c74e9284814912f6ccaa4a").
                        when()
                .get("/top-headlines")
                .then()
                .log().all()
                .extract()
                .jsonPath()
                .getList("articles", Headline.class);;

//        System.out.println("lst = " + lst);
        lst.forEach(System.out::println);

    }

}
