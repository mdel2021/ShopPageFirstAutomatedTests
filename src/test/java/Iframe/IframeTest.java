package Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/iframe");
    }

    @Test
    public void iFrameSwitchTest() {
        driver.switchTo().frame("mce_0_ifr");
        WebElement editableContentField = driver.findElement(By.id("tinymce"));
        editableContentField.clear();
        editableContentField.sendKeys("JavaStart");

        driver.switchTo().defaultContent();
        WebElement headline = driver.findElement(By.cssSelector("#content div h3"));
        String headlineText = headline.getText();

        Assert.assertEquals(headlineText, "An iFrame containing the TinyMCE WYSIWYG Editor", "powtorz test");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
