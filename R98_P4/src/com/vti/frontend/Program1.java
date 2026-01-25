package com.vti.frontend;

import java.util.ArrayList;
import java.util.Iterator;

public class Program1 {
	public static void main(String[] args) {
		ArrayList<String> nameArrayList = new ArrayList<String>();
		nameArrayList.add("Lan");
		nameArrayList.add("a");
		nameArrayList.add("Lf");
		nameArrayList.add("Lfdada");
		nameArrayList.add("adaen");

		System.out.println("---foreach---");
		for (String name : nameArrayList) {
			System.out.println(name);
		}

		System.out.println("---iterator---");
		Iterator<String> iterator = nameArrayList.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);

		}
		System.out.println("------------");
		System.out.println(nameArrayList.get(0));
		System.out.println("------------");
		System.out.println(nameArrayList.contains("abc"));
		System.out.println("------------");
		System.out.println(nameArrayList.indexOf("abc"));
	}
}
