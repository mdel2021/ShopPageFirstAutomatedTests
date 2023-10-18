package tests.singularNonRelatedTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerBrowser implements DriverFactory{
    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.ie.driver", "C:/drivers/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }
}
