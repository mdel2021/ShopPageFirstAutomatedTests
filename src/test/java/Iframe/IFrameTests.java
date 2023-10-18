package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }
    @Test
    public void iFrameTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/nested_frames");
        driver.switchTo().frame("frame-top");
//        driver.switchTo().frame("frameset-middle");
        driver.switchTo().frame("frame-left");
//        WebElement leftFrameElement = driver.findElement(By.cssSelector("frame-left"));
//        driver.switchTo().frame(leftFrameElement);
        WebElement frameLeftText = driver.findElement(By.xpath("/html/body"));
        Assert.assertEquals(frameLeftText.getText(), "LEFT");

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement frameBottomText = driver.findElement(By.cssSelector("body"));
        Assert.assertEquals(frameBottomText.getText(), "BOTTOM");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
