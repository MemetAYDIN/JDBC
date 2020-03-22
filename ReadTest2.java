package com.godoro.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadTest2 {
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
		String sql="select *from Product where salesPrice>?";
		
		PreparedStatement statement=connection.prepareStatement(sql);
		
		
		statement.setDouble(1, 2000);//for where condition
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next())
		{
			long productId=resultSet.getLong("productId");
			String productName=resultSet.getString("productNam");
			double salesPrice=resultSet.getDouble("salesPrice");
			System.out.println(productId+" "+productName+" "+salesPrice);
		}
		
		
		connection.close();
		
	}

}
