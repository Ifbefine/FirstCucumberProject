package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import com.ilcarro.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.ilcarro.pages.BasePage.driver;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    LoginPage login;
    @And("User clicks on Login link")
    public void click_on_login_link() {
        new HomePage(driver).clickOnLoginLink();
    }

    @And("User enters correct data")
    public void enter_correct_data() {
        login=new LoginPage(driver);
        login.enterData("test123456789@gm.com","Test123456789@");
    }
    @And("User cliks on Yalla button")
    public void click_on_yalla_button() {
        login.clickOnYalla();
    }

    @Then("User veriffies Success message is displayed")
    public void verify_Success_login(){
        login.verifyMessage("Logged in Success");
    }
    @And("User enters correct email and wrong password")
    public void enter_wrong_password(DataTable table){
        login=new LoginPage(driver);
        login.enterWrongPassword(table);
    }
    @Then("User verifies Error message is displayed")
    public void verify_Error_login(){
        login.verifyMessage("Login or Password incorrect");
    }
}
