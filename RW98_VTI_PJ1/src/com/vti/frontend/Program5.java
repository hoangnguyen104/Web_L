package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Program5 {
	public static void main(String[] args) {
		// Tao Department
		Department dep1 = new Department();
		dep1.id = 1;
		dep1.name = "Sale";

		Department dep2 = new Department();
		dep2.id = 2;
		dep2.name = "IT";

		Department dep3 = new Department();
		dep3.id = 3;
		dep3.name = "Marketing";

		// Tao Position
		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.Dev;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.PM;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.Scrum_Master;

		// Tao Account
		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "acc1@gmail.com";
		acc1.username = "acc1";
		acc1.fullname = "Nguyen Van A";
		acc1.department = dep1;
		acc1.position = pos1;
		acc1.createdate = LocalDate.now();

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "acc2@gmail.com";
		acc2.username = "acc2";
		acc2.fullname = "Tran Thi B";
		acc2.department = dep2;
		acc2.position = pos2;
		acc2.createdate = LocalDate.now();

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "acc3@gmail.com";
		acc3.username = "acc3";
		acc3.fullname = "Cao Van C";
		acc3.department = dep3;
		acc3.position = pos3;
		acc3.createdate = LocalDate.now();

		// Tao Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Sale";
		group1.creator = acc1;
		group1.createdate = LocalDate.of(2020, 9, 23);

		Group group2 = new Group();
		group2.id = 2;
		group1.creator = acc2;
		group2.name = "Development";
		group2.createdate = LocalDate.now();

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Management";
		group3.creator = acc3;
		group3.createdate = LocalDate.of(2024, 10, 20);

		acc1.groups = new Group[] { group1, group2 };
		acc2.groups = new Group[] { group1, group2, group3 };
		acc3.groups = new Group[] { group2 };
		group1.accounts = new Account[] { acc1, acc2 };
		group2.accounts = new Account[] { acc1, acc2, acc3 };
		group3.accounts = new Account[] { acc2 };

//		System.out.println("Thông tin các Account trên hệ thống:");
//		System.out.println("Account 1: ID : " + acc1.id + " Email: " + acc1.email + " UserName: " + acc1.username
//				+ " FullName: " + acc1.fullname + " Department: " + acc1.department.name + " Position: "
//				+ acc1.position.name + " Group: " + acc1.groups[0].name + " " + acc1.groups[1].name + "CreateDate: "
//				+ acc1.createdate);
//
//		System.out.println("Account 2: ID : " + acc2.id + " Email: " + acc2.email + " UserName: " + acc2.username
//				+ " FullName: " + acc2.fullname + " Department: " + acc2.department.name + " Position: "
//				+ acc2.position.name + " Group: " + acc2.groups[0].name + " " + acc2.groups[1].name + "CreateDate: "
//				+ acc2.createdate);
//
//		System.out.println("Account 3: ID : " + acc3.id + " Email: " + acc3.email + " UserName: " + acc3.username
//				+ " FullName: " + acc3.fullname + " Department: " + acc3.department.name + " Position: "
//				+ acc3.position.name + " Group: " + "CreateDate: " + acc3.createdate);

//		Exercise 1
//		Question 1:

		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + acc2.department.name);
		}

//		Question 2:
		if (acc2.groups.length <= 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (acc2.groups.length <= 2) {
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		} else if (acc2.groups.length <= 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

//		Question 3:
		System.out.println((acc2.department == null) ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + acc2.department.name);

//		Question 4:
		System.out.println(
				(acc1.position.name == PositionName.Dev) ? "Đây là Developer" : "Người này không phải là Developer");

//		Question 5:
		System.out.println(group1.accounts.length);
		switch (group1.accounts.length) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}

//		Question 6:
		switch (acc2.groups.length) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}

//		Question 7:

		switch (acc1.position.name) {
		case Dev:
			System.out.println("Đây là Developer");
			break;

		default:
			System.out.println("Người này không phải là Developer");
			break;
		}

//		Question 8:
		Account[] accounts = { acc1, acc2, acc3 };

		for (Account acc : accounts) {
			System.out.println("Email: " + acc.email + " | FullName: " + acc.fullname + " | Department: "
					+ (acc.department != null ? acc.department.name : "Chưa có phòng ban"));
		}

//		Question 9:
		Department[] deps = { dep1, dep2, dep3 };
		for (Department dpm : deps) {
			System.out.println("Id: " + dpm.id + " Name: " + dpm.name);
		}

//		Question 10:
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: " + accounts[i].fullname);
			System.out.println("Phong ban: " + accounts[i].department.name);
			System.out.println("");
		}

//		Question 11:
		for (int i = 0; i < deps.length; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("\tId: " + deps[i].id);
			System.out.println("\tName: " + deps[i].name);
			System.out.println("");
		}

//		Question 12:
		for (int i = 0; i < 2; i++) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + deps[i].id);
			System.out.println("Name: " + deps[i].name);
			System.out.println("");
		}
//Question 13:
		for (int i = 0; i < accounts.length; i++) {
			if (i == 1) {
				continue;
			} else {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");
			}
		}
//Question 14:
		System.out.println("Question 14:");
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].id < 4) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");
			} else {
				break;
			}

		}
//		Question 15:
		System.out.println("Question 15:");
		for (int i = 0; i <= 20; i += 2) {
			System.out.print(i + " ");
		}

//		Question 16:
		System.out.println("\nQuestion 16:");
		{
			int i = 0;
			while (i < accounts.length) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");

				i++;
			}
		}
		{
			int i = 0;
			while (i < deps.length) {
				System.out.println("Thông tin department thứ " + (i + 1) + " là:");
				System.out.println("\tId: " + deps[i].id);
				System.out.println("\tName: " + deps[i].name);
				System.out.println("");

				i++;
			}
		}
		{
			int i = 0;
			while (i < 2) {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");

				i++;
			}
		}
		{
			int i = 0;
			while (i < accounts.length) {
				if (accounts[i].id < 4) {
					System.out.println("Thông tin account thứ " + (i + 1) + " là:");
					System.out.println("Email: " + accounts[i].email);
					System.out.println("Full name: " + accounts[i].fullname);
					System.out.println("Phong ban: " + accounts[i].department.name);
					System.out.println("");

				}
				i++;
			}
		}
		{
			int i = 0;
			while (i <= 20) {
				System.out.print(i + " ");
				i += 2;
			}
		}

//		Question 17:
		System.out.println("\nQuestion 17:");
		{
			int i = 0;
			do {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");

				i++;
			} while (i < accounts.length);

		}
		{
			int i = 0;
			do {
				System.out.println("Thông tin department thứ " + (i + 1) + " là:");
				System.out.println("\tId: " + deps[i].id);
				System.out.println("\tName: " + deps[i].name);
				System.out.println("");

				i++;
			} while (i < deps.length);

		}
		{
			int i = 0;
			do {
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Email: " + accounts[i].email);
				System.out.println("Full name: " + accounts[i].fullname);
				System.out.println("Phong ban: " + accounts[i].department.name);
				System.out.println("");

				i++;
			} while (i < 2);

		}
		{
			int i = 0;
			do {
				if (accounts[i].id < 4) {
					System.out.println("Thông tin account thứ " + (i + 1) + " là:");
					System.out.println("Email: " + accounts[i].email);
					System.out.println("Full name: " + accounts[i].fullname);
					System.out.println("Phong ban: " + accounts[i].department.name);
					System.out.println("");

				}
				i++;
			} while (i < accounts.length);

		}
		{
			int i = 0;
			do {
				System.out.print(i + " ");
				i += 2;
			} while (i <= 20);

		}

	}
}
