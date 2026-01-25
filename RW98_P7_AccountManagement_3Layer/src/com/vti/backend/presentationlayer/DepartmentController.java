package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.DepartmentService;
import com.vti.backend.businesslayer.IDepartmentService;
import com.vti.entity.Department;

public class DepartmentController {
	private IDepartmentService departmentService;

	public DepartmentController() throws FileNotFoundException, IOException {
		super();
		departmentService = new DepartmentService();
	}

	public List<Department> getAllDepartment() throws ClassNotFoundException {
		// Tiếp nhận yêu cầu từ Frontend đẩy về
		// Validate dữ liệu
		// Xử lý Exception
		List<Department> listDepartments = departmentService.getAllDepartments();
		return listDepartments;
	}

	public Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException {
		Department department = departmentService.getDepartmentByID(idFind);
		return department;
	}

	public boolean checkExist(String name) throws ClassNotFoundException, SQLException {
		return departmentService.checkExist(name);
	}

	public boolean createNewDepartment(String name) throws ClassNotFoundException, SQLException {
		return departmentService.createNewDepartment(name);

	}

	public boolean updateDepartment(int id, String name) throws ClassNotFoundException, SQLException {
		return departmentService.updateDepartment(id, name);
	}

	public boolean deleteDepartment(String name) throws ClassNotFoundException, SQLException {
		return departmentService.deleteDepartment(name);
	}

}
