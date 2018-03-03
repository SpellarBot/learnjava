package main.java.basicdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBCallableStatementBatch {
	private String callableStatementQuery = "{call addjob ( ?, ?, ? , ?)}";

	private void callableStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				CallableStatement cstmt = conn.prepareCall(callableStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			// you can call same PS again and again with multiple variables.
			int iLoop=10;
			while ( iLoop<=15) {
				Job j=new Job("DEV_L"+iLoop, "Developer L"+iLoop, 1000*iLoop,1100*iLoop);
				System.out.println("Add to batch:"+j.toString());
				callableStatementAddBatch(cstmt, j.jobId, j.jobTitle, j.minSal, j.maxSal);
				iLoop++;
			}
			int[] executeBatch = cstmt.executeBatch();
			System.out.println("executeBatch.length : "+executeBatch.length);
			for ( int i =0;i<executeBatch.length;i++) {
				System.out.println("i : "+i);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void callableStatementAddBatch(CallableStatement cstmt, String jobId, String jobTitle, float minSal, float maxSal) throws SQLException {
		cstmt.setString(1, jobId);
		cstmt.setString(2, jobTitle);
		cstmt.setFloat(3,minSal);
		cstmt.setFloat(4,maxSal);
		cstmt.addBatch(); 
	}


	public static void main(String[] args) {
		DBCallableStatementBatch dbs = new DBCallableStatementBatch();
		dbs.callableStatement();
	}
	
	class Job {
		String jobId;
		String jobTitle;
		float minSal;
		float maxSal;
		public Job(String jobId, String jobTitle, float minSal, float maxSal) {
			super();
			this.jobId = jobId;
			this.jobTitle = jobTitle;
			this.minSal = minSal;
			this.maxSal = maxSal;
		}
		@Override
		public String toString() {
			return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSal=" + minSal + ", maxSal=" + maxSal + "]";
		}
		
	}
}
