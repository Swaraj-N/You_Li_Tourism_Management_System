package org.TourishManagement.GenericUtilities;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class Contains Method to Fetch the Values From Excel and Write The Values Into Excel
 * @author SWARAJ-PC
 *
 */
public class ExcelUtilities {

	FileInputStream fis = null;
	FileOutputStream fos = null;
	Workbook wb;
	Sheet sheet;

	public String getexcel(int rownum,int cellnum)
	{
		DataFormatter df=new DataFormatter();
		return df.formatCellValue(sheet.getRow(rownum).getCell(cellnum));
	}

	public void writetoexcel(String value,int rownum,int cellnum,String pathofExcel)
	{
		sheet.getRow(rownum).createCell(cellnum).setCellValue(value);
		try {
			fos = new FileOutputStream(pathofExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getValuesFromExcel Method Fetches Values From Specified WorkBook,SheetName,RowNumber,CellNumber
	 * Using Following Parameters and Returns Value To The Calling Program
	 * @param Path
	 * @param SheetName
	 * @param Rownumber
	 * @param Cellnumber
	 * @return
	 */
	public String getValuesFromExcel(String pathOfExcel,String sheetName,int rowNumber,int cellNumber)
	{

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workBook = null;
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		Sheet OpenSheet = workBook.getSheet(sheetName);
		DataFormatter DF=new DataFormatter();
		String FetchedData = DF.formatCellValue(OpenSheet.getRow(rowNumber).getCell(cellNumber));
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FetchedData;		
	}

	/**
	 * setValuesToExcel Method Writes Value To Specified WorkBook,SheetName,RowNumber,CellNumber
	 * By Using Following Parameters
	 * @param Path
	 * @param SheetName
	 * @param Rownumber
	 * @param Cellnumber
	 * @return
	 */
	public void setValuesToExcel(String pathOfExcel,String sheetName,int rowNumber,int cellNumber,String value)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Workbook workBook = null;
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		Sheet Opensheet = workBook.getSheet(sheetName);
		Opensheet.getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		try {
			FileOutputStream fos=new FileOutputStream(pathOfExcel);
			try {
				workBook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method is used to Open the Excel By specifying the path of the excel
	 * @param pathOfExcel
	 */
	public void openExcel(String pathOfExcel)
	{

		try {
			fis = new FileInputStream(pathOfExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to fetch data from excel Based on Keys by using HashMap ArrayList
	 * @param sheetName
	 * @return
	 */
	public List<Map<String, String>> getDataFromExcelInList(String sheetName)
	{
		sheet=wb.getSheet(sheetName);
		List<Map<String, String>> list=new ArrayList<>();
		DataFormatter df=new DataFormatter();
		for(int k=1;k<sheet.getRow(0).getLastCellNum();k++)
		{

			Map<String, String> map=new HashMap<>();
			for(int i=0;i<=sheet.getLastRowNum();i++)
			{
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}


	public String validatedata(String sheetName,String key)
	{
		List<Map<String, String>> data = getDataFromExcelInList(sheetName);
		String ValidateText = data.get(0).get(key);
		return ValidateText;
	}
}
