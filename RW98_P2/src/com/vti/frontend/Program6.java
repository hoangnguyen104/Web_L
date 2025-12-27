package com.vti.frontend;

import com.vti.entity.Trainee;

public class Program6 {
	public static void main(String[] args) {
		Trainee trainee1 = new Trainee();
		trainee1.setId(1);
		trainee1.setEmail("trainee1@");
		trainee1.setUsername("trainee1");
		trainee1.setFullname("Trainee1");
		trainee1.setUniversity("BKHN");

		System.out.println("ID: " + trainee1.getId() + " ,username: " + trainee1.getUsername());
		trainee1.showInfotrainee();
	}
}
