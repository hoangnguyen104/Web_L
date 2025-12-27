package com.vti.frontend;

import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Department;

public class Program2 {
	public static void main(String[] args) {
		System.out.println("Exercise 1");
		Scanner scanner = new Scanner(System.in);
		{
			System.out.println("Question 1");
			float a = 5240.5f;
			float b = 10970.055f;

			int a_i = (int) a;
			int b_i = (int) b;
			System.out.println(a_i);
			System.out.println(b_i);
		}
		{
			System.out.println("Question 2");
			Random random = new Random();
			int number = random.nextInt(100000);

			String result = String.format("%05d", number);

			System.out.println(result);

			System.out.println("Question 3");
			String a = String.valueOf(number);
			System.out.println("Hai so cuoi: " + a.substring(3));
		}
//		{
//			System.out.println("Question 4");
//			System.out.println("Nhap a:");
//			int a = scanner.nextInt();
//			System.out.println("Nhap b:");
//			int b = scanner.nextInt();
//			scanner.nextLine();
//			System.out.println("Thuong cua a va b: " + (float) a / (float) b);
//		}
//		{
//			System.out.println("Exercise 4");
//			System.out.println("Question 1:");
//			System.out.println("Nhap vao 1 xau ki tu: ");
//			String a = scanner.nextLine();
//			String[] words = a.trim().split("\\s+");
//			System.out.println("Số tu:  " + words.length);
//			scanner.close();
//
//		}
//		{
//			System.out.println("Question 2");
//			System.out.println("Nhap vao 1 xau ki tu: ");
//			String a = scanner.nextLine();
//			System.out.println("Nhap vao 1 xau ki tu: ");
//			String b = scanner.nextLine();
//			String c = a.concat(b);
//			System.out.println(c);
//		}
//		{
//			System.out.println("Qustion 3");
//			System.out.println("Nhap ten: ");
//			String a = scanner.nextLine();
//			String b = a.substring(0, 1).toUpperCase();
//			String c = a.substring(1);
//			String name = b + c;
//			System.out.println("ten cua ban la: " + name);
//		}
//		{
//			System.out.println("Question 4");
//			System.out.println("Nhap ten: ");
//			String a = scanner.nextLine();
//			String name = a.toUpperCase();
//			for (int i = 0; i < a.length(); i++) {
//				System.out.println("Ky tu thu " + i + " la: " + name.charAt(i));
//			}
//		}
//		{
//			System.out.println("Question 5");
//			System.out.println("Nhap ho: ");
//			String a = scanner.nextLine();
//			System.out.println("Nhap ten: ");
//			String b = scanner.nextLine();
//			System.out.println("Ho ten: " + a.concat(b));
//		}
//		{
//			System.out.println("Question 6:");
//			System.out.println("Nhap ho ten day du: ");
//			String a = scanner.nextLine();
//			a = a.trim();
//			String name[] = a.split(" ");
//			String ho = name[0];
//			String ten = name[name.length - 1];
//			String tendem = "";
//			for (int i = 1; i < (name.length - 1); i++) {
//				tendem += name[i] + " ";
//			}
//			System.out.println("Ho la: " + ho);
//			System.out.println("Ten dem: " + tendem);
//			System.out.println("Ten la: " + ten);
//
//		}
//		{
//			System.out.println("Question 7:");
//			System.out.println("Nhap ho ten day du: ");
//			String a = scanner.nextLine();
//			a = a.trim();
//			String name[] = a.split(" ");
//			for (int i = 0; i < name.length; i++) {
//				System.out.print(name[i].substring(0, 1).toUpperCase() + name[i].substring(1) + " ");
//			}
//
//		}
//		
//		{
//			System.out.println("Question 9:");
//			String[] groupNames = { "Java", "C#", "C++" };
//			for (String groupName : groupNames) {
//				if (groupName.equals("Java")) {
//					System.out.println(groupName);
//				}
//			}
//
//		}
		Department[] departments = new Department[5];

		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Boss of director";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Waiting room";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Accounting";

		departments[0] = department1;
		departments[1] = department2;
		departments[2] = department3;
		departments[3] = department4;
		departments[4] = department5;
		{
			System.out.println("Exercise 5");
			System.out.println("Question 1:");
			System.out.println(department1.toString());
		}
		{
			System.out.println("Question 2:");

		}
	}
}
