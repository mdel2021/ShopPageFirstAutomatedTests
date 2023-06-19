package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TableTest extends TestBaseForTable {



    @Test
    public void traversingTable1() {
        TablePage tableTest1 = new TablePage(driver, By.id("table1"));
        int numberOfRows = tableTest1.getNumbersOfRows();
        int numberOfColumns = tableTest1.getNumberOfColumns();

        int expectedNumberOfRows = 4;
        int expectedNumberOfColumns = 6;

        assertEquals(numberOfRows, expectedNumberOfRows);
        assertEquals(numberOfColumns, expectedNumberOfColumns);
        }
}