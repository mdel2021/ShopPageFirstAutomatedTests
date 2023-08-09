package date.picker;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataPickerInjectionTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("http://przyklady.javastart.pl/test/full_form.html");
    }

    @Test
    public void injectIntoDatePickerTest() {
        String dateInPast = "01/01/2016";
        String datePickerCssSelector = "#datepicker";

        WebElement datePicker = driver.findElement(By.cssSelector(datePickerCssSelector));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "$('%s').val('%s').change();";

        javascriptExecutor.executeScript(String.format(script, datePickerCssSelector, dateInPast));

        String selectedDate = datePicker.getAttribute("value");

        assertEquals(selectedDate, dateInPast);
    }


    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}
