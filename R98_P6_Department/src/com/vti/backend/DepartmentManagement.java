package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.DepartmentDAO;
import com.vti.entity.Department;
import com.vti.ultis.ScannerUltis;

public class DepartmentManagement {
	private DepartmentDAO departmentDAO = new DepartmentDAO();

	public DepartmentManagement() throws FileNotFoundException, IOException {
		departmentDAO = new DepartmentDAO();
	}

	public void showListDepartment() throws FileNotFoundException, ClassNotFoundException, IOException {

		List<Department> listDepartments = departmentDAO.getListDepartment();

		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");
		System.out.println("+-----------+--------------------------------------+");

		for (Department department : listDepartments) {
			System.out.format("|    %-7d|    %-32s|%n", department.getId(), department.getName());
		}
	}

	public void showDepartmentByID() throws ClassNotFoundException, SQLException {
		System.out.println("Moi ban nhap vao id cua phong ban can tim kiem");
		int idFind = ScannerUltis.inputIntPositive();
		Department department = departmentDAO.getDepartmentByID(idFind);
		if (department != null) {
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7s|      %-32s|%n", "ID", "Department Name");
			System.out.println("+-----------+--------------------------------------+");
			System.out.format("|    %-7d|    %-34s|%n", department.getId(), department.getName());
			System.out.println("+-----------+--------------------------------------+");
		} else {
			System.out.println("Khong tim thay phong ban");
		}

	}

	public void createNewDepartment() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Nhap vao ten phong ban muon tao");
		String nameCreateDP = ScannerUltis.inputString();
		Department department = departmentDAO.CreateNewDepartment(nameCreateDP);
		showListDepartment();
	}

	public void deleteDepartment() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Nhap vao ten phong ban muon xoa");
		String nameDeleteDP = ScannerUltis.inputString();
		Department department = departmentDAO.DeleteDepartmentByName(nameDeleteDP);
		showListDepartment();
	}

	public void updateDepartment() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Nhap vao id phong ban can chinh sua ten:");
		int dpmidupdate = ScannerUltis.inputIntPositive();
		System.out.println("Nhap ten phong ban moi:");
		String upddpmname = ScannerUltis.inputString();
		Department department = departmentDAO.UpdateDepartment(dpmidupdate, upddpmname);
		showListDepartment();
	}
}
