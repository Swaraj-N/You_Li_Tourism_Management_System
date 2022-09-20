package org.tourismManagement.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassDataToApplicationUsingDatabase {
	public static void main(String[] args) throws SQLException, InterruptedException {
		//Step 1 : Create the object for driver
		Driver dbdriver=new Driver();
		//Step 2 : Register the driver instance to the jdbc
		DriverManager.registerDriver(dbdriver);
		//Step 3 : Get/Establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		//Step 4 : Create the Statement
		try {
		Statement Statement = connection.createStatement();
		//Step 5 : Execute the Query
		ResultSet User = Statement.executeQuery("select username from admin;");
		String usn=null;
		String pwd=null;
		while(User.next())
		{
			usn=User.getString("Username");
			System.out.println(usn);
		}
		ResultSet Pass = Statement.executeQuery("select password from admin;");
		while(Pass.next())
		{
			pwd=Pass.getString("password");
			System.out.println(pwd);
		}
		WebDriver driver=null;
		String browser = "Firefox";
		if(browser.equalsIgnoreCase(browser))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase(browser))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System");
		driver.findElement(By.xpath("//a[.='Admin Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(usn);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("login")).click();
		}
		finally
		{
			connection.close();
		}
		}
}
