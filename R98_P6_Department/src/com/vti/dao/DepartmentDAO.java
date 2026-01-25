package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.ultis.JdbcUtils;

public class DepartmentDAO {
	private JdbcUtils jdbcUtils;

	public DepartmentDAO() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getListDepartment() throws FileNotFoundException, IOException, ClassNotFoundException {
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

	public Department CreateNewDepartment(String nameCreateDP) throws ClassNotFoundException, SQLException {
		String sql_CreateDepartment = "INSERT INTO Department(Departmentname) value(?);";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_CreateDepartment);
		preparedStatement.setString(1, nameCreateDP);
		int resultSet = preparedStatement.executeUpdate();
		Department department = null;

		if (resultSet == 1) {
			System.out.println("them thanh cong");
		} else {
			System.out.println("Khong thanh cong");
		}
		return null;
	}

	public Department DeleteDepartmentByName(String nameDeleteDP) throws ClassNotFoundException, SQLException {
		String sql_DeleteDepartment = "Delete from DEPARTMENT WHERE DEPARTMENTNAME = ?";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_DeleteDepartment);
		preparedStatement.setString(1, nameDeleteDP);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			System.out.println("xoa thanh cong");
		} else {
			System.out.println("Khong thanh cong");
		}
		return null;
	}

	public Department UpdateDepartment(int dpmidupdate, String upddpmname) throws ClassNotFoundException, SQLException {
		String sql_UpdateDepartment = "Update Department set DepartmentName = ? where Departmentid = ?";
		PreparedStatement preparedStatement = jdbcUtils.createPrepareStatement(sql_UpdateDepartment);
		preparedStatement.setString(1, upddpmname);
		preparedStatement.setInt(2, dpmidupdate);
		int resultSet = preparedStatement.executeUpdate();
		if (resultSet == 1) {
			System.out.println("update thanh cong");
		} else {
			System.out.println("Khong thanh cong");
		}
		return null;
	}

}
