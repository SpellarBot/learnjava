package com.rightkarma.learnjava.basicdb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Use Statement executeQuery(staticQuery) method to execute static queries
 * */
public class DBStatementRSScrollable {
	private String staticQuery = "Select * from Countries";

	private void staticStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(staticQuery);)

		{
			int iLoop=0;
			int iLoopMax=3;
			
			System.out.println("Current row number in the beginning: " + rs.getRow());
			/************** display first 10 rows ******************/
			rs.beforeFirst();//move cursor before first row.
			while ( rs.next() && iLoop < iLoopMax) { // rs.next() moves cursor by one row
				System.out.println(rs.getString(1)+":"+rs.getString(2)); // column index starts from 1
				iLoop++;
			}
			System.out.println("Current row number after iterating first "+iLoopMax+" rows: " + rs.getRow());
			iLoop=0;
			/************** display last 10 rows ******************/
			rs.afterLast();//move cursor after last row.
			System.out.println("Current row number afterLast: " + rs.getRow());
			while ( rs.previous() && iLoop < iLoopMax)  { // rs.previous() moves cursor by one row in backward direction
				System.out.println(rs.getString(1)+":"+rs.getString(2)); // column index starts from 1
				iLoop++;
			}
			System.out.println("Current row number : after last "+iLoopMax+" rows scrolled back " + rs.getRow());
			
			
			rs.first();// move to first row
			rs.last(); // move to last row
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBStatementRSScrollable dbs = new DBStatementRSScrollable();
		dbs.staticStatement();
	}
}

/*
OUTPUT
Current row number in the beginning: 0
AR:Argentina
AU:Australia
BE:Belgium
Current row number after first 3 rows: 4
Current row number afterLast: 0
ZW:Zimbabwe
ZM:Zambia
US:United States of America
Current row number : after last 3 rows scrolled back22
*/