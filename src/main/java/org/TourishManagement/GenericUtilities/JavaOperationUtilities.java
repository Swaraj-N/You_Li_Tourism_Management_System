package org.TourishManagement.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Class contains all the Java Operations
 * @author SWARAJ-PC
 *
 */
public class JavaOperationUtilities {
	/**
	 * This Method is used to convert string to any data type
	 * @param data
	 * @param strategy
	 * @return
	 */
	public Object convertStringIntoAnyDatatype(String data,DataTypes strategy)
	{
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("int"))
		{
			obj = Integer.parseInt(data);
		}
		else if(strategy.toString().equalsIgnoreCase("long"))
		{
			obj=Long.parseLong(data);
		}
		else
		{
			obj=Double.parseDouble(data);
		}
		return obj;
	}
/**
 * This method is sued to get current time in following format "dd_MM_yyyy_hh_mm_ss"
 * @return
 */
	public String getCurrentDateandTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String format = sdf.format(date);
		return format;
	}

}
