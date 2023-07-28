import io.appium.java_client.AppiumDriver;
import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class BaseTest {
    static BasePage basePage;
    static LoginPage loginPage;
    static DrawingPage drawingPage;
    static HomePage homePage;
    static ProductPage productPage;
    static MyCartPage myCartPage;
    static AppiumDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:app", "C:/Users/Student-Day-1/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk");
        capabilities.setCapability("appium:udid", "emulator-5554");
        capabilities.setCapability("appium:platformVersion", "13.0");
        capabilities.setCapability("deviceOrientation", "PORTRAIT");

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        drawingPage = new DrawingPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        myCartPage = new MyCartPage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
