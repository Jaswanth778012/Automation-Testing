package com.kodnest.ApachePOI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DBUtilty {
	
	public static Object[][] getFromDb()
	{
		String url = "jdbc:mysql://localhost:3306/data_db";
		String user = "root";
		String pass = "toor";
		
		String query = "select email, password from data";
		
		List<Object[]> datalist = new ArrayList<>();
		
		try
		{
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(query);
			
			
			while(rs.next())
			{
				String username = rs.getString("email");
				String password = rs.getString("password");
				
				datalist.add(new Object[] {username, password});
			}
			
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Object[][] data = new Object[datalist.size()][];
		
		for (int i = 0; i < datalist.size(); i++) {
            data[i] = datalist.get(i);
        }
		
		return data;
	}
	
	@DataProvider(name = "dp1")
	Object[][] loginData()
	{
//		Object data[][]  = {
//				{"abc@gmail.com", "test123"},
//				{"xyz@gmail.com", "test12"},
//				{"sandesh1@kodnest.com","qazwsxedc"},
//				{"James@gmail.com","test1"}
//		};
		
		
		
		return getFromDb();
	}

}
