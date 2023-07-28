package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final AppiumDriver driver;
    public String sideBarLogInButton = "UiSelector().text(\"Log In\")";
    public String sideBarDrawingButton = "UiSelector().text(\"Drawing\")";
    public String headerText = "UiSelector().text(\"Products\")";
    public String sauceLabsBikeLight = "UiSelector().text(\"Sauce Labs Bike Light\")";

    @FindBy(className = "android.widget.ImageView")
    private WebElement sideBarButton;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void isVisibleByXpath(String element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                visibilityOfElementLocated(AppiumBy.xpath(element)));
    }
    public void isVisibleByUI(String element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                visibilityOfElementLocated(AppiumBy.androidUIAutomator(element)));
    }
    public void isVisibleByClass(String element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                visibilityOfElementLocated(AppiumBy.className(element)));
    }
    public void clickSideBarButton() {
        sideBarButton.click();
    }
    public void clickButtonByUI(String clickableButton) {
        isVisibleByUI(clickableButton);
        driver.findElement(AppiumBy.androidUIAutomator(clickableButton)).click();
    }
    public void clickButtonByXpath(String clickableButton) {
        isVisibleByXpath(clickableButton);
        driver.findElement(AppiumBy.xpath(clickableButton)).click();
    }
    public String getPageHeaderText(String headerText) {
        isVisibleByUI(headerText);
        return driver.findElement(AppiumBy.androidUIAutomator(headerText)).getText();
    }
}