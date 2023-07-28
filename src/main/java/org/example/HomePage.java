package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public String sortButton = "//android.view.ViewGroup[@content-desc=\"sort button\"]/android.widget.ImageView";
    public String sortPriceAsc = "UiSelector().text(\"Price - Ascending\")";
    public String onesieItemText = "UiSelector().text(\"Sauce Labs Onesie\")";

    public HomePage(AppiumDriver driver) {
        super(driver);
    }
    public String getFirstItemsListPrice() {
        isVisibleByUI(onesieItemText);
        return driver.findElements(By.className("android.widget.TextView")).get(2).getText();
    }
}
