package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;

public class LogExampleTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.INFO);
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
        chromeOptions.merge(chromeOptions);

        driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void browserLogExampleTest() {

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}