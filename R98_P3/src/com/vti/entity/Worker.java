package com.vti.entity;

public class Worker extends Staff {
	private int rank;

	public Worker(String name, int age, Gender gender, String address, int rank) {
		super(name, age, gender, address);
		this.rank = rank;
	}

	@Override
	public String toString() {

		return super.toString() + "Position: Worker [rank=" + rank + "]";
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}

}
