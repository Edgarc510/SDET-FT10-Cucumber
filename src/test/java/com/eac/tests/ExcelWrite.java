package com.eac.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    String path = "SampleDataPoi.xlsx";
    @Test
    public void excel_write() throws IOException {

        //to read from excel we need to load to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Employees");

        //crating new salary cell -
        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        //adding salaries for each employee
        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(200000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(150000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(120000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(250000);

        //to view the existing values we need to use FileInputStream --> reading
        //to view the saved values we need to use FileOutputStream -- writing
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        //save/write changes to the workbook
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();

    }

}
