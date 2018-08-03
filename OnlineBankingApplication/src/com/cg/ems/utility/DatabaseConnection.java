
	package com.cg.ems.utility;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class DatabaseConnection {

	public static Connection getConnection() {
			
			String driver="";
			String url="";
			String username="";
			String pwd="";
			Connection connection=null;
			try {
				FileInputStream fin=new FileInputStream("Resources\\dbConfig.properties");
				Properties prop=new Properties();
				prop.load(fin);
				driver=prop.getProperty("driver");
				url=prop.getProperty("url");
				username=prop.getProperty("username");
				pwd=prop.getProperty("pwd");
				Class.forName(driver);
				connection=DriverManager.getConnection(url, username, pwd);
				System.out.println("connected with db...");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver class not loadd...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to connect with DB");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		
		public static void main(String[] args) {
			getConnection();
		}
	}

