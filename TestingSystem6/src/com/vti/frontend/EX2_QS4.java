package com.vti.frontend;

import com.vti.entity.Department;

public class EX2_QS4 {
	public static void main(String[] args) {
		Department dep1 = new Department("Dep1");
		Department dep2 = new Department("Dep2");
		Department dep3 = new Department("Dep3");
		Department dep4 = new Department("Dep4");
		Department[] depArray = { dep1, dep2, dep3, dep4 };
		getIndex(depArray, 5);
	}

	public static void getIndex(Department[] depArray, int index) {
		try {
			System.out.println(depArray[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Cannot find department.");
		}
	}

}
