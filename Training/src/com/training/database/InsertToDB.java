package com.training.database;


	
	
	import java.sql.Connection;


	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.gjt.mm.mysql.Driver;
	import org.testng.annotations.Test;

	public class InsertToDB {
		Connection con;

		@Test
		public void sampleTest() throws SQLException
		{
			try{
				//step 1: register the driver/ database
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2: connect to database
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
			
			//step 3: issue/ create sql statement
			Statement stat = con.createStatement();
			
				//String query="select * from students_info";
				String  query1="insert into students_info (regno, firstName, middleName, lastName) values('8', 'asw','wini', 'v')";
			
			//step 4: execute sql query
			 int res = stat.executeUpdate(query1);
				//process the result
		if(res==1)
		{
			System.out.println("data is inserted");
		
		}
		
		String Query="select * from students_info";
		ResultSet res1 =stat.executeQuery(Query);
		
		while(res1.next())
		{
			System.out.println(res1.getInt(1) + "\t" + res1.getString(2) + "\t" + res1.getString(3));
		}
		
		}
			
			catch (Exception e)
			{
				System.err.println("data is  not inserted");
			}
			finally
			{
			
			//step 5: close the connection
			con.close();
		}
	}
	}


