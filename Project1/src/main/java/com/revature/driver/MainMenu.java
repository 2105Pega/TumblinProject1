package com.revature.driver;
import java.util.Scanner;

//import com.revature.menu.Account;
import com.revature.tay.Customer;

import com.revature.tay.Employee;


public class MainMenu {
	
	
	
	
	public static void mainMenu() {
		// System.out.println(" Welcome to the Bank. ");
        Scanner scan = new Scanner(System.in);
        //System.out.println("Please press 1 continue");
		Employee admin = new Employee();
		
		
			int menuSelection =0;
			System.out.println("Please select an option:");
			System.out.println("1. Admin Login");
			System.out.println("2. Customer Login");
			System.out.println("3. Create an Account");
			System.out.println("4. Quit");
			while (!scan.hasNextInt()) {
			      System.out.println("Input is not a valid number.");
			      scan.nextLine();
			    }
			
			  	
	      
	        	
	      menuSelection = scan.nextInt();
	      switch(menuSelection) {
	      case 1:
	    	 System.out.println("                             Login menu");
	    	 System.out.println("Admin username:   Tay");
	    	 System.out.println("Admin passsword   Taybian1");
	    	 System.out.println("Please enter your username;");
	    	 
	    	 
	    	 String response = scan.next();
	    	
	    	  
	    	 if(Employee.getUsername().equals(response)) {
	    		 System.out.println(" Please enter Password:");
	    		 String response2 = scan.next();
	    		 	if(admin.getPassword().equals(response2)) {
	    		 		Employee.login();
	    		 	}
	    		 	else {
	    		 		System.out.println("Invaild Username or Password, please try again");
	    		 		mainMenu();
	    		 	}
	    	
	    	 }else {
	    		 System.out.println("Invaild Username or Password, please try again");
	    		 mainMenu();
	    		 
	    	 }
	    		 
	    	 
	    		
	    	 
         
	  	
	  	
	  	break;
	  		
         case 2:
       	 //  Customer ac = new Customer();
       	  Customer.Accountlogin();
       	 
             break;
         case 3:
			try {
				Customer.createAccount1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             break;
         case 4:
             
             break;
         default:
             System.out.println("Invalid choice");
         }
         System.out.println();
	           scan.close();}
}
