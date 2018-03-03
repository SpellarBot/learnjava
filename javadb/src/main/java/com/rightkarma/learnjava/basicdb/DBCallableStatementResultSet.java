package com.rightkarma.learnjava.basicdb;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.internal.OracleCallableStatement;

/*
 * Use CallableStatement to execute queries with result set return value.
 * NOTE the usage of CURSOR
 * */
public class DBCallableStatementResultSet {
	private String callableStatementQuery = "{call employeelist ( ?, ? )}";

	private void callableStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				CallableStatement cstmt = conn.prepareCall(callableStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			cstmt.setInt(1, 20); // this should return all employees in department_id 20
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = ((OracleCallableStatement)cstmt).getCursor(2);
			String format="%-4s%-50s%-25s%-10f\n";
			while (rs.next()) {
				System.out.format(format, rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBCallableStatementResultSet dbs = new DBCallableStatementResultSet();
		dbs.callableStatement();
	}
}
