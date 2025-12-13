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

		Group[] groups_Account1 = { group1, group2 };
		acc1.groups = groups_Account1;

		Group[] groups_Account2 = { group1, group2, group3 };
		acc2.groups = groups_Account2;

		Group[] groups_Account3 = { group2 };
		acc3.groups = groups_Account3;

		System.out.println("Thông tin các Account trên hệ thống:");
		System.out.println("Account 1: ID : " + acc1.id + " Email: " + acc1.email + " UserName: " + acc1.username
				+ " FullName: " + acc1.fullname + " Department: " + acc1.department.name + " Position: "
				+ acc1.position.name + " Group: " + acc1.groups[0].name + " " + acc1.groups[1].name + "CreateDate: "
				+ acc1.createdate);

		System.out.println("Account 2: ID : " + acc2.id + " Email: " + acc2.email + " UserName: " + acc2.username
				+ " FullName: " + acc2.fullname + " Department: " + acc2.department.name + " Position: "
				+ acc2.position.name + " Group: " + acc2.groups[0].name + " " + acc2.groups[1].name + "CreateDate: "
				+ acc2.createdate);

		System.out.println("Account 3: ID : " + acc3.id + " Email: " + acc3.email + " UserName: " + acc3.username
				+ " FullName: " + acc3.fullname + " Department: " + acc3.department.name + " Position: "
				+ acc3.position.name + " Group: " + "CreateDate: " + acc3.createdate);
	}
}
