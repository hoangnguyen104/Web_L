package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Exercise1 {

	public void question1() {
		Student[] studentArray = new Student[3];
		System.out.println("khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên " + (i + 1 + ":"));
			Student st = new Student();
			studentArray[i] = st;
		}

		System.out.println("Thông tin các sinh viên vừa nhập: ");
		for (int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);
		}
		System.out.println("Chuyển các sinh viên sang Đại học công nghệ: ");
		Student.college = "Đại học Công nghệ ";

		System.out.println("Thông tin sinh viên sau khi chuyển ");
		for (int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]);
		}
	}

	public void question2() {
		Student[] studentArray = new Student[3];
		System.out.println("khởi tạo 3 sinh viên");
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên " + (i + 1 + ":"));
			Student st = new Student();
			studentArray[i] = st;
		}
		System.out.println("Các sinh viên nộp quỹ, mỗi bạn 100K: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 300));
		System.out.println("Student thứ 1 lấy 50k đi mua bim bim, kẹo về liên hoan: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 50));
		System.out.println("Student thứ 2 lấy 20k đi mua bánh mì: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 20));
		System.out.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup -= 150));
		System.out.println("Các sinh viên nộp quỹ, mỗi bạn 50K: ");
		System.out.println("Tổng quỹ: " + (Student.moneyGroup += 150));
	}

	public void question3() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập vào số int 1:");
		int a = scanner.nextInt();
		System.out.println("Nhập vào số int 2:");
		int b = scanner.nextInt();

		System.out.println("Max a và b: " + MyMath.max(a, b));
		System.out.println("Min a và b: " + MyMath.min(a, b));
		System.out.println("Sum a và b: " + MyMath.sum(a, b));
	}

	public void question4() {
		System.out.println("Demo Get Set Collect: ");
		Student st = new Student();
		System.out.println("Collect là: " + st.getCollege());
		System.out.println("Thay đổi Collect: Đại học Hà Nội");
		st.setCollege("Đại học Hà Nội");
		System.out.println("Collect là: " + st.getCollege());

	}

	public void question5() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Sinh viên " + (i + 1 + ":"));
			Student st = new Student();
		}
		System.out.println("Dùng hàm khởi tạo sinh viên: ");
		Student st2 = new Student();
		Student st3 = new Student();
		System.out.println("Số sinh viên được tạo ra trên hệ thống là: " + Student.COUNT);

	}

	public void question6() {
		System.out.println("Tạo 2 Primary Student: ");
		PrimaryStudent pSt1 = new PrimaryStudent();
		PrimaryStudent pSt2 = new PrimaryStudent();
		System.out.println("Tạo 6 Secondary Student: ");
		SecondaryStudent sST1 = new SecondaryStudent();
		SecondaryStudent sST2 = new SecondaryStudent();
		SecondaryStudent sST3 = new SecondaryStudent();
		SecondaryStudent sST4 = new SecondaryStudent();
		SecondaryStudent sST5 = new SecondaryStudent();
		SecondaryStudent sST6 = new SecondaryStudent();
		System.out.println("Thông tin số lượng sinh viên");
		String leftAlignFormat = "| %-18s | %-4d |%n";

		System.out.format("+--------------------+------+%n");
		System.out.format("| Category           | SL   |%n");
		System.out.format("+--------------------+------+%n");

		System.out.format(leftAlignFormat, "Student", Student.COUNT);
		System.out.format(leftAlignFormat, "PrimaryStudent", PrimaryStudent.COUNTPri);
		System.out.format(leftAlignFormat, "SecondaryStudent", SecondaryStudent.COUNTSecond);

		System.out.format("+--------------------+------+%n");

	}

	public void question7() {
		for (int i = 0; i < 6; i++) {
			Student st = new Student();
		}
		System.out.println("Tạo Primary Student: ");
		PrimaryStudent pSt = new PrimaryStudent();
		System.out.println("Sinh viên Primary Student: " + pSt);

		System.out.println("Tạo Secondary Student: ");
		SecondaryStudent sSt = new SecondaryStudent();
		System.out.println("Sinh viên Secondary Student: " + sSt);
	}

	public void question8() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Tạo 4 hình chữ nhật.");
		HinhChuNhat[] hcns = new HinhChuNhat[4];
		for (int i = 0; i < 4; i++) {
			System.out.println("Hình " + (i + 1) + ":");
			System.out.println("Canh a: ");
			Float a = scanner.nextFloat();
			System.out.println("Canh b: ");
			Float b = scanner.nextFloat();
			HinhChuNhat hcn = new HinhChuNhat(a, b);
			hcns[i] = hcn;
		}
		System.out.println("Tạo hình tròn số 1, nhập vào bán kính ");
		Float r1 = scanner.nextFloat();
		HinhTron hinhtron1 = new HinhTron(r1, r1);

		System.out.println("Tạo hình tròn số 2, nhập vào bán kính ");
		Float r2 = scanner.nextFloat();
		HinhTron hinhtron2 = new HinhTron(r2, r2);
	}

}
