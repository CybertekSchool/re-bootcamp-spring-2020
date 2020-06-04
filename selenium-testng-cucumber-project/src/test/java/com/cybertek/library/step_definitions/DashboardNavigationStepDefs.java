package com.cybertek.library.step_definitions;

import com.cybertek.library.utilities.common.LibraryConstants;
import com.cybertek.library.utilities.ui.BrowserUtils;
import com.cybertek.library.utilities.ui.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DashboardNavigationStepDefs extends BaseStep{
    @When("I go/navigate to {string} page")
    public void i_go_to_page(String page) {
        switch (page.toLowerCase()) {
            case LibraryConstants.DASHBOARD:
                pages.dashBoardPage().dashboard.click();
                break;
            case LibraryConstants.USERS:
                pages.dashBoardPage().users.click();
                break;
            case LibraryConstants.BOOKS:
                pages.dashBoardPage().books.click();
                break;
        }
    }
    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        BrowserUtils.wait(1);
        assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        switch (page.toLowerCase()) {
            case "users":
                String actual = pages.dashBoardPage().pageHeader.getText();

                actual = pages.dashBoardPage().pageHeader.getText();
                assertEquals("User Management", actual);
                break;
            case "books":
                actual = pages.dashBoardPage().pageHeader.getText();
                assertEquals("Book Management", actual);
                break;
        }
    }

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                pages.dashBoardPage().dashboard.click();
                break;
            case "users":
                pages.dashBoardPage().users.click();
                break;
            case "books":
                pages.dashBoardPage().books.click();
                break;
        }
    }
}
