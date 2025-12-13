package com.vti.frontend;

import com.vti.entity.Student;

public class Program4 {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.name = "Son";
		student1.age = 20;

		Student student2 = new Student();
		student2.name = "Dab";
		student2.age = 21;

		Student student3 = new Student();
		student3.name = "Hoa";
		student3.age = 22;

		student1.goToVTI();
		System.out.println(student1.toString());
	}

}
