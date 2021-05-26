package com.revature.dao;
//import java.sql.SQLException;

import com.revature.menu.Account;
import com.revature.tay.Customer;

public interface CustomerDAO {
	public boolean UpdateSaving(Account a, Customer c);
	public boolean createAccount(Customer c, Account a);
	public boolean updateAccount(Account a, Customer c);
	public boolean removeCustomer(Customer c);

	
	}
