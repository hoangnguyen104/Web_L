package com.vti.frontend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Program6 {
	public static void main(String[] args) {
		Map<String, String> nameStudentHasMap = new HashMap<String, String>();
		nameStudentHasMap.put("VTI001", "AAAA");
		nameStudentHasMap.put("VTI002", "BBB");
		nameStudentHasMap.put("VTI003", "EEEE");
		nameStudentHasMap.put("VTI004", "CCCCC");
		nameStudentHasMap.put("VTI005", "DDDDD");

		// Hien thi cac phan tu trong MAp
		for (Entry<String, String> entry : nameStudentHasMap.entrySet()) {
			System.out.println(entry.getKey() + "  " + entry.getValue());

		}
		// Su dung iterator de hien thi thong tin
		Iterator<Map.Entry<String, String>> iterator = nameStudentHasMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<java.lang.String, java.lang.String> entry = iterator.next();
			System.out.println(entry.getKey() + "    " + entry.getValue());

		}
	}
}
