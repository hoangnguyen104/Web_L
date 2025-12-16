package com.vti.frontend;

import java.util.Scanner;

public class Program10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		for (int i = 10; i > 0; i--) {
//			System.out.println("So " + i);
//		}

		System.out.println("Thong tin cac ban hoc vien: ");
		String[] nameRW98 = { "Tien", "Nam", "Huong", "Binh", "Trinh", "Lam" };
		for (int i = 0; i < nameRW98.length; i++) {
			System.out.println(nameRW98[i]);
		}
	}
}
