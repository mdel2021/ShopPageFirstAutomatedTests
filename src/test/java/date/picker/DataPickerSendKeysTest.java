package date.picker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataPickerSendKeysTest {

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
    public void datePickerSendKeysTest() {
        String dateInPast = "06/21/2015";
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys(dateInPast);

        String selectedDate = datePicker.getAttribute("value");
        assertEquals(selectedDate, dateInPast);

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
