package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
	public int id;
	public String name;
	public Account creator;
	public LocalDate createdate;
	public Account[] accounts;

	public Group() {

	}

	public Group(String groupname, Account creator, Account[] accounts, LocalDate createdate) {
		this.name = groupname;
		this.creator = creator;
		this.createdate = createdate;
		this.accounts = accounts;
	}

	public Group(String name, Account creator, String[] usernames, LocalDate createDate) {
		this.name = name;
		this.creator = creator;
		Account[] accounts = new Account[usernames.length];
		for (int i = 0; i < usernames.length; i++) {
			accounts[i] = new Account(usernames[i]);
		}
		this.createdate = createDate;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator.fullname + ", createdate=" + createdate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}

}
