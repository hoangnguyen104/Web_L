package com.vti.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class Program2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(
					"C:\\Users\\hoang\\eclipse-workspace\\RW98_P5_DATABASE\\src\\com\\vti\\resources\\database.properties"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");

			Connection conn = DriverManager.getConnection(url, user, password);
			Statement selectStmt = conn.createStatement();
			// Lấy danh sách phòng ban
			String selectSQL = "INSERT INTO Department(Departmentname) value(?);";
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			System.out.println("Moi ban nhap vao ten phong ban can them moi");
			String depname = ScannerUltis.inputString();
			preparedStatement.setString(1, depname);

			int resultInsert = preparedStatement.executeUpdate();
			Department department = null;

			if (resultInsert == 1) {
				System.out.println("them thanh cong");
			} else {
				System.out.println("Khong thanh cong");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
