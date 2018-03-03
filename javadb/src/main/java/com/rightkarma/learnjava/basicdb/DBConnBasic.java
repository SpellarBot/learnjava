package com.rightkarma.learnjava.basicdb;
import java.sql.*;

public class DBConnBasic {
	
	
	public static void main(String[] args)
	throws SQLException{
		Connection conn=DBUtil.getOracleConnection();
		System.out.println("Connection to oracle established. AutoCommit mode : "+conn.getAutoCommit());
	}

}
