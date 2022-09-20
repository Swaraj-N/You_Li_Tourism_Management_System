package org.tourismManagement.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1 : Convert Physical file on java readable object
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT.xlsx");
		//Step 2 : Open the workbook
		Workbook WB = WorkbookFactory.create(fis);
		//Step 3 : Get controller on sheet
		Sheet sheet = WB.getSheet("ADMIN");
		//Step 4 : Get controller on row
		Row row = sheet.getRow(3);
		//Step 5 : Get controller on cell
		Cell cell = row.getCell(2);
		//Step 6 : Fetch the Data from the cell
		String data = cell.getStringCellValue();
		System.out.println(data);
	}
}
