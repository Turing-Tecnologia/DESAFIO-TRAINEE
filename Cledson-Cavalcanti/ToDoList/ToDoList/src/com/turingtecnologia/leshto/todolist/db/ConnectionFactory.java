package com.turingtecnologia.leshto.todolist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String HOSTNAME = "localhost";
			String DATABASE = "todo_leshto";
			String USERNAME = "root";
			String PASSWORD = "";

			conn = DriverManager.getConnection("jdbc:mysql://"
					+ HOSTNAME + "/"
					+ DATABASE, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println("Você deve ter removido a biblioteca JDBC do MariaDB :?");
		}
		
		return conn;
	}
}
