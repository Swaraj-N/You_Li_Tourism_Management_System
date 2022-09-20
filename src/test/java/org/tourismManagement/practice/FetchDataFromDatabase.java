package org.tourismManagement.practice;

import java.sql.SQLException;
import java.util.List;

import org.TourishManagement.GenericUtilities.DataBaseUtility;
import org.TourishManagement.GenericUtilities.IConstantPath;
import org.TourishManagement.GenericUtilities.PropertyUtilities;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
//		//Step 1 : Create the object for driver
//		Driver dbdriver=new Driver();
//		//Step 2 : Register the driver instance to the jdbc
//		DriverManager.registerDriver(dbdriver);
//		//Step 3 : Get/Establish the database connection
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
//		//Step 4 : Create the Statement
//		try
//		{Statement Statement = connection.createStatement();
//		//Step 5 : Execute the Query
//		ResultSet result = Statement.executeQuery("Select * from sdet40;");
//		//Step 6 : Verify or iterate or fetch the data
//		while(result.next())
//		{
//			System.out.println(result.getString("emp_name"));
//		}
//		}
//		finally
//		{
//			//Step 7 : Close the Database connection
//			connection.close();
//		System.out.println("Connection closed successfully");
//		}
		DataBaseUtility dbu=new DataBaseUtility();
		PropertyUtilities pu=new PropertyUtilities();
		String dbusername = pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "dbusername");
		String dbpassword = pu.getValueFromPropertyFile(IConstantPath.PROPERTY_PATH, "dbpassword");
		dbu.openDBConnection(IConstantPath.DB_URL, dbusername, dbpassword);
		List<String> fetch = dbu.getDataFromDataBase("Select * from sdet40;", "emp_name");
		System.out.println(fetch);
		dbu.setDataIntoDataBase("insert into sdet40 values(109,'Maithri','SDET');");
		dbu.verifydataInTheDataBase("select * from sdet40;", "emp_name", "Maithri");
		System.out.println(dbu.getDataFromDataBase("Select * from sdet40;", "emp_name"));
		dbu.closeDBConection();
	}
}
