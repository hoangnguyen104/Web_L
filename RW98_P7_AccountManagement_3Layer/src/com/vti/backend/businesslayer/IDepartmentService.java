package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentService {

	List<Department> getAllDepartments() throws ClassNotFoundException;

	Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException;

	boolean checkExist(String name) throws ClassNotFoundException, SQLException;

	boolean createNewDepartment(String name) throws ClassNotFoundException, SQLException;

	boolean updateDepartment(int id, String name) throws ClassNotFoundException, SQLException;

	boolean deleteDepartment(String name) throws ClassNotFoundException, SQLException;

}
