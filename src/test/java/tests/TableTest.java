package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class TableTest extends TestBaseForTable {



    @Test
    public void traversingTable1() {
        TablePage table = new TablePage(driver, By.id("table1"));
        int numberOfRows = table.getNumbersOfRows();
        int numberOfColumns = table.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);

        int firstRowIndex = 0;
        int lastRowIndex = numberOfRows-1;

        WebElement lastNameFirstRow = table.getLastNameForRow(firstRowIndex);
        WebElement lastNameLastRow = table.getLastNameForRow(lastRowIndex);

        assertEquals(lastNameFirstRow.getText(), "Smith", "Actual and expected last name value don't match");
        assertEquals(lastNameLastRow.getText(), "Conway", "Actual and expected last name value don't match");

        WebElement webSiteFirstRow = table.getWebSiteRow(firstRowIndex);
        WebElement webSiteLastRow = table.getWebSiteRow(lastRowIndex);

        assertEquals(webSiteFirstRow.getText(), "http://www.jsmith.com");
        assertEquals(webSiteLastRow.getText(), "http://www.timconway.com");
    }
    @Test
    public void traversingTable2() {
        TablePage table = new TablePage(driver, By.id("table2"));
        int numberOfRows = table.getNumbersOfRows();
        int numberOfColumns = table.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);

        int firstRowIndex = 0;
        int lastRowIndex = numberOfRows-1;

        WebElement lastNameFirstRow = table.getLastNameForRow(firstRowIndex);
        WebElement lastNameLastRow = table.getLastNameForRow(lastRowIndex);

        assertEquals(lastNameFirstRow.getText(), "Smith", "Actual and expected last name value don't match");
        assertEquals(lastNameLastRow.getText(), "Conway", "Actual and expected last name value don't match");

        WebElement webSiteFirstRow = table.getWebSiteRow(firstRowIndex);
        WebElement webSiteLastRow = table.getWebSiteRow(lastRowIndex);

        assertEquals(webSiteFirstRow.getText(), "http://www.jsmith.com");
        assertEquals(webSiteLastRow.getText(), "http://www.timconway.com");

        //wyświetlenie typów logów
        Set<String> availableLogTypes = driver.manage().logs().getAvailableLogTypes();
        System.out.println(Arrays.toString(availableLogTypes.toArray()));
    }


}