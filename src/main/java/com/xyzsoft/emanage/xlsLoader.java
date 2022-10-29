package com.xyzsoft.emanage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsLoader {

    public static XSSFSheet loadXLS(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            XSSFSheet sheet = workbook.getSheetAt(0);

            // int rows = sheet.getLastRowNum();
            // DataFormatter formatter = new DataFormatter();
            // int colms = sheet.getRow(rows).getLastCellNum();

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                XSSFRow row = (XSSFRow) iterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    XSSFCell cell = (XSSFCell) cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.println("STRING: " + cell.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.println("Formatted :" + cell.getDateCellValue());
                            } else {
                                System.out.println("UnFormatted :" + cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            System.out.println("FORMULE :" + cell.getCellFormula());
                            break;
                        case BLANK:
                            System.out.println("BLANK");
                            break;
                        default:
                            System.out.println("Unknown");
                    }
                    System.out.println(" | ");
                }
                System.out.println(" | ");
            }
        }
        return null;
    }
}