package utils;

import driver.manager.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class ScreenShotMaker {
    @Attachment(value = "Page screenshot test failure",type="image/png")
    public static byte[] makeScreenShot() {
        byte[] screenshotFile = ((TakesScreenshot) DriverManager.getWebDriver()).getScreenshotAs(BYTES);
        return screenshotFile;
    }
}
