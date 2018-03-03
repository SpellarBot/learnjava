package main.java.basicdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBCallableStatementOutputParam {
	private String callableStatementQuery = "{call empcount ( ?, ?)}";

	private void callableStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				CallableStatement cstmt = conn.prepareCall(callableStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			cstmt.setInt(1, 50);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			int totalcount=cstmt.getInt(2);
			System.out.println("totalcount for dept 50: "+ + totalcount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBCallableStatementOutputParam dbs = new DBCallableStatementOutputParam();
		dbs.callableStatement();
	}
}
