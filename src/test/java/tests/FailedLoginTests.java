package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase{
    @Issue("DEFECT-1")
    @TmsLink("ID-1")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test to log in using not proper username and password" +
            " and check if warning message Invalid username or password is displayed")
    public void asUserTryToLoginWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("NotExistingUserName")
                .typeIntoPasswordField("NotCorrectPassword")
                .clickOnLoginButton();
        loginPage
                .assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }
}