package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ScreensShotMakerTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://duckduckgo.com/");
    }

    @Test
    public void screenshotMakerTest() {
        ScreenShotMaker screenShotMaker = new ScreenShotMaker(driver);
        screenShotMaker.takeScreenshot("GoogleBeforeTypingQueryPage.png");
        WebElement searchFormHomepage = driver.findElement(By.id("search_form_input_homepage"));
        searchFormHomepage.sendKeys("Kurs Selenium");

        screenShotMaker.takeScreenshot("GoogleAfterTypingQueryPage.png");
        WebElement searchButtonHomepage = driver.findElement(By.id("search_button_homepage"));
        searchButtonHomepage.submit();

        screenShotMaker.takeScreenshot("GoogleSearchResultsPage.png");
        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("Kurs Selenium"));
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}