package main.java.basicdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Use Statement executeQuery(staticQuery) method to execute static queries
 * */
public class DBStatementRSIterate {
	private String staticQuery = "Select * from Countries";

	private void staticStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(staticQuery);)

		{
			// rs.next() moves cursor by one row
			while ( rs.next()) {
				System.out.println(rs.getString(1)+":"+rs.getString(2)); // column index starts from 1
			}
			
			System.out.println("Current row number : " + rs.getRow());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBStatementRSIterate dbs = new DBStatementRSIterate();
		dbs.staticStatement();
	}
}
