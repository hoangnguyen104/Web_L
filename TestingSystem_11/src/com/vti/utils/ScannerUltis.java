package com.vti.utils;

import java.util.Scanner;

public class ScannerUltis {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				int value = Integer.parseInt(sc.nextLine().trim());
				if (value >= 0) {
					return value;
				}
				System.err.println("Nhập lại:");
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static float inputFloat() {
		while (true) {
			try {
				return Float.parseFloat(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static double inputDouble() {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine().trim());
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String input = sc.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}
			System.err.println("Nhập lại:");
		}
	}
}
