package com.xyzsoft.emanage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsLoader {

    public static XSSFSheet loadXLS(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheetAt(0);
            return sheet;
        }
    }
}