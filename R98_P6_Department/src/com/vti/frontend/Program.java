package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.DepartmentManagement;
import com.vti.ultis.ScannerUltis;

public class Program {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartmentManagement departmentManagement = new DepartmentManagement();
		while (true) {
			System.out.println("Moi ban chon chuc nang");
			System.out.println("1. Xem danh sach phong ban");
			System.out.println("2. Tim phong ban theo ID");
			System.out.println("3. Them moi phong ban");
			System.out.println("4. Xoa phong ban");
			System.out.println("5. Update phong ban");

			int choose = ScannerUltis.inputInt();

			switch (choose) {
			case 1:
				departmentManagement.showListDepartment();
				break;
			case 2:
				departmentManagement.showDepartmentByID();
				break;
			case 3:
				departmentManagement.createNewDepartment();
				break;
			case 4:
				departmentManagement.deleteDepartment();
			case 5:
				departmentManagement.updateDepartment();
			default:
				break;
			}
		}

	}
}
