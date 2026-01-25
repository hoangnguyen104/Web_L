package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.vti.entity.Student;
import com.vti.ultis.ScannerUltis;

public class Exercise1 {
	ArrayList<Student> studentsArrayList = new ArrayList<Student>();
	Stack<Student> studentsStack = new Stack<Student>();
	Set<Student> studentSet = new HashSet<Student>();

	public void question1() {

		System.out.println("Nhập số sinh viên muốn thêm: ");
		int num = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num; i++) {
			Student st = new Student("Student " + (i + 1));
			studentsArrayList.add(st);
		}
		Student st1 = new Student("AAAA");
		Student st2 = new Student("BBBB");
		Student st3 = new Student("CCCC");
		studentsArrayList.add(st1);
		studentsArrayList.add(st2);
		studentsArrayList.add(st3);

		System.out.println("Danh sach Student: ");
		for (Student student : studentsArrayList) {
			System.out.println(student);
		}
		System.out.println("Phan tu thu 4 cua student: " + studentsArrayList.get(3));
		System.out.println("Phần tử đầu của students: " + studentsArrayList.get(0));
		System.out.println("Phần tử cuối của students: " + studentsArrayList.get(studentsArrayList.size() - 1));
		System.out.println("Thêm 1 phần tử vào vị trí đầu của students");
		Student st4 = new Student("DDDD");
		studentsArrayList.add(0, st4);
		System.out.println("Danh sach Student: ");
		for (Student student : studentsArrayList) {
			System.out.println(student);
		}
		System.out.println("Thêm 1 phần tử vào vị trí cuối của students");
		Student st5 = new Student("DDDD");
		studentsArrayList.add(st5);
		System.out.println("Danh sach Student: ");
		for (Student student : studentsArrayList) {
			System.out.println(student);
		}
		Collections.reverse(studentsArrayList);
		System.out.println("Vị trí của students sau dảo ngược: ");
		for (Student student : studentsArrayList) {
			System.out.println(student);
		}
		System.out.println("Xoa name cua student co id=2: ");
		for (Student student : studentsArrayList) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
		findStudentbyid(2);

		System.out.println("Delete student có id = 5");
		Iterator<Student> iterator = studentsArrayList.iterator();

		while (iterator.hasNext()) {
			Student student = iterator.next();
			if (student.getId() == 5) {
				iterator.remove();
			}
		}
		ArrayList<Student> studentCopies = new ArrayList<Student>();
		studentCopies.addAll(studentsArrayList);
		System.out.println("In phần tử trong ArrayCopy: ");
		for (Student student : studentCopies) {
			System.out.println(student);
		}

	}

	public void findStudentbyid(int id) {
		for (Student student : studentsArrayList) {
			if (student.getId() == id) {
				System.out.println(student);

			}
		}
	}

	public void findStudentbyname() {
		System.out.println("Nhap vao ten Student muon tim: ");
		String name = ScannerUltis.inputString();
		boolean found = false;
		for (Student student : studentsArrayList) {
			if (student.getName() != null && student.getName().equals(name)) {
				found = true;
				System.out.println(student);
			}
		}
		if (!found) {
			System.out.println("Khong tim thay student");
		}

	}

	public void PrintStudentNameSame() {
		for (int i = 0; i < studentsArrayList.size(); i++) {
			for (int j = i + 1; j < studentsArrayList.size(); j++) {
				if (studentsArrayList.get(i).getName() != null
						&& studentsArrayList.get(i).getName().equals(studentsArrayList.get(j).getName())) {
					System.out.println(studentsArrayList.get(i).toString());
				}
			}
		}
	}

	public void question2() {
		Student st1 = new Student("Nguyễn Văn Nam");
		Student st2 = new Student("Nguyễn Văn Huyên");
		Student st3 = new Student("Trần Văn Nam");
		Student st4 = new Student("Nguyễn Văn A");
		studentsStack.add(st1);
		studentsStack.add(st2);
		studentsStack.add(st3);
		studentsStack.add(st4);
		for (Student student : studentsStack) {
			System.out.println(student);
		}
		studentpv1();
		studentpv2();
	}

	public void studentpv1() {
		Iterator<Student> iteratorStudent = studentsStack.iterator();
		System.out.println("Thứ tự sinh viên theo thứ tự từ sớm nhất đến muộn nhất dùng Stack: ");
		while (iteratorStudent.hasNext()) {
			Student student = iteratorStudent.next();
			System.out.println(student);
		}
	}

	public void studentpv2() {
		Queue<Student> studentsQueue = new LinkedList<Student>();
		for (Student student : studentsStack) {
			studentsQueue.add(student);
		}

		Stack<Student> tempStack = new Stack<>();

		while (!studentsQueue.isEmpty()) {
			tempStack.push(studentsQueue.poll());
		}

		System.out.println("thứ tự tới của các học sinh theo thứ tự từ muộn nhất tới sớm nhất:");
		while (!tempStack.isEmpty()) {
			System.out.println(tempStack.pop());
		}
	}

	public void question3() {
		System.out.println("Nhập số sinh viên muốn tạo: ");
		int num2 = ScannerUltis.inputIntPositive();
		for (int i = 0; i < num2; i++) {
			Student stSet = new Student("Student Ques3 " + (i + 1));
			studentSet.add(stSet);
		}
		System.out.println("Tạo thành công " + studentSet.size() + " sinh viên.");
		Iterator<Student> iteratorSet = studentSet.iterator();
		for (int i = 0; i < studentSet.size(); i++) {
			System.out.println(iteratorSet.next());
		}
		System.out.println("Tổng số phần tử trong Set: " + studentSet.size());

		System.out.println("Phần tử thứ 4 trong Set: ");
		Iterator<Student> iteratorSet3 = studentSet.iterator();
		for (int i = 0; i <= 2; i++) {
			iteratorSet3.next();
		}
		System.out.println(iteratorSet3.next());

		Iterator<Student> iteratorSet4 = studentSet.iterator();
		System.out.println("Phần tử đầu của Set: " + iteratorSet4.next());
		for (int i = 0; i < studentSet.size() - 2; i++) {
			iteratorSet4.next();
		}
		System.out.println("Phần tử cuối của Set: " + iteratorSet4.next());

	}

}
