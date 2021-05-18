package com.revature.tay;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.menu.Account;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static  String username;
private static String firstname;
private static String lastname;
private static String pin;
private static String password;


private static  ArrayList<Customer> customerList;

public Customer getCustomerList;



public Customer(String username, String firstname, String lastname, String password){
	
}


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	Customer.username = username;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	Customer.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	Customer.lastname = lastname;
}
public String getPin() {
	return pin;
}
public void pin(String pin) {
	Customer.pin = pin;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	Customer.password = password;
}
public Customer(String username, String firstname, String lastname, String pin, String password ) {

	username = "Tybian";
	firstname = "Tay";
	lastname = "YUu";
	pin = "3333";
	password = "hfrjfe";
	
}
public Customer() {
	// TODO Auto-generated constructor stub
}
public Customer(String username2, String firstname2, String lastname2, String password2, String accountid2,
		ArrayList<Customer> customerList2) {
	// TODO Auto-generated constructor stub
}
public ArrayList<Customer> getCustomerList() {
	return customerList;
}

		

public void setCustomerList(ArrayList<Customer> customerList) {
	Customer.customerList = customerList;
}




		public static void createAccount() {
			 
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please your User Name: ");
			
			username= scan.nextLine();
			
			 while(username.length() == 0)
			{
				System.out.println("Please your User Name: ");
				username = scan.nextLine();
			}
			
			System.out.println("Please Enter Password: ");
			password = scan.nextLine();
			while(password.length() == 0)
			{
				System.out.println("Please your User Name: ");
				password = scan.nextLine();
			}
			
			System.out.println("Please Enter your First Name: ");
			firstname = scan.nextLine();
			while(firstname.length() == 0)
			{
				System.out.println("Please your User Name: ");
				firstname = scan.nextLine();
			}
			
			System.out.println("Please Enter your Last Name: ");
			lastname = scan.nextLine();
			while(password.length() == 0)
			{
				System.out.println("Please your User Name: ");
				lastname = scan.nextLine();
			}
			
			System.out.println("Please Enter your email ");
			pin = scan.nextLine();
			while(pin.length() == 0)
			{
				System.out.println("Please your User Name: ");
				pin = scan.nextLine();
			}
			
			Customer c = new Customer(username, firstname, lastname, password, pin);
			customerList = new ArrayList<Customer>();

			
		
			
			        if(customerList != null) {
				
				    customerList.add(c);
			        }
			        else
			        customerList.add(c);
		
			
			System.out.println(customerList);
			
		   
			Account a = new Account();
			
			 File f = new File("employee.txt");{
				  
			     // Check if the specified file
			     // Exists or not
			     if (f.exists())
			         System.out.println("Exists");
			     else
			         System.out.println("Does not Exists");
				 
				 try {
			         FileOutputStream fileOut = new FileOutputStream("employee.txt");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(customerList);
			         out.close();
			         fileOut.close();
			         System.out.println("Serialized data is saved in \"employee.txt\"");
			      } catch (IOException i) {
			         i.printStackTrace();
			     
			
			
			
			      }finally {
			    	
			    	  a.createAccount();
						scan.close();
			      }
				
			 }
			
		
			
			
			}
		
		@Override
		public String toString() {
			return "Customer:" + "\r\n" +"Firstname:  " + getFirstname() + "\r\n" + "Lastname:  " + getLastname() + "\r\n" + "Username:   " + getUsername() + "\r\n" + "Password:   " + getPassword();
					
		}
		
}
