package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class MyCartPage extends BasePage {

    public String quantityText = "//android.view.ViewGroup[@content-desc=\"counter amount\"]/android.widget.TextView";
    public String itemPriceText = "product price";
    public String totalPrice = "total price";
    public String checkOutButton = "//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]";

    public MyCartPage(AppiumDriver driver) {
        super(driver);
    }
    public String getItemQuantity() {
        return driver.findElement(AppiumBy.xpath(quantityText)).getText();
    }
    public String getItemPrice() {
        return driver.findElement(AppiumBy.accessibilityId(itemPriceText)).getText().replaceAll("[^0-9]", "");
    }
    public String getTotalPrice() {
        return driver.findElement(AppiumBy.accessibilityId(totalPrice)).getText().replaceAll("[^0-9]", "");
    }
    public int convertPrice(String method){
        return Integer.parseInt(method);
    }
}
