package com.vti.frontend;

public class EX2_QS1 {
	public static void main(String[] args) {
		try {
			float result = divide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Loi khi chia");
		} finally {
			System.out.println("divide completed");
		}
	}

	public static float divide(int a, int b) {
		return a / b;
	}
}
