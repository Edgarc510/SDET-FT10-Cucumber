package com.eac.tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleDataPoi.xlsx";

        //to read from excel we need to load to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        //flow is as follows: workbook>sheet>row> cell
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2. we need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3. Select row and cell

        // print out Marys cell
        System.out.println("sheet.getRow(1).getCell(0) = " + sheet.getRow(1).getCell(0));

        //printout developer row job id
        System.out.println("sheet.getRow(3).getCell(0) = " + sheet.getRow(3).getCell(2));


        //Return the count of used cells only
        //starts from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows); // returns only used rows - starts at 1

        /*
        Returns the number from top to bottom cell and counts used on unused cells- starts from 0
        
         */
        int lastUsedRows = sheet.getLastRowNum();
        System.out.println("usedRows = " + lastUsedRows);
        
        //Task: Create a logic to print Edgars name dynamically
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Edgar")){
                System.out.println("sheet.getRow(rowNum).getCell(0).toString() = " + sheet.getRow(rowNum).getCell(0).toString());
            }
            
        }



    }

}
