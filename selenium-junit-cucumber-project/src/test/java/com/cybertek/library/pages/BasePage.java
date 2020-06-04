package com.cybertek.library.pages;

import com.cybertek.library.utilities.ui.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='title'][.='Users']")
    public WebElement users;

    @FindBy(xpath = "//span[@class='title'][.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//span[@class='title'][.='Books']")
    public WebElement books;

    @FindBy(tagName = "h3")
    public WebElement pageHeader;

    @FindBy(css = "#navbarDropdown>span")
    public WebElement accountHolderName;

    @FindBy(linkText = "Log Out")
    public WebElement logOutLink;

    public void logOut(){
        accountHolderName.click();
        logOutLink.click();
    }

}
