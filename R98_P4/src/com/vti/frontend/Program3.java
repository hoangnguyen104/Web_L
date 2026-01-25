package com.vti.frontend;

import java.util.LinkedList;

import com.vti.entity.Student;

public class Program3 {
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

		LinkedList<Student> studentsLinkedList = new LinkedList<Student>();
		studentsLinkedList.push(student1);
		studentsLinkedList.push(student2);
		studentsLinkedList.push(student3);
		studentsLinkedList.push(student4);

		for (Student student : studentsLinkedList) {
			System.out.println(student);
		}

		System.out.println("----peak---");
		System.out.println(studentsLinkedList.peek());
		System.out.println(studentsLinkedList.peek());

		System.out.println("----pop---");
		System.out.println(studentsLinkedList.pop());

		System.out.println("-----------");
		for (Student student : studentsLinkedList) {
			System.out.println(student);
		}
	}
}
