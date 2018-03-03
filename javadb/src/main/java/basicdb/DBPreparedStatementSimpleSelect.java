package main.java.basicdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Use PreparedStatement to execute queries with parameters
 * */
public class DBPreparedStatementSimpleSelect {
	private String preparedStatementQuery = "Select * from Employees where Salary < ?  and Department_id = ?";

	private void preparedStatement() {
		try (Connection conn = DBUtil.getOracleConnection();
				PreparedStatement pstmt = conn.prepareStatement(preparedStatementQuery,
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY))

		{
			// you can call same PS again and again with multiple variables.
			runPS(pstmt, 2200, 50);
			runPS(pstmt, 2500, 50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void runPS(PreparedStatement pstmt, int salary, int departmentId) throws SQLException {
		pstmt.setDouble(1, salary);
		pstmt.setInt(2,departmentId);
		try (ResultSet rs = pstmt.executeQuery()) {
			String format = "%-4s%-20s%-25s%-10f\n";
			while (rs.next()) {
				System.out.format(format, rs.getString("Employee_Id"), rs.getString("First_name"),
						rs.getString("Last_name"), rs.getFloat("salary"));
			}
			rs.last();
			System.out.println("Total Employees : " + rs.getRow());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		DBPreparedStatementSimpleSelect dbs = new DBPreparedStatementSimpleSelect();
		dbs.preparedStatement();
	}
}
