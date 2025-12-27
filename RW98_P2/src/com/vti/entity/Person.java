package com.vti.entity;

public abstract class Person {
	private int id;
	private String email;
	private String username;
	private String fullname;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String email, String username, String fullname) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

//	public void showInfo() {
//		System.out.println("Id: " + this.id);
//		System.out.println("Email: " + this.email);
//		System.out.println("Username: " + this.username);
//		System.out.println("Fullname: " + this.fullname);
//	}
}
