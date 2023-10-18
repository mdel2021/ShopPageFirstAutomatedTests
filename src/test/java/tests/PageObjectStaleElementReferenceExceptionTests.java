package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.NotificationMessagePage;

import static org.testng.Assert.assertTrue;

public class PageObjectStaleElementReferenceExceptionTests {
    private WebDriver driver;
    private NotificationMessagePage notificationMessagePage;

    private static final String ACTION_SUCCESSFUL = "Action successful";
    private static final String ACTION_UNSUCCESSFUL_PLEASE_TRY_AGAIN = "Action unsuccesful, please try again";


    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void staleElementWorkingTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/notification_message_rendered");

        notificationMessagePage = new NotificationMessagePage(driver);
        assertThatCorrectActionMessageIsDisplayed(ACTION_UNSUCCESSFUL_PLEASE_TRY_AGAIN);
        assertThatCorrectActionMessageIsDisplayed(ACTION_SUCCESSFUL);
        assertThatCorrectActionMessageIsDisplayed(ACTION_UNSUCCESSFUL_PLEASE_TRY_AGAIN);
    }

    private void assertThatCorrectActionMessageIsDisplayed(String message) {
        boolean isMessageHavingCorrectText;

        do {
            notificationMessagePage.clickOnClickHereLink();
            isMessageHavingCorrectText = notificationMessagePage.getMessageLabelText().contains(message);
            System.out.println("Message Label had correct text: " + isMessageHavingCorrectText);
        } while (!isMessageHavingCorrectText);

        assertTrue(isMessageHavingCorrectText);
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}
