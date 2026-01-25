package com.vti.backend.datalayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Department;

public interface IDepartmentRepository {

	List<Department> getAllDepartment() throws ClassNotFoundException;

	Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException;

	boolean checkExist(String name) throws ClassNotFoundException, SQLException;

	boolean createNewDepartment(String name) throws SQLException, ClassNotFoundException;

	boolean updateDepartment(int id, String name) throws ClassNotFoundException, SQLException;

	boolean checkExistById(int id) throws ClassNotFoundException, SQLException;

	boolean deleteDepartment(String name) throws ClassNotFoundException, SQLException;

}
