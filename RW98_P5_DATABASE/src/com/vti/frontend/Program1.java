package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Program1 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testing_system_assignment_1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String password = "123456";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement selectStmt = conn.createStatement();
			// Lấy danh sách phòng ban
			String selectSQL = "SELECT * FROM Department where DepartmentID = ?;";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			System.out.println("Moi ban nhap vao phong ban can tim kiem");
			int depid = ScannerUltis.inputInt();
			preparedStatement.setInt(1, depid);

			ResultSet rs = preparedStatement.executeQuery();
			Department department = null;

			if (rs.next()) {
				department = new Department();
				department.setId(rs.getInt("DepartmentID"));
				department.setName(rs.getString("Departmentname"));
			}
			if (department != null) {
				System.out.println(department.toString());
			} else {
				System.out.println("Khong co phong ban nay");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
