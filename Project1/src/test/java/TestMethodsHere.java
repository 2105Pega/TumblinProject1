import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.revature.tay.Customer;

public class TestMethodsHere {
	@Test
	public void createAccount(){
	    	Customer c = new Customer(); 
		   System.out.println(c.getFirstname() + "We have updated your Account");
		   int min = 10000;
		      int max = 1000000;
		        
		      //Generate random id 
		    //  System.out.println("Random value in int from "+min+" to "+max+ ":");
		      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		      System.out.println(random_int);
		   System.out.println("Your new accountId is:       " + random_int);
		   
		   int accountid = random_int;
		   System.out.println(accountid);
	}
	  //@Test	   
	/*public void Accountlogin() {
			   Scanner scan = new Scanner(System.in);
			   Customer c = new Customer();
			   System.out.println("Please enter your username:");
			   String input = scan.next();
			   if (c.getUsername().equals(input)) {
				   System.out.println("Please enter Password");
			   }else {
				   System.out.println("Invaild Username");
				   Accountlogin();
			   }
			   System.out.println("Please enter your password");
			   String input2 = scan.next();
			   if(c.getPassword().equals(input2)) {
				   System.out.println("This is working");
				   //Accountstatus();
			   }
			   scan.close();
		   
	    }*/ 
		@Test   
	  public void Accountwithdraw() {
				//Account ac = new Account();
				double ammount;
				double accountbalance = 6000;
				
			   Scanner scan = new Scanner(System.in);
				   System.out.println("Enter the ammout you wish to withdraw");
				   
				    while (!scan.hasNextDouble()) {
				      System.out.println("Input is not a number.");
				      scan.nextLine();
				    }
				    
				    ammount = scan.nextDouble();
				    
				    
				   if(ammount > accountbalance) {
					   System.out.println("Error Insufficient funds:");
					   Accountwithdraw();
				   }else if(ammount<=0) {
					   System.out.println("Error Amount to be withdrawn should be positive");
					   Accountwithdraw();
					   
				   }else {
					   accountbalance = accountbalance - ammount;
				   }
				   scan.close();
		   }

    
       @Test
		public void transfer() {
Scanner scan = new Scanner(System.in);
	int jointaccountid = 66757;
	double ammount = 500;
	double jointaccountbalance = 5000;
	double accountcbalance = 5000;
	
		if(jointaccountid != 0) {
			 
			  int Menu = 0;
			   System.out.println("Which account you want to transfer to:");
			   
			   System.out.println("1. Account to JointAccount");
			   System.out.println("2. JointAcccount to Account");
			   Menu = scan.nextInt();
			   switch(Menu) {
			     case 1:
		       System.out.println("Select Amount you wish to transfer");
		      ammount = scan.nextDouble();
		       if(ammount>accountcbalance)
		       {System.out.println(" Error Nummber succeceds Balance");
		      transfer();
		       }else {
		    	accountcbalance = accountcbalance-  ammount   ;
		    	jointaccountbalance = ammount + jointaccountbalance;
		    	System.out.println("Transaction Successful");
		    	//Status2();
		      }
			     case 2:
			    System.out.println("Select Amount you wish to transfer");
			    ammount = scan.nextDouble();
			    if(ammount>accountcbalance)
			       {System.out.println(" Error Nummber succeceds Balance");
			      transfer();
			       }else {
			    	jointaccountbalance = jointaccountbalance- ammount  ;
			    	accountcbalance = ammount + accountcbalance;
			    	System.out.println("Transaction Successful");
			    	//Status2();
			       }
			    
			   }
		}else{
			System.out.println("You don't have any other accounts at this time, please apply for Joint if you want to use the transfer feature;");
			//Status2();
		}scan.close();
		}
}
