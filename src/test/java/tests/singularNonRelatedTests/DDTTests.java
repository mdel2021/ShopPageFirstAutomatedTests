package tests.singularNonRelatedTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DDTTests {
    private String baseUrl = "https://duckduckgo.com/";
    private WebDriver driver;
    private String searchQuery;
    private String expectedResult;

    public DDTTests(String searchQuery, String expectedResult) {
        this.searchQuery = searchQuery;
        this.expectedResult = expectedResult;
    }

    @Factory
    public static Object[] queriesTestData() {
        int queryColumn = 0;
        int expectedResultColumn = 1;

        ExcelSheetReader excelSheetReader = new ExcelSheetReader();
        String excelFileLocation = System.getProperty("user.dir") + "/src/main/resources/" + "DDT_File.xlsx";

        try {
            excelSheetReader.setExcelFileSheet(excelFileLocation, "DuckDuckGoSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());
        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);
        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        Object[] arrayOfTestCaseToExecute = new Object[expectedResultList.size()];
        for (int testCase = 0; testCase < expectedResultList.size(); testCase++) {
            arrayOfTestCaseToExecute[testCase] = new DDTTests(searchQueryList.get(testCase), expectedResultList.get(testCase));
        }
        return arrayOfTestCaseToExecute;
    }

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void dataDrivenTest() {
        WebElement searchField = driver.findElement(By.name("q"));

        searchField.sendKeys(searchQuery);
        searchField.submit();

        assertEquals(driver.getTitle(),expectedResult);

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();

    }

}