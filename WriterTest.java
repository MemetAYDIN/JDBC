package com.godoro.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class WriterTest {
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
		

		String sql="insert into Product (productNam,salesPrice) values(?,?)";
		
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, "Cep Telefonu");
		statement.setDouble(2, 13000.0);
		int affected=statement.executeUpdate();
		
		
		System.out.println("Etkilenmiş:  "+affected);
		
		
		
		
		
		
		
		connection.close();
		
	}

}
