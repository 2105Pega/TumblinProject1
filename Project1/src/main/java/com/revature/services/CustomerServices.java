package com.revature.services;

import com.revature.dao.CustomerDAO;
import com.revature.dao.CustomerDAOImpl;
import com.revature.menu.Account;
import com.revature.tay.Customer;

public class CustomerServices {
 private CustomerDAO cdao = new CustomerDAOImpl();
 
 public boolean createAccount(Customer c, Account a) {
	
	 
	 return cdao.createAccount(c,a);

 }
 public boolean updateAccount(Account a, Customer c) {
	return cdao.updateAccount(a, c);
	 
 }
 
 
 public boolean UpdateSaving(Account a, Customer c) {
		
		return cdao.UpdateSaving(a, c);
	}
	 
 
	 
	 
 
}
