package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.vti.entity.Position;
import com.vti.ultis.JdbcUtils;

public class PositionDao {
	private JdbcUtils jdbcUtils;

	public PositionDao() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Position> getListPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
