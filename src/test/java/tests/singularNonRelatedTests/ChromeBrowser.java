package tests.singularNonRelatedTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements DriverFactory{
    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
