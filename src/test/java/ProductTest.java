import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    @DisplayName("User sort items and add to cart")
    public void userSortItemsAndAddToCart() {

        basePage.clickButtonByXpath(homePage.sortButton);
        basePage.clickButtonByUI(homePage.sortPriceAsc);
        Assertions.assertEquals("$7.99", homePage.getFirstItemsListPrice());

        basePage.clickButtonByUI(basePage.sauceLabsBikeLight);
        Assertions.assertEquals("Sauce Labs Bike Light", basePage.getPageHeaderText(basePage.sauceLabsBikeLight));
        productPage.clickPlusButton();
        Assertions.assertEquals("2", productPage.getItemQuantity());

        basePage.clickButtonByXpath(productPage.addToCartButton);
        basePage.clickButtonByXpath(productPage.headerCartButton);
        Assertions.assertEquals(myCartPage.convertPrice(myCartPage.getTotalPrice()),
                myCartPage.convertPrice(myCartPage.getItemQuantity()) *
                        myCartPage.convertPrice(myCartPage.getItemPrice()));
        basePage.clickButtonByXpath(myCartPage.checkOutButton);
    }
}