package com.vti.frontend;

import java.util.Stack;

import com.vti.entity.Student;

public class Program2 {
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

		Stack<Student> studentsStack = new Stack<Student>();
		studentsStack.push(student1);
		studentsStack.push(student2);
		studentsStack.push(student3);
		studentsStack.push(student4);

		for (Student student : studentsStack) {
			System.out.println(student);
		}

		System.out.println("----peak---");
		System.out.println(studentsStack.peek());
		System.out.println(studentsStack.peek());

		System.out.println("----pop---");
		System.out.println(studentsStack.pop());

		System.out.println("-----------");
		for (Student student : studentsStack) {
			System.out.println(student);
		}
	}
}
