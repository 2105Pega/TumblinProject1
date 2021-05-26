package com.revature.dao;

import com.revature.menu.Account;
import com.revature.tay.Customer;

public interface AccountDAO {
	

public boolean withdraw_Checkings(Account a, Customer c);
public boolean depositsSavings(Account a, Customer c );
public boolean withdrawSavings(Account a, Customer c );
public boolean updateCheckings(Account a, Customer c);
public boolean updateSavingsTrans(Account a, Customer c );
public boolean depositCheckings(Account a, Customer c);
public boolean transfer(Account a, Customer c );

}
