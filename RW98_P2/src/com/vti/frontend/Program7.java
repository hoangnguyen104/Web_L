package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.MathManagement;

public class Program7 {
	public static void main(String[] args) {
		MathManagement management = new MathManagement();
		System.out.println("Nhap so 1:");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println("Nhap so 2:");

		int b = scanner.nextInt();
		int result = management.sum(a, b);
		System.out.println(result);
	}
}
