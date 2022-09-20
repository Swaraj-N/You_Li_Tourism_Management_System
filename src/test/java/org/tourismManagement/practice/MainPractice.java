package org.tourismManagement.practice;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.TourishManagement.GenericUtilities.Excelpractice;
import org.TourishManagement.GenericUtilities.WelcomePageLinks;
import org.TourismManagement.POMRepository.CommonPage;
import org.openqa.selenium.WebDriver;

public class MainPractice {
	static WebDriver driver;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Excelpractice ep=new Excelpractice();
		ep.openExcel("C:/Users/SWARAJ-PC/Desktop/Dummy.xlsx");
		//List<Map<String, String>> map = ep.getDataFromExcelInList("Sheet1");
//		dummy d=new dummy(driver);
//		d.createUser(map, 10);
		//ep.saveUpdatedDataIntoExcel("C:/Users/SWARAJ-PC/Desktop/Dummy.xlsx");
		ep.closeExcel();

	}
}
