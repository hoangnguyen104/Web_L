package com.vti.frontend;

public class EX2_QS3 {
	public static void main(String[] args) {
		try {
			int[] number = { 1, 2, 3 };
			System.out.println(number[10]);
		} catch (Exception e) {
			System.out.println("Khong tim thay phan tu trong mang");
		}

	}
}
