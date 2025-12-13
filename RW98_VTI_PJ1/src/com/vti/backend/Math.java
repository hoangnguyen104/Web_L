package com.vti.backend;

public class Math {
	public void sum() {
		System.out.println("Nhap vao so thu 1: ");
		int a = 5;
		System.out.println("Nhap vao so thu 2: ");
		int b = 10;
		int result = a + b;
		System.out.println("Tong cua 2 so la: " + result);
	}

	public int multiply(int number1, int number2) {
		int result_nhan = number1 * number2;
		return result_nhan;
	}
}
