package org.TourishManagement.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class Is Used To Fetch CommonData From Property File
 * @author SWARAJ-PC
 *
 */
public class PropertyUtilities {

	/**
	 * getValueFromPropertyFile Method Fetches Value From Property File
	 * By Using The Following Parameters
	 * @param pathOfProperty
	 * @param propertyKey
	 * @return
	 */

	public String getValueFromPropertyFile(String pathOfProperty,String propertyKey)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(pathOfProperty);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties propertyFile=new Properties();
		try {
			propertyFile.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String Value = propertyFile.getProperty(propertyKey).trim();
		return Value;
	}
	
	
//	FileInputStream fis;
//	Properties property;
//	public void initializePropertyFile()
//	{
//		try {
//			fis=new FileInputStream(IConstantPath.PROPERTY_PATH);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		property=new Properties();
//	}
//	
//	public void loadValuesIntoPropertyFile()
//	{
//		try {
//			property.load(fis);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public String getDataFromPropertyFile(String Key)
//	{
//		return property.getProperty(Key);
//	}
	
}
