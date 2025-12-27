package com.vti.backend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.vti.entity.Engineer;
import com.vti.entity.Gender;
import com.vti.entity.Staff;
import com.vti.entity.Worker;

public class StaffManagement {

	private Scanner scanner;
	private ArrayList<Staff> staffArrayList;

	public StaffManagement() {
		super();
		scanner = new Scanner(System.in);
		staffArrayList = new ArrayList<Staff>();
	}

	public void addNewStaff() {
		System.out.println("Them moi can bo");
		System.out.println("1. Them Engineer");
		System.out.println("2. Them Worker");
		System.out.println("3. Them Employee");

		int choose = scanner.nextInt();

		switch (choose) {
		case 1:
			System.out.println("Them moi Engineer");
			System.out.println("Nhập vào tên Engineer: ");
			String nameEngineer = scanner.next();
			System.out.println("Nhập vào tuổi Engineer: ");
			int ageEngineer = scanner.nextInt();
			System.out.println("Nhập vào giới tính Engineer 1.Male, 2.Female, 3.Unknown: ");
			int genderchoose = scanner.nextInt();
			Gender genderEngineer = null;

			switch (genderchoose) {
			case 1:
				genderEngineer = Gender.MALE;
				break;
			case 2:
				genderEngineer = Gender.FEMALE;
				break;
			case 3:
				genderEngineer = Gender.UNKNOWN;
				break;

			}

			System.out.println("Nhap dia chi Engineer: ");
			String addressEngineer = scanner.next();

			System.out.println("Nhap chuyen nganh: ");
			String specializedEngineer = scanner.next();

			// tao engineer
			Engineer engineer = new Engineer(nameEngineer, ageEngineer, genderEngineer, addressEngineer,
					specializedEngineer);

			staffArrayList.add(engineer);

			break;
		case 2:
			System.out.println("Them moi Worker");
			System.out.println("Nhập vào tên Worker: ");
			String nameWorker = scanner.next();
			System.out.println("Nhập vào tuổi Worker: ");
			int ageWorker = scanner.nextInt();
			System.out.println("Nhập vào giới tính Worker 1.Male, 2.Female, 3.Unknown: ");
			int genderchoose1 = scanner.nextInt();
			Gender genderWorker = null;

			switch (genderchoose1) {
			case 1:
				genderWorker = Gender.MALE;
				break;
			case 2:
				genderWorker = Gender.FEMALE;
				break;
			case 3:
				genderWorker = Gender.UNKNOWN;
				break;

			}

			System.out.println("Nhap dia chi Worker: ");
			String addressWorker = scanner.next();

			System.out.println("Nhap cap bac: ");
			int rankWorker = scanner.nextInt();

			// tao engineer
			Worker worker = new Worker(nameWorker, ageWorker, genderWorker, addressWorker, rankWorker);

			staffArrayList.add(worker);
			break;

		case 3:
			System.out.println("Them moi Employee");
			break;

		}
	}

	public void findByName() {
		System.out.println("Nhap ten muon tim: ");
		String name = scanner.next();
		for (Staff staff : staffArrayList) {
			if (staff.getName().equals(name)) {
				System.out.println(staff.toString());
			}
		}
	}

	public void showListStaff() {
		System.out.println("Hien thi thong tin danh sach can bo dang co tren he thong");
		for (Staff staff : staffArrayList) {
			System.out.println(staff.toString());
		}
	}

	public void deleteStaffByName() {
		System.out.println("Nhap ten muon xoa");
		String name = scanner.next();
		Iterator<Staff> iterator = staffArrayList.iterator();

		while (iterator.hasNext()) {
			Staff staff = iterator.next();
			if (staff.getName().equalsIgnoreCase(name)) {
				iterator.remove();
				System.out.println("Da xoa can bo thanh cong!");
				showListStaff();
			}
		}

	}

}
