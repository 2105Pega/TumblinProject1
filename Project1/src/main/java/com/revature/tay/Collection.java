package com.revature.tay;
import java.io.Serializable;
import java.util.ArrayList;
public class Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Customer> customerList1;
	
	static ArrayList<String> customerList = new ArrayList<String>();
	
	public static void Customerlist(){
	Customer c = new Customer();
	
	for (int i = 0; i < customerList.size(); i++) {
	     System.out.println(customerList.get(i));
	     
	    
	 }
	 customerList.add(c.toString());
	
	
	 System.out.println(customerList);
	// System.out.print(dc.toString());
	
	}
	

	public ArrayList<Customer> getCustomerList() {
		return customerList1;
	}
	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList1 = customerList;
	}
	
}


