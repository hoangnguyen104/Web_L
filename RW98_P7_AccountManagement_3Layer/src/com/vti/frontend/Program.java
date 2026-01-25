package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.ultis.ScannerUltis;

public class Program {
	public static void main(String[] args)
			throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		DepartmentProgram departmentProgram = new DepartmentProgram();
		PositionProgram positionProgram = new PositionProgram();
		while (true) {
			System.out.println("+--------------------------------------+");
			System.out.println("|        CHỌN ĐỐI TƯỢNG QUẢN LÝ         |");
			System.out.println("+--------------------------------------+");
			System.out.println("| 1. Department                        |");
			System.out.println("| 2. Account                           |");
			System.out.println("| 3. Position                          |");
			System.out.println("| 4. Thoát                             |");
			System.out.println("+--------------------------------------+");

			int choose = ScannerUltis.inputIntPositive();

			switch (choose) {
			case 1:
				departmentProgram.menuDepartment();
				break;
			case 2:
				accountProgram.menuAccount();
				break;
			case 3:
				positionProgram.menuPosition();
				break;
			case 4:
				return;
			default:
				System.out.println("Nhập lại!");
			}
		}

	}

}
