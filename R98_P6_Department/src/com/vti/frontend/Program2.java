package com.vti.frontend;

import com.vti.backend.AccountManagement;
import com.vti.ultis.ScannerUltis;

public class Program2 {
	public static void main(String[] args) {
		AccountManagement accountManagement = new AccountManagement();
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
				accountManagement.showListAccount();
				break;
			case 2:
				accountManagement.showAccountByID();
				break;
			case 3:
				accountManagement.createNewAccount();
				break;
			case 4:
				accountManagement.deleteAccount();
			case 5:
				accountManagement.updateAccount();
			default:
				break;
			}
		}
	}
}
