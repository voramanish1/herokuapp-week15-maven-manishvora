package com.herokuapp.internet.pages;

import com.herokuapp.internet.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userNameField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//h2[text()=' Secure Area']")
    WebElement loginTextMessage;
    @FindBy(xpath = "//div[@id='flash']")
    WebElement userNameErrorMessage;
    @FindBy(xpath = "//div[@id='flash']")
    WebElement passwordErrorMessage;

    public void enterUserName(String userName) {
        Reporter.log("Entered username " + userName + " in username field " + userNameField.toString());
        sendTextToElement(userNameField, userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Entered password " + password + " in password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicked on login button " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String getLoginTextMessage() {
        return getTextFromElement(loginTextMessage);
    }

    public String getUserNameErrorMessage() {
        return getTextFromElement(userNameErrorMessage);
    }

    public String getPasswordErrorMessage() {
        return getTextFromElement(passwordErrorMessage);
    }
}
