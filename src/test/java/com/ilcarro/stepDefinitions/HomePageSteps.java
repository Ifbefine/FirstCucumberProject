package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.ilcarro.pages.BasePage.driver;

public class HomePageSteps {

    HomePage home;

    @Given("User launches Chrome browser")
    public void launch_Chrome_browser() {
        home = new HomePage(driver);
        home.launchBrowser();
    }

    @When("User opens ilcarro HomePage")
    public void open_ilcarro_HomePage() {
        home.openUrl();
    }

    @Then("User verifies HomePage title is displayed")
    public void verify_HomePage_title() {
        new HomePage(driver).isHomePageTitleDisplayed();
    }

    @Then("User verifies that {int} links are present in the navigation bar:")
    public void user_Verifies_navigation_links(int expectedCount,io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedLinks = dataTable.asList(String.class);
        List<WebElement> actualLinks = driver.findElements(By.className("navigation-link"));
        Assert.assertEquals("Количество ссылок не совпадает =>", expectedCount, actualLinks.size());
    }

    @And("User closes browser")
    public void quit_browser() {
        new HomePage(driver).quitBrowser();
    }
}