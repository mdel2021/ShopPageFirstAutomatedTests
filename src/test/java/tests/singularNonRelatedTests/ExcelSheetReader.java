package tests.singularNonRelatedTests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelSheetReader {
    private XSSFWorkbook excelWBook;
    private XSSFSheet excelWSheet;

    public void setExcelFileSheet(String excelFileLocation, String sheetName) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(excelFileLocation);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        if (excelWSheet == null) {
            throw new RuntimeException("Excel Sheet was null! Please check name of the excel sheet!");
        }
    }

    public XSSFSheet getExcelSheet() {
        return excelWSheet;
    }
}
