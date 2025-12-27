package com.vti.frontend;

import com.vti.entity.Student;

public class Program4 {
	public static void main(String[] args) {
		Student student1 = new Student(1, "nam");
		student1.getId();
		student1.getName();
		student1.setId(2);
	}
}
