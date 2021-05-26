package com.revature.services;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.menu.Account;
import com.revature.tay.Customer;

public class AccountServices {

	
private AccountDAO adao = new AccountDAOImpl();
 public boolean updateCheckings(Account a, Customer c) {
	return adao.updateCheckings(a,c);
	 }
public boolean updateSavingsTrans(Account a,Customer c) {
	return adao.updateSavingsTrans(a, c);
}

public boolean depositCheckings(Account a, Customer c) {
	return adao.depositCheckings(a, c);
}
public boolean withdraw_Checkings(Account a, Customer c) {
	return adao.withdraw_Checkings(a,c);
}

public boolean depositsSavings(Account a, Customer c) {
	return adao.depositsSavings(a,c);
}

public boolean withdrawSavings(Account a, Customer c) {
	return adao.withdrawSavings(a, c);
}

public boolean transfer(Account a, Customer c) {
	return adao.transfer(a, c);
}

}
