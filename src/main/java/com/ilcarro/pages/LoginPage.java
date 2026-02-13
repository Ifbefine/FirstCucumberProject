package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

import java.util.Map;

import static io.opentelemetry.sdk.metrics.internal.data.EmptyExponentialHistogramBuckets.get;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

@FindBy(id = "email")
WebElement emailInput;
@FindBy(id = "password")
WebElement passwordInput;
    public LoginPage enterData(String email, String password) {
        type(emailInput, email);
        type(passwordInput, password);
        return this;
    }
@FindBy(css = "button[type='submit']")
WebElement yallaButton;
    public LoginPage clickOnYalla() {
        click(yallaButton);
        return this;
    }
@FindBy(css = "h2.message")
WebElement messageText;
    public LoginPage verifyMessage(String message) {
        assert shouldHaveText(messageText,message,7);
        return this;
    }

    public LoginPage enterWrongPassword(DataTable table) {
        List<Map<String,String>>dataTable=table.asMaps();

        String email=dataTable.get(0).get("email");
        String password = dataTable.get(0).get("password");
        enterData(email,password);
        return this;
    }
}
