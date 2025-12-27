package com.vti.frontend;

import com.vti.entity.Student;

public class Testing_System_4 {
	public static void main(String[] args) {
		System.out.println("Question 4");
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("hoang");
		student1.setHometown("Ha noi");
		student1.setScore(5);

		student1.plusScore(2);
		System.out.println("Diem cua sinh vien sau khi cong: " + student1.getScore());

		student1.showinfo();
	}
}
