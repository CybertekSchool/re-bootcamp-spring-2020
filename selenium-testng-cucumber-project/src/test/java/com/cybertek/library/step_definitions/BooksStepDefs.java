package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.api.AuthenticationUtility;
import com.cybertek.library.utilities.api.Endpoints;
import com.cybertek.library.utilities.api.LibrarianAuthenticationUtility;
import com.cybertek.library.utilities.db.DBUtils;
import com.cybertek.library.utilities.ui.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class BooksStepDefs extends BaseStep {
    @Then("book information must match the api for {}")
    public void book_information_must_match_the_api_for_The_kite_runner(String book) {
        // call the database to get the book id for
        String query = "SELECT id FROM books WHERE name = '" + book + "'";
        String id = DBUtils.getCellValue(query).toString();
        // get the token
        AuthenticationUtility authenticationUtility = new LibrarianAuthenticationUtility();
        String token = authenticationUtility.getToken();
        // use the id to make the call to api
        Response response = given().
                log().all().
                header("x-library-token", token).
                pathParam("id", id).
                when().
                get(Endpoints.GET_BOOK_BY_ID).
                prettyPeek();
        // verify response vs ui
        response.then().statusCode(200).contentType(ContentType.JSON);
        Book bookPojo = response.as(Book.class);

        assertThat(bookPojo.getName(), is(pages.booksPage().bookName.getAttribute("value")));
        assertThat(bookPojo.getAuthor(), is(pages.booksPage().author.getAttribute("value")));
        assertThat(bookPojo.getIsbn(), is(pages.booksPage().isbn.getAttribute("value")));
        assertThat(bookPojo.getDescription(), is(pages.booksPage().description.getAttribute("value")));

    }

    @When("I open book {}")
    public void i_edit_book_The_kiterunner(String book) {
        System.out.println("book = " + book);
        BrowserUtils.waitForClickability(pages.booksPage().search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(pages.booksPage().editBook(book), 5).click();

    }

    @Then("book information must match the database for {}")
    public void book_information_must_match_the_database_for_The_kite_runner(String book) {

        String sql = "SELECT b.isbn, b.year, b.author, bc.name, b.description\n" +
                "FROM books b\n" +
                "JOIN book_categories bc\n" +
                "ON b.book_category_id = bc.id\n" +
                "WHERE b.name = '" + book + "';";
        Map<String, Object> dbData = DBUtils.getRowMap(sql);

        DBUtils.getColumnNames(sql);

        assertEquals(dbData.get("author").toString(), pages.booksPage().author.getAttribute("value"), "author did not match");
        assertEquals(dbData.get("year").toString(), pages.booksPage().year.getAttribute("value"), "year did not match");
        assertEquals(dbData.get("isbn").toString(), pages.booksPage().isbn.getAttribute("value"), "isbn did not match");
        assertEquals(dbData.get("description").toString(), pages.booksPage().description.getAttribute("value"), "description did not match");
        assertEquals(dbData.get("name").toString(), pages.booksPage().categoryList().getFirstSelectedOption().getText(), "category did not match" );
    }

    @Then("book categories must match book_categories table from db")
    public void book_categories_must_match_book_categories_table_from_db() {
        // get the expected categories from the database as a list
        String sql = "SELECT name FROM book_categories;";
        List<Object> namesObj = DBUtils.getColumnData(sql, "name");
        List<String> exNames = new ArrayList<>();
        for (Object o : namesObj) {
            exNames.add(o.toString());
        }
        // get the actual categories from UI as webelements
        // convert the web elements to list
        List<WebElement> optionsEl = pages.booksPage().mainCategoryList().getOptions();
        List<String> acNames = BrowserUtils.getElementsText(optionsEl);
        // remove the first option ALL from acList.
        acNames.remove(0);
        // compare 2 lists
        assertEquals( exNames, acNames, "Categories did not match");
    }
}
