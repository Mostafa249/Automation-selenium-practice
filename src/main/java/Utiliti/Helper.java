package Utiliti;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    @Step("Get the current time to add it to the email field to be unique")
    public static String CurrentTime(String dateformat) {

        return new SimpleDateFormat(dateformat).format(new Date());
    }
}