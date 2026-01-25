package com.vti.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// code1
		// code2
		// code3

		try {
			System.out.println("Moi ban nhap so thu 1:");
			int number1 = scanner.nextInt();
			System.out.println("Moi ban nhap so thu 2:");
			int number2 = scanner.nextInt();
			float result = number1 / number2;

			String myname = null;
			System.out.println("So luong ky tu trong ten cua ban la:");
		} catch (ArithmeticException e) {
			System.out.println("Khong the chia cho 0");
			System.out.println("Thong tin chi tiet Exception: ");
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Du lieu ban nhap khong chinh xac");
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
		}

		// code6
		// code7
		// code8
		// code9
	}
}
