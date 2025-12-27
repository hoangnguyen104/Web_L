package com.vti.frontend;

public class Program3 {
	public static void main(String[] args) {
		String name = "Vti Academy";
		System.out.println("Name: " + name);
		System.out.println("Ky tu tai vi tri thu 2: " + name.charAt(1));
		System.out.println(name.equals("admin"));
		String a = String.valueOf(name.charAt(1)); // cach 1
		System.out.println("Ky tu tai vi tri thu 2: " + a.toUpperCase());
		System.out.println(name.substring(0, 2)); // cach 2

	}
}
