package com.xyzsoft.emanage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsReader {

    public static void main(String[] args) throws IOException {
        String projectFilePath = ".\\resources\\Projects.xls";
        // loadXLS(".\\resources\\Projects.xls");
        String stagesFilePath = ".\\resources\\Stages.xls";
        String detailedFilePath = ".\\resources\\Stages_Detailed.xls";

        FileInputStream projectInputStream = new FileInputStream(projectFilePath);
        FileInputStream stagesInputStream = new FileInputStream(stagesFilePath);
        FileInputStream detailedInputStream = new FileInputStream(detailedFilePath);

        // Opening Workbooks
        XSSFWorkbook projectWorkbook = new XSSFWorkbook(projectInputStream);
        XSSFWorkbook stagesWorkbook = new XSSFWorkbook(stagesInputStream);
        XSSFWorkbook detailedWorkbook = new XSSFWorkbook(detailedInputStream);

        // Selecting first sheets
        XSSFSheet projectSheet = projectWorkbook.getSheetAt(0);
        XSSFSheet stagesSheet = stagesWorkbook.getSheetAt(0);
        XSSFSheet detailedSheet = detailedWorkbook.getSheetAt(0);

        // Intializing Iterator
        Iterator projectIterator = projectSheet.iterator();
        Iterator stagesIterator = stagesSheet.iterator();
        Iterator detailedIterator = detailedSheet.iterator();

        // Iterator for Projects.xls
        while (projectIterator.hasNext()) {
            XSSFRow row = (XSSFRow) projectIterator.next();
            Iterator projectCellIterator = row.cellIterator();

            while (projectCellIterator.hasNext()) {
                XSSFCell cell = (XSSFCell) projectCellIterator.next();

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.println(" | ");
            }
            System.out.println();
        }

    }
}