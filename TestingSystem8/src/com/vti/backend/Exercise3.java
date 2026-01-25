package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.Student1;

public class Exercise3 {
	public void question1() {
		// khởi tạo student có id là int
		Student1<Integer> student1 = new Student1<Integer>(1, "AAAAA");

		// khởi tạo student có id là float
		Student1<Float> student2 = new Student1<Float>(2.0f, " BBBBB");

		// khởi tạo student có id là double
		Student1<Double> student3 = new Student1<Double>(3.0, " CCCC");

		print(student1);
		print(1);
		print(2f);

	}

	public void question4() {
		Integer[] arrInt = { 5, 10, 15 };
		Float[] arrFloat = { 6f, 5f, 15f };
		Double[] arrDouble = { 5.2, 2.6, 6.9 };

		// print array
		printArray(arrInt);
		printArray(arrFloat);
		printArray(arrDouble);

	}

	public void question5() {
		System.out.println("Tạo Employee 1 ");
		Integer[] salInt = { 1000, 2000, 3000 };
		Employee<Integer> emInt = new Employee<Integer>("EmployeeInt", salInt);
		System.out.println("Tạo Employee 2 ");
		Float[] salFloat = { 1000f, 2000f, 3000f };
		Employee<Float> emFloat = new Employee<Float>("EmployeeFloat", salFloat);
		System.out.println("Tạo Employee 3 ");
		Double[] salDouble = { 1000.1, 2000.2, 3000.3 };
		Employee<Double> emDouble = new Employee<Double>("EmployeeInt", salDouble);
		System.out.println("Thông tin các Employee vừa tạo là:");
		System.out.println(emInt);
		System.out.println(emFloat);
		System.out.println(emDouble);
		System.out.println("Thông tin tháng lương cuối cùng: ");
		System.out.println(emInt.getLastSalary());
		System.out.println(emFloat.getLastSalary());
		System.out.println(emDouble.getLastSalary());

	}

	private <T> void print(T a) {
		System.out.println(a);
	}

	private <T> void printArray(T[] arr) {
		for (T x : arr) {
			System.out.println(x);
		}
	}

}
