package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.vti.dao.PositionDao;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class PositionManagement {
	private PositionDao positionDao = new PositionDao();

	public PositionManagement() throws FileNotFoundException, IOException {
		positionDao = new PositionDao();
	}

	public void showListPosition() {
		List<Position> listPositions = positionDao.getListPosition();
		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "Position Name");
		System.out.println("+-----------+--------------------------------------+");

		for (Department department : listPositions) {
			System.out.format("|    %-7d|    %-32s|%n", department.getId(), department.getName());
		}
	}

	public void showPositionByID() {
		// TODO Auto-generated method stub

	}

	public void createNewPosition() {
		// TODO Auto-generated method stub

	}

	public void deletePosition() {
		// TODO Auto-generated method stub

	}

	public void updatePosition() {
		// TODO Auto-generated method stub

	}

}
