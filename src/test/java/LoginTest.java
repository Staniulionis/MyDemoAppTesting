import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("User enters valid credentials and successfully logged in ")
    void userLogsInSuccessfully() {

        basePage.clickSideBarButton();
        basePage.clickButtonByUI(basePage.sideBarLogInButton);
        loginPage.userEntersTextInInputField(loginPage.unInputField, loginPage.validUsername);
        loginPage.userEntersTextInInputField(loginPage.pwInputField, loginPage.validPassword);
        basePage.clickButtonByUI(loginPage.loginButton);
        Assertions.assertEquals("Products", basePage.getPageHeaderText(basePage.headerText));
    }
    @ParameterizedTest
    @DisplayName("User enters valid credentials and unsuccessfully logged in ")
    @CsvSource({"bob@example.com, myapp1159753, Provided credentials do not match any user in this service., 4",
                "bob@example.com, '', Password is required, 4",
                "'', myapp1159753, Username is required, 3"})
    void userLogsInUnsuccessfully(String un, String pw, String errMsg, int indexNumber) {
        basePage.clickSideBarButton();
        basePage.clickButtonByUI(basePage.sideBarLogInButton);
        loginPage.userEntersTextInInputField(loginPage.unInputField, un);
        loginPage.userEntersTextInInputField(loginPage.pwInputField, pw);
        basePage.clickButtonByUI(loginPage.loginButton);
        Assertions.assertEquals(errMsg, loginPage.getErrorMessageText(indexNumber));
    }
}