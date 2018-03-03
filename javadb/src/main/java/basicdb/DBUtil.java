package main.java.basicdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username="hr";
	private static final String password="hr";
	public static Connection getOracleConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, username, password);
	}
}
