package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {
    @FindBy(id = "user_count")
    public WebElement userCount;

    @FindBy(id = "book_count")
    public WebElement bookCount;

    @FindBy(id = "borrowed_books")
    public WebElement borrowedBooksCount;
}
