package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float score;

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return 100 + id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void goVTI() {
		System.out.println("go to VTi to learn!!");
	}

	public void showinfo() {
		if (this.score < 4) {
			System.out.println("Ten sv: " + this.name + " ,hoc luc Yeu");
		} else if (this.score < 6) {
			System.out.println("Ten sv: " + this.name + " ,hoc luc Trung binh");
		} else if (this.score < 8) {
			System.out.println("Ten sv: " + this.name + " ,hoc luc Kha");
		} else {
			System.out.println("Ten sv: " + this.name + " ,hoc luc Gioi");
		}
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void plusScore(float score) {
		this.score = this.score + score;
	}

	public Student(String name, String hometown) {
		super();
		this.name = name;
		this.hometown = hometown;
		this.score = 0;
	}

}
