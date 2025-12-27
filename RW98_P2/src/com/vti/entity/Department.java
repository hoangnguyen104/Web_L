package com.vti.entity;

public class Department {
	public int id;
	public String name;

	public Department(String name) {
		this.id = 0;
		this.name = name;
	}

	public Department() {
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
