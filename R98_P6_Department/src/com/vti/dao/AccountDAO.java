package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.ultis.JdbcUtils;

public class AccountDAO {
	private JdbcUtils jdbcUtils;

	public AccountDAO() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getListAccount() throws ClassNotFoundException, SQLException {
		try {
			String selectSQL = "Select * from account";
			ResultSet resultSet = jdbcUtils.executeQuery(selectSQL);
			List<com.vti.entity.Account> listAccounts = new ArrayList<Account>();
			while (resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt(1));
				account.setEmail(resultSet.getString(2));
				account.setUsername(resultSet.getString(3));
				account.setFullName(resultSet.getString(4));
				account.setDepartment(resultSet.getInt(5));
				
				listAccounts.add(account);

			}
			return listAccounts;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
