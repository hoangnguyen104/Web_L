package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.vti.backend.PositionManagement;
import com.vti.ultis.ScannerUltis;

public class Program1 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		PositionManagement positionManagement = new PositionManagement();

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
				positionManagement.showListPosition();
				break;
			case 2:
				positionManagement.showPositionByID();
				break;
			case 3:
				positionManagement.createNewPosition();
				break;
			case 4:
				positionManagement.deletePosition();
			case 5:
				positionManagement.updatePosition();
			default:
				break;
			}
		}
	}
}
