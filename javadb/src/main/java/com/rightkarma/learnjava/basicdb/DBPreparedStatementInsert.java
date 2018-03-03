package com.rightkarma.learnjava.basicdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBPreparedStatementInsert {
	private String preparedStatementQuery = "insert into Jobs values ( ?, ?, ? , ?)";

	private void preparedStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				PreparedStatement pstmt = conn.prepareStatement(preparedStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			// you can call same PS again and again with multiple variables.
			String jobId="Dev_L1";
			String jobTitle="Developer L1";
			float minSal=500f;
			float maxSal=1000f;
			insertPS(pstmt, jobId, jobTitle, minSal, maxSal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertPS(PreparedStatement pstmt, String jobId, String jobTitle, float minSal, float maxSal) throws SQLException {
		pstmt.setString(1, jobId);
		pstmt.setString(2, jobTitle);
		pstmt.setFloat(3,minSal);
		pstmt.setFloat(4,maxSal);
		int rc= pstmt.executeUpdate(); // executeUpdate is used for Insert, Update and Delete
		System.out.println("rc : " + rc); // rc = 1 is SUCCESS. 
										// if you rerun, you will get ORA-00001: unique constraint (HR.JOB_ID_PK) violated
	}


	public static void main(String[] args) {
		DBPreparedStatementInsert dbs = new DBPreparedStatementInsert();
		dbs.preparedStatement();
	}
}
