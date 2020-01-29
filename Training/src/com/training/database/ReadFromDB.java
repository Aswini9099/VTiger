package com.training.database;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.gjt.mm.mysql.Driver;
import org.testng.annotations.Test;

public class ReadFromDB {

	@Test
	public void sampleTest() throws SQLException
	{
		//step 1: register the driver/ database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step 2: connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
		
		//step 3: issue/ create sql statement
		Statement stat = con.createStatement();
		
			String query="select * from students_info";
		
		//step 4: execute sql query
		ResultSet result = stat.executeQuery(query);
			//process the result
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3));
		}
		
		//step 5: close the connection
		con.close();
	}
}
