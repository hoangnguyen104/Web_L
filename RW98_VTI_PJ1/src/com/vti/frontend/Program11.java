package com.vti.frontend;

import java.util.Random;

public class Program11 {
	public static void main(String[] args) {
//		int i = 1;
//		System.out.println(i--);

		String[] nameRailway98 = { "Tiến", "Nam", "Hương", "Bình", "Trinh", "Lâm", "Hùng", "Hoàng" };
		Random random = new Random();
		int a = random.nextInt(nameRailway98.length);
		System.out.println(nameRailway98[a]);
	}
}
