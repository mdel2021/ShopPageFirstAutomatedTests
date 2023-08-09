package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScrollTest {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.navigate().to("https://theinternet.przyklady.javastart.pl/large");
        driver.navigate().to("https://www.newworld.com/pl-pl/game/credits-launch");
    }

    @Test
    public void scrollUsingActionsClassTest() {
//        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id='large-table']/tbody/tr[50]/td[50]"));
        WebElement mdelaElement = driver.findElement(By.xpath("//*[@id='module-2JeBKxtzchsAvWyY4dQflY']/section/div[3]/article/div/p[165]/span"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(lastElementInTheTable).perform();
        actions.moveToElement(mdelaElement).perform();
        sleep();
//        assertEquals(lastElementInTheTable.getText(), "50.50");
        assertEquals(mdelaElement.getText(), "Mateusz Dela");
    }

//    @Test
//    public void scrollUsingJavaScriptTest() {
//        WebElement lastElementInTheTable = driver.findElement(By.xpath("//*[@id='large-table']/tbody/tr[50]/td[50]"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastElementInTheTable);
//        sleep();
//        assertEquals(lastElementInTheTable.getText(), "50.50");
//    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
