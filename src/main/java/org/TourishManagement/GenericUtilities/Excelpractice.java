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

public class Excelpractice {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	Workbook wb;
	Sheet sheet;
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

	public void closeExcel()
	{
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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


	public static void main(String[] args) {
		Excelpractice ep=new Excelpractice();
		ep.openExcel("./src/test/resources/Dummy.xlsx");
		String validatedata = ep.validatedata("Sheet2", "Abcd");
		ep.closeExcel();
		System.out.println(validatedata);
	}

	//	public void saveUpdatedDataIntoExcel(String pathOfExcel)
	//	{
	//		try {
	//			wb.write(fos);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}	
	//	}

}

