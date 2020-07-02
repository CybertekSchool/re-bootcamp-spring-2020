package tests.newsAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * @author : akbar
 * Created At : 7/2/20
 */
public class NewsTest {


    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = "https://newsapi.org";
        RestAssured.basePath = "/v2";
    }


    @Test
    public void test(){

        JsonPath jPath = given()
                .accept(ContentType.JSON)
                .log().all()
                .queryParam("country", "us")
                .queryParam("category", "business")
                .queryParam("apiKey", "c0feb0bc81c74e9284814912f6ccaa4a").
                        when()
                .get("/top-headlines")
                .jsonPath();


           String firstAuthor =  jPath.getString("articles[0].author");
            System.out.println("firstAuthor = " + firstAuthor);
         String firstTitle =  jPath.getString("articles[0].title");
            System.out.println("firstTitle = " + firstTitle);

            NewsPOJO n1 = jPath.getObject("articles[0]", NewsPOJO.class) ;


    }



}
