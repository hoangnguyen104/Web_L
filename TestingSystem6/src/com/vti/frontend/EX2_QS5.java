package com.vti.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EX2_QS5 {

	public static void main(String[] args) {
		int age = inputAge();
		System.out.println("Your age is: " + age);
	}

	public static int inputAge() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			try {
				System.out.print("Input age: ");
				int age = scanner.nextInt();

				if (age < 0) {
					throw new Exception("age < 0");
				}

				return age;

			} catch (InputMismatchException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
				scanner.nextLine();
			} catch (Exception e) {
				System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
			}
		}
	}
}
