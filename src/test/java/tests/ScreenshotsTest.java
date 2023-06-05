package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import java.io.File;
import java.io.IOException;

import static navigation.ApplicationURLs.LOGIN_URL;

public class ScreenshotsTest extends TestBase{
//    @TmsLink("ID-2")
//    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to take some screenshots")
    public void screenshotAfterCorrectLoggingIn() {

        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerIsDisplayed();
                File srcFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}