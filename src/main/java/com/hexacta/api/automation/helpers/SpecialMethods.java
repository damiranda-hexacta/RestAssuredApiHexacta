package com.hexacta.api.automation.helpers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SpecialMethods {
    public static Properties properties;

    public static void configPropertiesRead(){
        properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/data/conf.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getStringCellValueExcel(int rowNumber, int cellNumber) throws IOException {
        File excelFile = new File(properties.getProperty("excelPath"));
        FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(properties.getProperty("excelSheetName"));
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.getStringCellValue();
    }


}
