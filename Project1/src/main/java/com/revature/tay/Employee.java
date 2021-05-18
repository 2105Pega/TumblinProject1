package com.revature.tay;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.revature.driver.MainMenu;
import com.revature.menu.Account;
import com.revature.menu.AccountUsage;
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static String username = "Tay";
private String password = "Taybian1";

public static String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public static  void login() {
	Scanner scan = new Scanner(System.in);
	  int empMenu =0;
		System.out.println("Welcome " + Employee.getUsername()+  " please select an option:");
	System.out.println("1. View Accounts");
	System.out.println("2. Pending Appilcations");
	System.out.println("3. Log out");
	System.out.println("4. Quit Program");
	while (!scan.hasNextInt()) {
	      System.out.println("Input is not a valid number.");
	      scan.nextLine();
	    }
	empMenu = scan.nextInt();
	switch(empMenu) {
	case 1:
		viewAccounts();
		break;
	case 2:PendingAccounts();
		break;
	case 3: MainMenu.mainMenu();
	    break;
	case 4:
		System.out.println("You have Exited the program");
	}
	scan.close();
}

public static void viewAccounts(){
	Customer c = new Customer();
	
	Account a = new Account();
	
	
    
	System.out.println("This is a list of bankaccounts ");
	if(c.getUsername() == null) {
    System.out.println("No accounts have been created yet");
	  login();
	  } 
	else {System.out.println(c);
    System.out.println(a.toString());
    File f = new File("Accounts.txt");{
		  
	     // Check if the specified file
	     // Exists or not
	     if (f.exists())
	         System.out.println("Exists");
	     else
	         System.out.println("Does not Exists");
		 
		 try {
	         FileOutputStream fileOut = new FileOutputStream("Accounts.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(a.toString());
	         out.close();
	         fileOut.close();
	         System.out.println("Serialized data is saved in \"Accounts.txt");
	      } catch (IOException i) {
	         i.printStackTrace();
	     
	
	
	
	      }finally {
    editAccounts();
    }
	}
	}
}

public static void editAccounts() {
	
	Customer c = new Customer();
	Scanner scan = new Scanner(System.in);
	System.out.println("Edit Account");
	int empMenu =0;
System.out.println("Welcome " + Employee.getUsername()+  " please select an option to edit account");
if(c.getCustomerList == null)
{System.out.println("1.   " + c.getUsername() );
System.out.println("2." +" Back to Admin Menu");}
else{System.out.println("1.   " +  c.getUsername()  );

System.out.println("3." +" Back to Admin Menu");}
while (!scan.hasNextInt()) {
    System.out.println("Input is not a valid number.");
    scan.nextLine();
  }
empMenu = scan.nextInt();
switch(empMenu) {
case 1:
	Account.Status2();
	break;
case 2:Employee.login();
	break;

}
scan.close();
}
public static void PendingAccounts() {
	
	
	if(AccountUsage.pending == "pending") {
		System.out.println("This is working mate");
		Scanner scan = new Scanner(System.in);
		int empMenu = 0;
		System.out.println("Do you want to Approve this account?");
	System.out.println("1.    Yes"  );
	System.out.println("2.    No");
	while (!scan.hasNextInt()) {
	      System.out.println("Input is not a valid number.");
	      scan.nextLine();
	    }
	empMenu = scan.nextInt();
	switch(empMenu) {
	case 1:
		Account.JointAccountCreated();
		System.out.println("You have Approve this account");
		AccountUsage.pending = null;
		break;
	case 2:System.out.println("You have declined this account");
         AccountUsage.pending = null;	
		break;
	}
	scan.close();
	}
	
        else{
		System.out.println("There is no Applications at this time");
		
		Employee.login();
	}
	
}
}
