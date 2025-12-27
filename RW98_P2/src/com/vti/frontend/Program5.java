package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

public class Program5 {
	public static void main(String[] args) {
		Department department1 = new Department();
		Department department2 = new Department("Sale");
		question3();
	}

	public static void question2() {
		Account acc1 = new Account();
		Account acc2 = new Account(2, "email2", "username2", "full", "name2");
		Position pos3 = new Position();
		Account acc3 = new Account(3, "email3", "username3", "full3", "name3", pos3);
		System.out.println(acc3.getCreatedate());

		Position pos4 = new Position();
		Account acc4 = new Account(3, "email3", "username3", "full", "name3", pos4, LocalDate.of(2021, 03, 17));
	}

	public static void question3() {
		Group g1 = new Group();

		Account acc1 = new Account("acc1");
		Account acc2 = new Account("acc2");
		Group g2 = new Group("Group 2", acc1, new Account[] { acc1, acc2 }, LocalDate.now());
		System.out.println(g2.toString());
		;
	}

}
