package main.java.basicdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Use Statement executeQuery(staticQuery) method to execute static queries
 * */
public class DBStatementRSInsertUpdate {
	private String staticQuery = "Select DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID from Departments";

	private void staticStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = stmt.executeQuery(staticQuery);)

		{
			/**
			 * FIND and UPDATE a record
			 **/
			rs.beforeFirst();
			while ( rs.next()) {
				if ( rs.getString(2).equals("IT") ) {
					rs.updateString(2,  "Information Technology");
					rs.updateRow();
					System.out.println("Updated IT to Informtion Technology");
				}
			}
			
			/**
			 * INSERT a new row
			 **/
			rs.moveToInsertRow();
			rs.updateInt(1,999 );
			rs.updateString(2,"Training" );
			rs.updateInt(3,200 );
			rs.updateInt(4,1800 );
			rs.insertRow();
			System.out.println("data inserted..");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBStatementRSInsertUpdate dbs = new DBStatementRSInsertUpdate();
		dbs.staticStatement();
	}
}
