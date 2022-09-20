package org.TourishManagement.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This Class Contains DataBase Methods
 * @author SWARAJ-PC
 *
 */
public class DataBaseUtility {
	private Connection connection;
	/**
	 * This method is used to fetch data from the DataBase
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDataBase(String query,String columnName)
	{
		Statement Statement = null;
		try {
			Statement = connection.createStatement();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = Statement.executeQuery(query);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		List<String> list=new ArrayList<>();
		try {
			while(result.next())
			{
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method is used to Open The DataBase Connection
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
	public void openDBConnection(String dbURL,String dbUserName,String dbPassword)
	{
		Driver dbdriver = null;
		try {
			dbdriver = new Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbdriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to Close the DataBase Connection
	 */
	public void closeDBConection()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to Insert Values or Update values in Database
	 * @param query
	 */
	public void setDataIntoDataBase(String query)
	{
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void verifydataInTheDataBase(String query,String columnName,String expectedData)
	{
		List<String> list = getDataFromDataBase(query, columnName);
		boolean flag=false;
		for (String actualData : list) {
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		System.out.println(flag);
	}
}
