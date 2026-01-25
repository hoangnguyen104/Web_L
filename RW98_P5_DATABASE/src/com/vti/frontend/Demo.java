package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;

public class Demo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testing_system_assignment_1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String password = "123456";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement selectStmt = conn.createStatement();
			// Lấy danh sách phòng ban
			String selectSQL = "SELECT * FROM Department ORDER BY DepartmentID";

			ResultSet rs = selectStmt.executeQuery(selectSQL);
			List<Department> departmentList = new ArrayList<>();

			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("DepartmentID"));
				department.setName(rs.getString("DepartmentName"));
				departmentList.add(department);
			}
			System.out.println("DepartmentID   DepartmentName");
			for (Department department : departmentList) {
				System.out.println(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
