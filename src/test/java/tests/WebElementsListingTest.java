package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebElementsListingTest {
    private static final String LOGIN_URL = "http://przyklady.javastart.pl/jpetstore/actions/Catalog.action";
    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to(LOGIN_URL);
    }

    @Test
    public void listingGoodExampleTest() {
        List<String> listOfHrefAttributes = new LinkedList<>();
        listOfHrefAttributes.add("FISH");
        listOfHrefAttributes.add("DOGS");
        listOfHrefAttributes.add("CATS");
        listOfHrefAttributes.add("REPTILES");
        listOfHrefAttributes.add("BIRDS");

        listOfHrefAttributes.sort(String::compareToIgnoreCase);

        List<WebElement> leftNavLinksList = driver.findElements(By.xpath("//*[@id='SidebarContent']/a"));
        List<WebElement> topNavLinksList = driver.findElements(By.xpath("//*[@id='QuickLinks']/a"));
        List<WebElement> bottomNavLinksList = driver.findElements(By.xpath("//*[@id='MainImageContent']/map/area"));

        assertThatListIsCorrect(leftNavLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(topNavLinksList, listOfHrefAttributes);
        assertThatListIsCorrect(bottomNavLinksList, listOfHrefAttributes);
    }

    private void assertThatListIsCorrect(List<WebElement> actualListOfWebElements, List<String> expectedListOfStrings) {
        List<String> listOfHrefAttributes = new LinkedList<>();
        for (WebElement navLink : actualListOfWebElements) {
            assertTrue(navLink.isDisplayed());
            String hrefCategory = navLink.getAttribute("href").split("&categoryId=")[1];
            listOfHrefAttributes.add(hrefCategory);
        }

        listOfHrefAttributes.sort(String::compareToIgnoreCase);
        assertEquals(actualListOfWebElements.size(), expectedListOfStrings.size());
        assertEquals(Arrays.toString(listOfHrefAttributes.toArray()), Arrays.toString(expectedListOfStrings.toArray()));

    }



    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }
}