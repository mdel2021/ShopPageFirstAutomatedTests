package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JavaScriptAlertsTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_alerts");
    }

    @Test
    public void javaScriptAlertTest() {
        WebElement alertButton = driver.findElement(By.cssSelector("li:nth-child(1) > button"));
        alertButton.click();

        driver.switchTo().alert().accept();
        String resultText = driver.findElement(By.cssSelector("#result")).getText();

        assertEquals(resultText, "You successfuly clicked an alert");
    }

    @Test
    public void javaScriptAlertConfirmTest() {
        WebElement confirmButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        confirmButton.click();
        driver.switchTo().alert().accept();
        String resultTextAfterAccept = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals(resultTextAfterAccept, "You clicked: Ok");

        confirmButton.click();
        driver.switchTo().alert().dismiss();
        String resultTextAfterDismiss = driver.findElement(By.cssSelector("#result")).getText();
        assertEquals(resultTextAfterDismiss, "You clicked: Cancel");
    }

    @Test
    public void javaScriptAlertPromptTest() {
        WebElement promptButton = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
        promptButton.click();
        String typedText = "Selenium is cool";
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(typedText);
        alert.accept();
        WebElement resultText = driver.findElement(By.cssSelector("#result"));
        assertEquals(resultText.getText(), "You entered: " + typedText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}