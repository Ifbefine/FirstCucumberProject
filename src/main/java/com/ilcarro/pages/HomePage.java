package com.ilcarro.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    HomePage home;


    @Given("User launches Chrome browser")
    public void launch_Chrome_browser(){
        home = new HomePage(driver);
        home.launchBrowser();
    }

    @When("User opens ilcarro HomePage")
    public void open_ilcarro_HomePage(){
        home.openUrl();
    }

    @Then("User verifies HomePage title is displayed")
public void verify_HomePage_title(){
        new HomePage(driver).isHomePageTitleDisplayed();
    }
@FindBy(css = "h1")
    WebElement title;

    public HomePage isHomePageTitleDisplayed() {
        assert  isElementVisible(title);
        return this;

    }
@FindBy(css = ".navigation-link:nth-child(6)")
WebElement loginLink;
    public LoginPage clickOnLoginLink() {
        click(loginLink);
    return new LoginPage(driver);
    }
}
