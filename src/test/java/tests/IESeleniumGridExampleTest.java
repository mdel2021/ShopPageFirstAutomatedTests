package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

public class IESeleniumGridExampleTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest()  {
//        ChromeOptions capability = new ChromeOptions();
        InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
        internetExplorerOptions.setCapability("version", "8");
        internetExplorerOptions.enablePersistentHovering();
        internetExplorerOptions.ignoreZoomSettings();

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/"), internetExplorerOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void searchInDuckDuckGoTest() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("JavaStart");
        driver.findElement(By.id("search_form_input_homepage")).submit();

        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("JavaStart"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
