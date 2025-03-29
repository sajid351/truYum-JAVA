package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		Connection connection = null;

		try {
			Properties properties = new Properties();
			FileInputStream fin = new FileInputStream("src/connection.properties");
			properties.load(fin);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lch_marketplace", properties);

			if (connection != null) {
				System.out.println("\nConnected to database \n");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Not connected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection properties file not found");
		}

		return connection;

	}
	/*
	 * public static void main(String[] args) { getConnection(); }
	 */

}
