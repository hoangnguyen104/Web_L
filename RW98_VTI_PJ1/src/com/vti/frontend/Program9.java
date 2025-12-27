package com.vti.frontend;

import java.util.Scanner;

public class Program9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Moi ban nhap  1 so tu 1 den 7: ");
		int so = scanner.nextInt();
		switch (so) {
		case 2:
			System.out.println("Thu hai");
			break;
		case 3:
			System.out.println("Thu ba");
			break;
		case 4:
			System.out.println("Thu bon");
			break;
		case 5:
			System.out.println("Thu nam");
			break;
		case 6:
			System.out.println("Thu sau");
			break;
		case 7:
			System.out.println("Thu bay");
			break;
		case 1:
			System.out.println("Chu nhat");
			break;
		default:
			System.out.println("nhap sai");
		}

	}
}
