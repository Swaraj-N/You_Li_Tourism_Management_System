
package org.tourismManagement.practice;

import org.TourishManagement.GenericUtilities.DataTypes;
import org.TourishManagement.GenericUtilities.ExcelUtilities;
import org.TourishManagement.GenericUtilities.IConstantPath;
import org.TourishManagement.GenericUtilities.JavaOperationUtilities;

public class WriteDataIntoExcel {
	public static void main(String[] args)
	{
		ExcelUtilities Excel=new ExcelUtilities();
		String FetchedData = Excel.getValuesFromExcel(IConstantPath.EXCEL_PATH, "ADMIN", 0, 2);
		System.out.println(FetchedData);
		JavaOperationUtilities jou=new JavaOperationUtilities();
		jou.convertStringIntoAnyDatatype(FetchedData, DataTypes.LONG);
		
		System.out.println(FetchedData);

	}
}