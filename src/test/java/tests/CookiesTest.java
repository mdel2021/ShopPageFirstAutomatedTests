package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class CookiesTest {
    private static final String LOGIN_URL = "http://przyklady.javastart.pl/jpetstore/actions/Account.action?signonForm=";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(LOGIN_URL);
    }

    @Test
    public void cookieExampleUsageTest() {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("j2ee");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("j2ee");

        WebElement loginButton = driver.findElement(By.name("signon"));
        loginButton.click();

        WebElement bannerLogoAfterLogin = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));

        assertTrue(bannerLogoAfterLogin.isDisplayed());

        Set<Cookie> cookieSet = driver.manage().getCookies();
        Cookie loginCookie = cookieSet.iterator().next();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        try {
            WebElement bannerLogoAfterClearingCookies = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));
            assertTrue(bannerLogoAfterClearingCookies.isDisplayed());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.err.println("Element Dog banner after log in is not displayed!");;
        }

        driver.manage().deleteAllCookies();
        driver.manage().addCookie(loginCookie);

        driver.navigate().refresh();

        WebElement bannerLogoAfterAddingCookie = driver.findElement(By.cssSelector("#Banner img[src*='dog']"));
        assertTrue(bannerLogoAfterAddingCookie.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}