package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Level;

import static org.testng.Assert.assertEquals;

public class LogExampleTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.INFO);
        chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, loggingPreferences);
        chromeOptions.merge(chromeOptions);

        driver = new ChromeDriver(chromeOptions);

        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void browserLogExampleTest() {
        WebElement enterStoreLink = driver.findElement(By.cssSelector("#Content a"));
        enterStoreLink.click();
        WebElement signInLink = driver.findElement(By.cssSelector("#MenuContent a[href*='signonForm']"));
        signInLink.click();
        WebElement userNameTextField = driver.findElement(By.name("username"));
        userNameTextField.sendKeys("NotExistingLogin");
        WebElement passwordTextField = driver.findElement(By.name("password"));
        passwordTextField.sendKeys("NotProperPassword");
        WebElement loginButton = driver.findElement(By.name("signon"));
        loginButton.click();
        WebElement wrongLoginMessageLabel = driver.findElement(By.cssSelector("#Content ul[class='messages'] li"));
        assertEquals("Invalid username or password. Signon failed.", wrongLoginMessageLabel.getText());


    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}