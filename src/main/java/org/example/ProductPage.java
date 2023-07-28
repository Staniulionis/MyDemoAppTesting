package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter amount\"]/android.widget.TextView")
    private WebElement quantityText;

    public String addToCartButton = "//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]";
    public String headerCartButton = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView";

    public ProductPage(AppiumDriver driver) {
        super(driver);
    }
    public void clickPlusButton() {
        driver.findElement(AppiumBy.accessibilityId("counter plus button")).click();
    }
    public String getItemQuantity() {
        return quantityText.getText();
    }
}
