package com.vti.entity;

public class Group {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}

	public Group(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}
