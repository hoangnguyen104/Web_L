package com.vti.entity;

import java.time.LocalDate;

public class Account {
	private int id;
	private String email;
	private String username;
	private String fullname;
	private Department department;
	private Position position;
	private LocalDate createdate;
	private Group[] groups;

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDate createdate) {
		this.createdate = createdate;
	}

	public Group[] getGroups() {
		return groups;
	}

	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account() {
	}

	public Account(String username) {
		this.username = username;
	}

	public Account(int id, String email, String username, String firstname, String lastname) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstname + lastname;
	}

	public Account(int id, String email, String username, String firstname, String lastname, Position position) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstname + lastname;
		this.position = position;
		this.createdate = LocalDate.now();
	}

	public Account(int id, String email, String username, String firstname, String lastname, Position position,
			LocalDate createdate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = firstname + lastname;
		this.position = position;
		this.createdate = createdate;
	}

}
