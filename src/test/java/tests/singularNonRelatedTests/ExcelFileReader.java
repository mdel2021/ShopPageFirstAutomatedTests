package tests.singularNonRelatedTests;

import java.io.IOException;
import java.util.List;

public class ExcelFileReader {
    public static void main(String[] args) {
        int queryColumn = 0;
        int expectedResultColumn = 1;
        ExcelSheetReader excelSheetReader = new ExcelSheetReader();

        String excelFileLocation = System.getProperty("user.dir")+"/src/main/resources/" + "DDT_FILE.xlsx";
        try {
            excelSheetReader.setExcelFileSheet(excelFileLocation, "DuckDuckGoSearch");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SheetDataReader sheetDataReader = new SheetDataReader(excelSheetReader.getExcelSheet());
        List<String> searchQueryList = sheetDataReader.getDataForColumn(queryColumn);
        List<String> expectedResultList = sheetDataReader.getDataForColumn(expectedResultColumn);

        System.out.println(searchQueryList.toString());
        System.out.println(expectedResultList.toString());
    }
}
