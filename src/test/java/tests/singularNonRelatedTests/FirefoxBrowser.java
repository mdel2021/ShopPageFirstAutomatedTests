package tests.singularNonRelatedTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements DriverFactory {
    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.gecko.driver", "C:/drivers/geckodriver.exe");
        return new FirefoxDriver();
    }
}
