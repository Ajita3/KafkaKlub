package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConfig {

	private static final String DB_NAME = "bms_db";
	private static final String URL = "jdbc:mysql://localhost:3306/" + "bms_db";
	private static final String EMAIL = "root";
	private static final String PASSWORD = "";


/**
 * Establishes a connection to the database.
 *
 * @return Connection object for the database
 * @throws SQLException           if a database access error occurs
 * @throws ClassNotFoundException if the JDBC driver class is not found
 */ 

public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	return DriverManager.getConnection(URL, EMAIL, PASSWORD);
    }
}