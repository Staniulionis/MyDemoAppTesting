package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LoginPage extends BasePage {
    public String unInputField = "UiSelector().index(3)";
    public String pwInputField = "UiSelector().index(6)";
    public String loginButton = "UiSelector().index(9)";
    public String validUsername = "bob@example.com";
    public String validPassword = "10203040";
    public String errorMessageClass = "android.widget.TextView";

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }
    public void userEntersTextInInputField(String field, String credential) {
        isVisibleByUI(field);
        driver.findElement(AppiumBy.androidUIAutomator(field)).sendKeys(credential);
    }
    public String getErrorMessageText(int classIndex) {
        isVisibleByClass(errorMessageClass);
        return driver.findElements(AppiumBy.className(errorMessageClass)).get(classIndex).getText();
    }
}
