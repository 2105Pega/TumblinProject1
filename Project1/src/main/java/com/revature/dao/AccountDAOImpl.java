package com.revature.dao;

import com.revature.menu.Account;
import com.revature.tay.Customer;
import com.revature.util.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AccountDAOImpl implements AccountDAO {

	

	@Override
	public boolean withdraw_Checkings(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql =  "Update bank_account_c set checkings_balance = ?"
					 + "where bank_account_c.checkings_accountid = ?";
					 
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, a.getAccountbalance());
			statement.setInt(2,a.getAccountid());
			
			statement.execute();
			String sql1 = "Update transactions set amount = - ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
			//UPDATE myTable SET myField='NewValue' WHERE iD= (SELECT MAX(iD) FROM myTable)
	        PreparedStatement statement2 = conn.prepareStatement(sql1);
	        statement2.setDouble(1, a.getAmmount());
	        //statement2.setInt(2, Customer.getCustomerid());
	        statement2.execute();
	        String sql2 = "Update transactions set total_checkings = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
	        
	        PreparedStatement statement3 = conn.prepareStatement(sql2);
	        statement3.setDouble(1, a.getAccountbalance());
	        statement3.execute();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	


	@Override
	public boolean withdrawSavings(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql =  "Update bank_account_s set savings_balance = ?"
					 + "where bank_account_s.savings_accountid = ?";
					 
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, Account.getSavingsbalance());
			statement.setInt(2, a.getJointaccountid());
			
			statement.execute();
			String sql1 = "Update transactions set amount = - ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
			//UPDATE myTable SET myField='NewValue' WHERE iD= (SELECT MAX(iD) FROM myTable)
	        PreparedStatement statement2 = conn.prepareStatement(sql1);
	        statement2.setDouble(1, a.getAmmount());
	        //statement2.setInt(2, Customer.getCustomerid());
	        statement2.execute();
	        String sql2 = "Update transactions set total_savings = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
	        
	        PreparedStatement statement3 = conn.prepareStatement(sql2);
	        statement3.setDouble(1, Account.getSavingsbalance());
	        statement3.execute();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCheckings(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql = "insert into transactions(customer_id, checkings_accountid, savings_accountid, current_checkings)"
					+ "values(?,?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Customer.getCustomerid());
			statement.setInt(2, a.getAccountid());
			statement.setInt(3, a.getJointaccountid());
			statement.setDouble(4, a.getAccountbalance());
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSavingsTrans(Account a, Customer c ) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql = "insert into transactions(customer_id, checkings_accountid, savings_accountid, current_savings)"
					+ "values(?,?,?,?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, Customer.getCustomerid());
			statement.setInt(2, a.getAccountid());
			statement.setInt(3, a.getJointaccountid());
			statement.setDouble(4, Account.getSavingsbalance());
			statement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean depositCheckings(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql =  "Update bank_account_c set checkings_balance = ?"
					 + "where bank_account_c.checkings_accountid = ?";
					 
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, a.getAccountbalance());
			statement.setInt(2,a.getAccountid());
			
			statement.execute();
			String sql1 = "Update transactions set amount = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
			//UPDATE myTable SET myField='NewValue' WHERE iD= (SELECT MAX(iD) FROM myTable)
	        PreparedStatement statement2 = conn.prepareStatement(sql1);
	        statement2.setDouble(1, a.getAmmount());
	        //statement2.setInt(2, Customer.getCustomerid());
	        statement2.execute();
	        String sql2 = "Update transactions set total_checkings = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
	        
	        PreparedStatement statement3 = conn.prepareStatement(sql2);
	        statement3.setDouble(1, a.getAccountbalance());
	        statement3.execute();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}




	@Override
	public boolean depositsSavings(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()){
			String sql =  "Update bank_account_s set savings_balance = ?"
					 + "where bank_account_s.savings_accountid = ?";
					 
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, Account.getSavingsbalance());
			statement.setInt(2,a.getJointaccountid());
			
			statement.execute();
			String sql1 = "Update transactions set amount = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
			//UPDATE myTable SET myField='NewValue' WHERE iD= (SELECT MAX(iD) FROM myTable)
	        PreparedStatement statement2 = conn.prepareStatement(sql1);
	        statement2.setDouble(1, a.getAmmount());
	        //statement2.setInt(2, Customer.getCustomerid());
	        statement2.execute();
	        String sql2 = "Update transactions set total_savings = ?"
					+ "where trans_id = (Select MAX(trans_id) from transactions)";
	        
	        PreparedStatement statement3 = conn.prepareStatement(sql2);
	        statement3.setDouble(1, Account.getSavingsbalance());
	        statement3.execute();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}




	@Override
	public boolean transfer(Account a, Customer c) {
		try (Connection conn = ConnectionUtils.getConnection()) {
			String sql =  "Update bank_account_c set checkings_balance = ?"
					 + "where bank_account_c.checkings_accountid = ?";
					 
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, a.getAccountbalance());
			statement.setInt(2,a.getAccountid());
			
			statement.execute();
		     
			String sql2 =  "Update bank_account_s set savings_balance = ?"
					 + "where bank_account_s.savings_accountid = ?";
					 
			
			
			PreparedStatement statement2 = conn.prepareStatement(sql2);
			statement2.setDouble(1, Account.getSavingsbalance());
			statement2.setInt(2, a.getJointaccountid());
			
			statement2.execute();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	

	

	

/*	*/

}
