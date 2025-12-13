package com.vti.frontend;

import com.vti.backend.Math;

public class Program6 {
	public static void main(String[] args) {
		Math math = new Math();
		math.sum();

		int c = 6;
		int d = 7;
		int result = math.multiply(c, d);
		System.out.println("Ket qua nhan cua 2 so c va d la: " + result);
	}

}
