package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.menu.Account;
//import com.revature.menu.Account;
import com.revature.tay.Customer;
import com.revature.util.ConnectionUtils;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public boolean createAccount(Customer c, Account a) {
		
		try (Connection conn = ConnectionUtils.getConnection()){ 
			String sql = "insert into customer(id, fname, lname, username, c_password, c_email)"
					+ "values(?,?,?,?,?,?)";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1,Customer.getCustomerid());
			statement.setString(2, c.getFirstname());
			statement.setString(3, c.getLastname());
			statement.setString(4, c.getUsername());
			statement.setString(5, c.getPassword());
			statement.setString(6, c.getPin());
			statement.execute();
			
	
			
			
			
			return true;
			
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCustomer(Customer c) {
		// TODO Auto-generated method stub
		return false;
	}
	/*
		
	//
	*/

	@Override
	public boolean updateAccount(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql2 = "insert into bank_account_c(customer_id, checkings_accountid, checkings_balance)"
					+ "values(?,?,?)";
			PreparedStatement statement1 = conn.prepareStatement(sql2);
			statement1.setInt(1, Customer.getCustomerid());
			statement1.setInt(2, a.getAccountid());
			statement1.setDouble(3, a.getAccountbalance());
			statement1.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean UpdateSaving(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
		String sql2 = "insert into bank_account_s(customer_id, savings_accountid, savings_balance)"
				+ "values(?,?,?)";
		PreparedStatement statement1 = conn.prepareStatement(sql2);
		statement1.setInt(1, Customer.getCustomerid());
		statement1.setInt(2, a.getJointaccountid());
		statement1.setDouble(3, Account.getSavingsbalance());
		statement1.execute();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	
}
	return false;
		
	}

	
	

	
	
	
}