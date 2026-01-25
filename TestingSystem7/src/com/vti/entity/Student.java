package com.vti.entity;

import java.util.Scanner;

public class Student {
	private int id;
	private String name;
	public static String college = "Đại học Bách Khoa";
	public static int COUNT = 0;
	public static int moneyGroup = 0;

	public Student() {
		super();
		COUNT++;
		if (COUNT > 7) {
			System.err.println("Số lượng sinh viên đã vượt quá 7, không thể tạo thêm sinh viên");
		} else {
			this.id = COUNT;
			System.out.println("Nhập vào tên sinh viên: ");
			Scanner scanner = new Scanner(System.in);
			this.name = scanner.next();
		}

	}

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + " college:" + college + "]";
	}

}
