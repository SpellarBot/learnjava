package main.java.basicdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBCallableStatementInOutParam {
	private String callableStatementQuery = "{call inoutparam ( ? )}";// whatever you pass is passed back 
																	// proc simply multiplies passed num by 11

	private void callableStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				CallableStatement cstmt = conn.prepareCall(callableStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			cstmt.setInt(1, 9); // this should give 9*11 = 99 as return value
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			int updatedNumber=cstmt.getInt(1);
			System.out.println("updatedNumber : "+ + updatedNumber);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBCallableStatementInOutParam dbs = new DBCallableStatementInOutParam();
		dbs.callableStatement();
	}
}
