package tests;

import navigation.Angular1Wait;
<<<<<<< HEAD
import navigation.Angular2Wait;
=======
>>>>>>> origin/develop
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AngularTests {

    private WebDriver driver;
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void angular1WaitTest() {
        driver.navigate().to("https://angularjs.org/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(Angular1Wait.waitForAngularToFinishProcessingRequests());
    }

<<<<<<< HEAD
    @Test
    public void angular2WaitTest() {
        driver.navigate().to("https://demos.creative-tim.com/paper-dashboard-angular/#/dashboard");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(Angular2Wait.waitForAngularIOToFinishProcessingRequests());
    }

=======
>>>>>>> origin/develop
    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
