package tests.schema;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tests.utilities.ConfigurationReader;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "http://52.205.194.10:8000";
        RestAssured.basePath = "/api";
        // this is how we can add basic auth for entire test
        RestAssured.authentication = basic("user", "user");
    }

    /*
     * Given user with valid credentials provided
     * when user send get request to /spartans/{id}
     * then the response json format should match the schema SingleSpartanSchema.json
     *
     * */
    @Test
    public void SingleSpartanResponse_JsonSchema_Test() {
        given()
                .log().all().
        when()
                .get("/spartans/213")
        .then()
                .log().all()
                .assertThat()
                .body( matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));

    }

    /*
     * Given user with valid credentials provided
     * when user send get request to /spartans
     * then the response json format should match the schema SpartanArraySchema.json
     *
     * */
    @Test
    public void AllSpartanResponse_JsonSchema_Test() {

        given()
                .log().all()
                .contentType(ContentType.JSON).
                when()
                .get("/spartans").
                then()
                .log().all()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema("SpartanArraySchema.json"));

    }

    /*
     * Given user with valid credentials provided
     * when user send get request to /spartans/search
     * then the response json format should match the schema SearchResultSchema.json
     *
     * */
    @Test
    public void SearchSpartanResponse_JsonSchema_Test() {

        given()
                .log().all()
                .queryParam("gender", "female").
                when()
                .get("/spartans/search").
                then()
                .log().all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("SearchResultSchema.json"));

    }


    @AfterAll
    public static void tearDown() {
        RestAssured.reset();
    }


}