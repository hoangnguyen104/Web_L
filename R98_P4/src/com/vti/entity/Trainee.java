package com.vti.entity;

public class Trainee<T> {
	private T code;
	private String name;

	public T getCode() {
		return code;
	}

	public void setCode(T code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
