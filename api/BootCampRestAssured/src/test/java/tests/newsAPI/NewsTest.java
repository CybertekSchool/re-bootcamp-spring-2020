package tests.newsAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

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
            System.out.println("first article object = " + n1);

            // get entire article as a list
            List<NewsPOJO> articleLst = jPath.getList("articles",NewsPOJO.class) ;
            System.out.println("articleLst.size() = " + articleLst.size());
            articleLst.forEach(System.out::println);

            // from this point on its all java , no restassured involved
            // turn it into a method to generate your list of pojo
            // write another method to accept author name and print out all the articles by the author



    }

    @Test
    public void test2() {

        JsonPath jPath = given()
                .accept(ContentType.JSON)

                .queryParam("country", "us")
                .queryParam("category", "business")
                .queryParam("apiKey", "c0feb0bc81c74e9284814912f6ccaa4a").
                        when()
                .get("/top-headlines")
                .jsonPath();

        List<Headline> lstHeadline = jPath.getList("articles", Headline.class);
        lstHeadline.forEach(System.out::println);


    }




}
