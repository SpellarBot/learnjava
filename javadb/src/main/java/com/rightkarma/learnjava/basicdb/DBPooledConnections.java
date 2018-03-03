package com.rightkarma.learnjava.basicdb;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.PooledConnection;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class DBPooledConnections implements Runnable {

	private static OracleConnectionPoolDataSource ds;

	static {
		System.out.println("create pooled ds..");
		try {
			ds = new OracleConnectionPoolDataSource();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		ds.setDriverType("thin");
		ds.setServerName("localhost");
		ds.setPortNumber(1521);
		ds.setServiceName("xe");
		ds.setUser("hr");
		ds.setPassword("hr");
	}

	@Override
	public void run() {
		try {
			System.out.println("DateTime : "+new java.util.Date()+" Thread name : "+Thread.currentThread().getName());
			PooledConnection pooledConnection = ds.getPooledConnection();
			System.out.println("ds:"+ds+"pooledConnection:"+pooledConnection); // seperate pooledConnection objects should exist
			Connection conn = pooledConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from departments");
			String format = "%-30s%-50s%-25s%-25s\n";
			while (rs.next()) {
				System.out.format(format, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (Exception e) {
			System.out.println("ERROR in run : "+e.getMessage());
		}

	}

	public static void main(String[] args) throws SQLException {
		for ( int i = 0;i<51;i++) {
			Thread t = new Thread(new DBPooledConnections());
			t.start();
		}
	}
}
