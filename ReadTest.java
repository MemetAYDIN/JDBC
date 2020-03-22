package com.godoro.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadTest {
	public static void main(String[] args) throws Exception {
		String driver="com.mysql.cj.jdbc.Driver";
		//String url="jdbc:mysql://localhost:3306/madb"+"?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
		String url="jdbc:mysql://localhost:3306/madb"		
		+ "?allowPublicKeyRetrieval=true"			
		+ "&useSSL=false"			
		+ "&useUnicode=true"		
		+ "&useLegacyDatetimeCode=false"		
		+ "&serverTimezone=Turkey";
		
		String user="root";
		
		
		String passwor="2020*";
		
		Class.forName(driver);
		
		Connection connection=DriverManager.getConnection(url,user,passwor);
		

		//String sql="select *from Product";
		String sql="select avg(salesPrice) as averagePrice from Product where productId=?";
		
		PreparedStatement statement=connection.prepareStatement(sql);
		
		
		statement.setLong(1, 2);//for where condition
		ResultSet resultSet=statement.executeQuery();
		if(resultSet.next())
		{
			
			double avaregePrice=resultSet.getDouble("averagePrice");
			System.out.println("Ortalama Eder: "+avaregePrice);
		}
		
		else
		{
			System.out.println("Sonuç Yok!!!!");
		}
		connection.close();
		
	}

}
