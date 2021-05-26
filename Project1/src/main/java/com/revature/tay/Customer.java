package com.revature.tay;
import java.util.ArrayList;
//import java.sql.SQLException;

//import java.util.HashSet;
import java.util.Scanner;
//import java.util.Set;

import com.revature.menu.Account;
//import com.revature.services.CustomerServices;

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
private static String username;
private  static String firstname;
private  static String lastname;
private  static String pin;
private  static String password;
private static int customerid;
static ArrayList <Customer> customerList12 = new ArrayList<Customer>();

public Customer getCustomerList;



public static int getCustomerid() {
	return customerid;
}


public static void setCustomerid(int customerid) {
	Customer.customerid = customerid;
}


public Customer() {
	
}


public Customer(String firstname, String lastname, String pin, String password, Customer getCustomerList, int customerid) {
	super();
	Customer.customerid = customerid;
	Customer.firstname = firstname;
	Customer.lastname = lastname;
	Customer.pin = pin;
	Customer.password = password;
	this.getCustomerList = getCustomerList;
}
public void username(String username) {
	Customer.username = username;
}

public String getUsername() {
	return username;
}
public void setPin(String pin) {
	Customer.pin = pin;
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

	




		public static void createAccount1() throws Exception {
			
		

			
			
			Scanner scan = new Scanner(System.in);
			Customer c = new Customer();
			
			System.out.println("Please your User Name: ");
		      String username;
			
		      username= scan.nextLine();
		      c.setUsername(username);
			 while(username.length() == 0)
			{
				System.out.println("Please your User Name: ");
				username = scan.nextLine();
			}
			
			System.out.println("Please Enter Password: ");
			String password;
			
			password = scan.nextLine();
			c.setPassword(password); 
			while(password.length() == 0)
			{
				System.out.println("Please your User Name: ");
				password = scan.nextLine();
			}
			
			System.out.println("Please Enter your First Name: ");
			String firstname;
			
			firstname = scan.nextLine();
			c.setFirstname(firstname);
			while(firstname.length() == 0)
			{
				System.out.println("Please your User Name: ");
				firstname = scan.nextLine();
			}
			
			System.out.println("Please Enter your Last Name: ");
			String lastname;
			
			lastname = scan.nextLine();
			c.setLastname(lastname); 
			while(lastname.length() == 0)
			{
				System.out.println("Please your User Name: ");
				lastname = scan.nextLine();
			}
			
			System.out.println("Please Enter your email ");
			String pin;
			
			pin = scan.nextLine();
			c.setPin(pin);
			while(pin.length() == 0)
			{
				System.out.println("Please your User Name: ");
				pin = scan.nextLine();
			}
		
			customerList12.add(c);
			Customer.setCustomerid(23434);
			
			System.out.println("You have successfully signed up, your User_Id is  "  + Customer.getCustomerid());
    		
			
		
      
			
		   
			Account a = new Account();
			
			 File f = new File("employee.txt");{
				  
			     // Check if the specified file
			     // Exists or not
			     if (f.exists())
			         System.out.println();
			     else
			         System.out.println();
				 
				 try {
			         FileOutputStream fileOut = new FileOutputStream("employee.txt");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(customerList12);
			         out.close();
			         fileOut.close();
			      //   System.out.println("Serialized data is saved in \"employee.txt\"");
			      } catch (IOException i) {
			         i.printStackTrace();
			     
			
			
			
			      }finally {
			    		
			    	  a.createAccount();
						scan.close();
			      }
				
			 }
			
		
			}
		
		public ArrayList<Customer> getCustomerList12() {
			return customerList12;
		}
		public void setCustomerList12(ArrayList<Customer> customerList12) {
			Customer.customerList12 = customerList12;
		}
		//@Override
		//public String toString() {
			//return "Customer:" + "\r\n" +"Firstname:  " + getFirstname() + "\r\n" + "Lastname:  " + getLastname() + "\r\n" + "Username:   " + getUsername() + "\r\n" + "Password:   " + getPassword();
					//}
		
		public String toString() {
			return "Customer [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
					+ pin + ", password=" + password + "]";
		}
		
		 public static void Accountlogin() {
		 
			 //ArrayList< Customer> customerList1 = new ArrayList <Customer>();
			   
			   Scanner scan = new Scanner(System.in);
			 Customer c = new Customer();
			   
			  System.out.println("Please enter your username: ");
			   String input = scan.next();
			   if (c.getUsername().equals(input)) {
				   System.out.println("Please enter Password");
			   
			   }else {
				   System.out.println("Invaild Username");
				   Accountlogin();
			   }
			  
			   String input2 = scan.next();
			   if(c.getPassword().equals(input2)) {
				   Account.Accountstatus();
			   }else {
				   System.out.println("Invaild password please try again");
				   Accountlogin();
			   }
		scan.close();	   
}
		 
}
