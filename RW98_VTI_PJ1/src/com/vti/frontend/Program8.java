package com.vti.frontend;

import java.util.Scanner;

public class Program8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Moi ban nhap vao so thu 1: ");
//		int number1 = scanner.nextInt();
//		System.out.println("Moi ban nhap vao so thu 2: ");
//		int number2 = scanner.nextInt();
//		if (number1 > number2) {
//			System.out.println(number1 + " > " + number2);
//		} else if (number1 < number2) {
//			System.out.println(number1 + " < " + number2);
//		} else {
//			System.out.println(number1 + " = " + number2);
//		}

		System.out.println("Moi ban nhap tuoi: ");
		int age = scanner.nextInt();

		String ageinfo = (age > 0) ? "Thong tin chinh xac" : "Thong tin chua chinh xac!!";

	}
}
