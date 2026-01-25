package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.DepartmentRepository;
import com.vti.backend.datalayer.IDepartmentRepository;
import com.vti.entity.Department;

public class DepartmentService implements IDepartmentService {
	private IDepartmentRepository iDepartmentRepository;

	public DepartmentService() throws FileNotFoundException, IOException {
		super();
		iDepartmentRepository = new DepartmentRepository();
	}

	@Override
	public List<Department> getAllDepartments() throws ClassNotFoundException {
		List<Department> listDepartments = iDepartmentRepository.getAllDepartment();
		return listDepartments;
	}

	@Override
	public Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException {
		Department department = iDepartmentRepository.getDepartmentByID(idFind);
		return department;
	}

	@Override
	public boolean checkExist(String name) throws ClassNotFoundException, SQLException {
		return iDepartmentRepository.checkExist(name);
	}

	@Override
	public boolean createNewDepartment(String name) throws ClassNotFoundException, SQLException {
		if (iDepartmentRepository.checkExist(name)) {
			return false;
		}

		iDepartmentRepository.createNewDepartment(name);
		return true;

	}

	@Override
	public boolean updateDepartment(int id, String name) throws ClassNotFoundException, SQLException {
		if (!iDepartmentRepository.checkExistById(id)) {
			return false;
		}
		return iDepartmentRepository.updateDepartment(id, name);
	}

	@Override
	public boolean deleteDepartment(String name) throws ClassNotFoundException, SQLException {
		return iDepartmentRepository.deleteDepartment(name);
	}

}
