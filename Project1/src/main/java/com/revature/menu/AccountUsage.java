package com.revature.menu;

public class AccountUsage {
	public static String approve;
	public static String denied ;
	public static String pending  ;
	public static String cancel ;



	public static  void Application() {
		
		Account ac = new Account();
		if(ac.getJointaccountid() == 0) {
	        
	        System.out.println("Application has been sent to Bank Admin");
	        pending = "pending" ;
	        
	        Account.Status2();
	        
	    }
	    else {
	        System.out.println("You Already Applied");
	        Account.Status2();
	    }
	}
}
