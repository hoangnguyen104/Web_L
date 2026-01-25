package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepository {
	private JdbcUtils jdbcUtils;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Department> getAllDepartment() throws ClassNotFoundException {
		try {
			// Tao ket noi DB SEVER
			String selectSQL = "SELECT * FROM Department ";

			// Chay lenh SQL
			ResultSet rs = jdbcUtils.executeQuery(selectSQL);
			List<Department> listDepartments = new ArrayList<Department>();
			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt(1));
				department.setName(rs.getString(2));

				listDepartments.add(department);

			}
			return listDepartments;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Department getDepartmentByID(int idFind) throws ClassNotFoundException, SQLException {
		String sql_SelectDepartmentID = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTID = ?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_SelectDepartmentID);
		preparedStatement.setInt(1, idFind);

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt(1));
			department.setName(resultSet.getString(2));

			return department;
		}
		return null;

	}

	@Override
	public boolean checkExist(String name) throws ClassNotFoundException, SQLException {
		String sql_SelectDepartmentID = "SELECT * FROM DEPARTMENT WHERE DEPARTMENTNAME = ?;";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_SelectDepartmentID);
		preparedStatement.setString(1, name);

		ResultSet resultSet = preparedStatement.executeQuery();

		return resultSet.next();
	}

	@Override
	public boolean createNewDepartment(String name) throws SQLException, ClassNotFoundException {
		String sql_CreateDepartment = "INSERT INTO Department(Departmentname) value(?);";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_CreateDepartment);
		preparedStatement.setString(1, name);
		int row = preparedStatement.executeUpdate();
		return row == 1;

	}

	@Override
	public boolean updateDepartment(int id, String name) throws ClassNotFoundException, SQLException {
		String sql_updateDepartment = "Update Department SET DepartmentName = ? WHERE DepartmentID = ?";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_updateDepartment);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		int row = preparedStatement.executeUpdate();
		return row == 1;
	}

	@Override
	public boolean checkExistById(int id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT 1 FROM Department WHERE DepartmentID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

	@Override
	public boolean deleteDepartment(String name) throws ClassNotFoundException, SQLException {
		String sql_deleteDepartment = "Delete from DEPARTMENT WHERE DEPARTMENTNAME = ?";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_deleteDepartment);
		preparedStatement.setString(1, name);
		int row = preparedStatement.executeUpdate();
		return row == 1;
	}

}
