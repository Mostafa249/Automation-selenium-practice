package Utiliti;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Spreadsheet {
    private File file;
    private static XSSFSheet sheet;
    public Spreadsheet(String fileName,String sheetName) throws IOException {
         file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook WB = new XSSFWorkbook(inputStream);
        sheet = WB.getSheet(sheetName);
    }
    @Step("Get data from excel sheet with the row number :{RN} and cell number:{CN}")
    public static String getData(int RN, int CN) {
        DataFormatter formatter = new DataFormatter();
        String field = formatter.formatCellValue(sheet.getRow(RN).getCell(CN));
        return field;
    }
}
