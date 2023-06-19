package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TablePage {
    private WebElement table;

//    private WebDriver driver;
    private List<WebElement> rows;
    private List<WebElement> columns;

//    public TablePage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    public TablePage(WebDriver driver, By tableLocator) {
        table = driver.findElement(tableLocator);
        columns = table.findElements(By.xpath("thead//span"));
        rows = table.findElements(By.xpath("tbody//tr"));
    }

    public int getNumbersOfRows() {
        return rows.size();
    }

    public int getNumberOfColumns() {
        return columns.size();
    }

    public WebElement getLastNameForRow(int rowIndex) {
        WebElement lastNameRow = rows.get(rowIndex).findElement(By.xpath("td[1]"));
        return lastNameRow;
    }

    public WebElement getWebSiteRow(int rowIndex) {
        WebElement webSiteRow = rows.get(rowIndex).findElement(By.xpath("td[5]"));
        return webSiteRow;
    }
}
