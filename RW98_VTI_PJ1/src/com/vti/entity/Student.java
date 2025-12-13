package com.vti.entity;

public class Student {
	public String name;
	public int age;

	public void goToVTI() {
		System.out.println(this.name + ": Go to VTI to Study!!");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

//	@Override
//	public String toString() {
//		// System.out.println("Tôi là: " + this.name + ", tôi " + this.age + " tuổi");
//		return "Student [name= " + this.name + " , age= " + this.age + " ]";
//	}

}
