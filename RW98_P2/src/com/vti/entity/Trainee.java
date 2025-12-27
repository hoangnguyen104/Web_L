package com.vti.entity;

public class Trainee extends Person {
	private String university;

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public void showInfotrainee() {
		super.showInfo();
		System.out.println("university: " + this.university);
	}
}
