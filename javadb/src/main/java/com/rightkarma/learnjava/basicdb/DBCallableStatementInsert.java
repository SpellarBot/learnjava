package com.rightkarma.learnjava.basicdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBCallableStatementInsert {
	private String callableStatementQuery = "{call addjob ( ?, ?, ? , ?)}";

	private void callableStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				CallableStatement cstmt = conn.prepareCall(callableStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			// you can call same PS again and again with multiple variables.
			String jobId="Dev_L2";
			String jobTitle="Developer L2";
			float minSal=1000f;
			float maxSal=2000f;
			insertCallableStatement(cstmt, jobId, jobTitle, minSal, maxSal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertCallableStatement(CallableStatement cstmt, String jobId, String jobTitle, float minSal, float maxSal) throws SQLException {
		cstmt.setString(1, jobId);
		cstmt.setString(2, jobTitle);
		cstmt.setFloat(3,minSal);
		cstmt.setFloat(4,maxSal);
		boolean rc= cstmt.execute(); // executeUpdate is used for Insert, Update and Delete
		System.out.println("rc : " + rc); // rc = false means , no result is returned. 
	}


	public static void main(String[] args) {
		DBCallableStatementInsert dbs = new DBCallableStatementInsert();
		dbs.callableStatement();
	}
}
