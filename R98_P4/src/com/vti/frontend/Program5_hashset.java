package com.vti.frontend;

import java.util.HashSet;

import com.vti.entity.Student;

public class Program5_hashset {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setId(1);
		student1.setName("a");

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("b");

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("c");

		Student student4 = new Student();
		student4.setId(4);
		student4.setName("d");

		HashSet<Student> studentsHashSet = new HashSet<Student>();
		studentsHashSet.add(student1);
		studentsHashSet.add(student2);
		studentsHashSet.add(student3);
		studentsHashSet.add(student4);

		for (Student student : studentsHashSet) {
			System.out.println(student);
		}
	}
}
