package org.tourismManagement.practice;

import org.TourishManagement.GenericUtilities.Excelpractice;
import org.TourishManagement.GenericUtilities.IConstantPath;

public class DummyExcelTest {
	public static void main(String[] args) {
		Excelpractice ep=new Excelpractice();
		ep.openExcel(IConstantPath.EXCEL_PATH);
		System.out.println(ep.getDataFromExcelInList("Sheet1"));
		ep.closeExcel();	
	}
}
