package com.vti.frontend;

import com.vti.entity.Trainee;

public class Program7 {
	public static void main(String[] args) {
//		Trainee trainee1 = new Trainee();
//		trainee1.setCode(1);
//		trainee1.setName("T1");
//
//		Trainee trainee2 = new Trainee();
//		trainee2.setCode(2);
//		trainee2.setName("T2");
		Trainee<Integer> trainee1 = new Trainee<Integer>();
		trainee1.setCode(1);
		trainee1.setName("T1");

		Trainee<Integer> trainee2 = new Trainee<Integer>();
		trainee2.setCode(2);
		trainee2.setName("T2");

		Trainee<String> trainee3 = new Trainee<String>();
		trainee3.setCode("VTI003");
		trainee3.setName("T3");
	}
}
