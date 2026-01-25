package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.vti.dao.AccountDAO;
import com.vti.entity.Account;
import com.vti.entity.Department;

public class AccountManagement {
	private AccountDAO accountDAO = new AccountDAO();

	public AccountManagement() throws FileNotFoundException, IOException {
		accountDAO = new AccountDAO();
	}

	public void showListAccount() {
		List<Account> listAccounts = accountDAO.getListAccount();
		System.out.println("+-----------+--------------------------------------+");
		System.out.format("|    %-7s|      %-32s|%n", "ID", "");
		System.out.println("+-----------+--------------------------------------+");

		for (Account account : listAccounts) {
			System.out.format("|    %-7d|    %-32s|%n", );
		}
	}

	public void showAccountByID() {
		// TODO Auto-generated method stub

	}

	public void createNewAccount() {
		// TODO Auto-generated method stub

	}

	public void deleteAccount() {
		// TODO Auto-generated method stub

	}

	public void updateAccount() {
		// TODO Auto-generated method stub

	}

}
