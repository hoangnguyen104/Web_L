package com.vti.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.ultis.ScannerUltis;

public class Program {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testing_system_assignment_1?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String user = "root";
		String password = "123456";

		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement selectStmt = conn.createStatement();
			// Lấy danh sách phòng ban
			String selectSQL = "SELECT * FROM Account";

			ResultSet rs = selectStmt.executeQuery(selectSQL);
			List<Account> accountsList = new ArrayList<>();

			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("AccountID"));
				account.setEmail(rs.getString("Email"));
				account.setUsername(rs.getString("Username"));
				account.setFullname(rs.getString("Fullname"));
				account.setDepartmentId(rs.getInt("departmentid"));
				account.setPositionId(rs.getInt("positionid"));
				account.setCreatedate(rs.getObject("createdate", LocalDateTime.class));
				accountsList.add(account);
			}

			for (Account account : accountsList) {
				System.out.println(account);
			}

			// update
			System.out.print("Nhập AccountID muốn update: ");
			int updateId = ScannerUltis.inputInt();

			Account account = null;

			for (Account acc : accountsList) {
				if (acc.getId() == updateId) {
					account = acc;
					break;
				}
			}

			if (account == null) {
				System.out.println("Không tìm thấy account!");
				return;
			}

			System.out.println("Chọn field muốn update:");
			System.out.println("1. Email");
			System.out.println("2. Username");
			System.out.println("3. Fullname");
			System.out.println("4. DepartmentId");
			System.out.println("5. PositionId");

			int choice = ScannerUltis.inputInt();
			switch (choice) {
			case 1:
				System.out.print("Nhập email mới: ");
				account.setEmail(ScannerUltis.inputString());
				break;

			case 2:
				System.out.print("Nhập username mới: ");
				account.setUsername(ScannerUltis.inputString());
				break;

			case 3:
				System.out.print("Nhập fullname mới: ");
				account.setFullname(ScannerUltis.inputString());
				break;

			case 4:
				System.out.print("Nhập departmentId mới: ");
				account.setDepartmentId(ScannerUltis.inputInt());
				break;

			case 5:
				System.out.print("Nhập positionId mới: ");
				account.setPositionId(ScannerUltis.inputInt());
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
				return;
			}

			String sql = "";
			PreparedStatement ps = null;

			if (choice == 1) {
				sql = "UPDATE Account SET Email = ? WHERE AccountID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, account.getEmail());
			} else if (choice == 2) {
				sql = "UPDATE Account SET Username = ? WHERE AccountID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, account.getUsername());
			} else if (choice == 3) {
				sql = "UPDATE Account SET Fullname = ? WHERE AccountID = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, account.getFullname());
			} else if (choice == 4) {
				sql = "UPDATE Account SET DepartmentID = ? WHERE AccountID = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, account.getDepartmentId());
			} else if (choice == 5) {
				sql = "UPDATE Account SET PositionID = ? WHERE AccountID = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, account.getPositionId());
			}

			ps.setInt(2, account.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
