
package org.tourismManagement.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {
	public static void main(String[] args) throws SQLException {
		//Step 1 : Create the object for driver
				Driver dbdriver=new Driver();
				//Step 2 : Register the driver instance to the jdbc
				DriverManager.registerDriver(dbdriver);
				//Step 3 : Get/Establish the database connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
				//Step 4 : Create the Statement
				try
				{Statement Statement = connection.createStatement();
				//Step 5 : Execute the Query
				int result = Statement.executeUpdate("insert into sdet40 values(106,'Manjesh','SDET')");
				//Step 6 : Verify or iterate or fetch the data
				if(result==1)
	
				{
					System.out.println(result+" Row updated successfully");
				}
				}
				finally
				{
					//Step 7 : Close the Database connection
				System.out.println("Connection closed successfully");
				}
	}
	
}