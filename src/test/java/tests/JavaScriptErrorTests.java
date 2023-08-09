package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.logging.Level;

public class JavaScriptErrorTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        LoggingPreferences loggingPreferences = new LoggingPreferences();
        loggingPreferences.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability(ChromeOptions.LOGGING_PREFS, loggingPreferences);
        chromeOptions.merge(chromeOptions);

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_error");
    }

    @Test
    public void javaScriptAlertPromptTest() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        Assert.assertFalse(isErrorPresent(browserLogs));
        }

    private boolean isErrorPresent(LogEntries entry) {
        boolean resultFlag = false;

        for (LogEntry logEntry : entry) {
            if (logEntry.getMessage().contains("TypeError")) {
                System.out.println(new Date(logEntry.getTimestamp()) + " " + logEntry.getLevel() + " " + logEntry.getMessage());
                resultFlag = true;
                continue;
            }
            System.out.println("LogEntry does not contain TypeError");
        }
        return resultFlag;
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
//WERSJA Z KURSU JAVASTART
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.logging.LogEntries;
//import org.openqa.selenium.logging.LogEntry;
//import org.openqa.selenium.logging.LogType;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertFalse;
//
//
//public class JavaScriptErrorTests {
//
//    private WebDriver driver;
//
//    @BeforeMethod
//    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
//        driver = new ChromeDriver();
//
//        driver.navigate().to("http://theinternet.przyklady.javastart.pl/javascript_error");
//    }
//
//    @Test
//    public void javaScriptErrorInConsoleTest() {
//        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//
//        assertFalse(isErrorPresent(logEntries, "TypeError"), "JavaScript error should not be present on the page!");
//    }
//
//    private boolean isErrorPresent(LogEntries logEntries, String errorName) {
//        boolean errorPresent = false;
//
//        for (LogEntry logEntry : logEntries) {
//            if (logEntry.getMessage().contains(errorName)) {
//                System.out.println("There was an error on the page: " + logEntry.toString());
//                errorPresent = true;
//                continue;
//            }
//            System.out.println("Log Entry does not contain TypeError");
//        }
//        return errorPresent;
//    }
//
//    @AfterMethod
//    public void afterTest() {
//        driver.close();
//        driver.quit();
//    }
//}