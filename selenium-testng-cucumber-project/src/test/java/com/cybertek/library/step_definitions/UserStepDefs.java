package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.api.Endpoints;
import com.cybertek.library.utilities.api.LibrarianAuthenticationUtility;
import com.cybertek.library.utilities.common.Environment;
import com.cybertek.library.utilities.common.LibraryConstants;
import com.cybertek.library.utilities.common.LibraryUserUtility;
import com.cybertek.library.utilities.ui.BrowserUtils;
import com.cybertek.library.utilities.ui.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserStepDefs extends BaseStep {


    @Given("new {word} user is available")
    @Given("new {word} is added using the add_user endpoint")
    public void new_student_is_added_using_the_add_user_endpoint(String userType) {
        // get a token
        authenticationUtility = new LibrarianAuthenticationUtility();
        String librarianToken = authenticationUtility.getToken();
        // create new user information
        if (userType.equalsIgnoreCase(LibraryConstants.LIBRARIAN)) {
            user = LibraryUserUtility.createUser(2);
        } else if (userType.equalsIgnoreCase(LibraryConstants.STUDENT)) {
            user = LibraryUserUtility.createUser(3);
        }
        // create using using the add_user
        Response response = given().
                header("x-library-token", librarianToken).
                formParams(user).
                log().all().
                when().
                post(Endpoints.ADD_USER).
                prettyPeek();
        response.then().statusCode(200);
        user.put("id", response.path("id"));
    }

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        BrowserUtils.waitForClickability(pages.usersPage().search, 5);
        pages.usersPage().search.sendKeys(searchString);
        BrowserUtils.wait(1);
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String expectedString) {

        int size = pages.usersPage().allUserIds.size();
        for (int i = 0; i < size; i++) {
            String id = pages.usersPage().allUserIds.get(i).getText().toLowerCase();
            String name = pages.usersPage().allFullNames.get(i).getText().toLowerCase();
            String email = pages.usersPage().allEmails.get(i).getText().toLowerCase();


            boolean found = id.contains(expectedString) ||
                    name.contains(expectedString) ||
                    email.contains(expectedString);
            assertTrue( found,"Expedted string was not found in table: " + expectedString);
        }

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnsNames) {
        List<String> actualColumnsNames = BrowserUtils.getElementsText(pages.usersPage().columnNames);
        assertEquals(expectedColumnsNames, actualColumnsNames);

    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        String actual = pages.usersPage().getShowRecords().getFirstSelectedOption().getText();
        assertEquals(selected + "", actual);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        List<WebElement> webElements = pages.usersPage().getShowRecords().getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(webElements);
        assertEquals(options, elementsText);

    }

    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {
        pages.usersPage().getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(int expectedCount) {
        BrowserUtils.wait(1);
        int actualCount = pages.usersPage().allRows.size();
        assertEquals(expectedCount, actualCount);

    }

}





