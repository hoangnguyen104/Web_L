package com.vti.frontend;

import java.util.LinkedList;
import java.util.Queue;

import com.vti.entity.Student;

public class Program4 {
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

		Queue<Student> studentsQueue = new LinkedList<Student>();
		studentsQueue.add(student1);
		studentsQueue.add(student2);
		studentsQueue.add(student3);
		studentsQueue.add(student4);

		for (Student student : studentsQueue) {
			System.out.println(student);
		}

		System.out.println(studentsQueue.peek());
		System.out.println("-------------------------");
		for (Student student : studentsQueue) {
			System.out.println(student);
		}
		System.out.println("------------------------------");

		System.out.println(studentsQueue.poll());
		System.out.println("poll");
		for (Student student : studentsQueue) {
			System.out.println(student);
		}
	}

}
