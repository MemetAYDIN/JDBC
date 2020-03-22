package com.godoro.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
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
		System.out.println(connection.getMetaData().getDatabaseProductName());
		connection.close();
		
	}

}
