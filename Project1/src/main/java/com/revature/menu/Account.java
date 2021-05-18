package com.revature.menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.driver.MainMenu;
import com.revature.tay.Customer;
import com.revature.tay.Employee;

public class Account {
	private static final Logger logger = LogManager.getLogger(Account.class);
	private String accountowner;
	private static double accountcbalance;
	private int accountid;
	private static double ammount;
	private static double jointaccountbalance;
	private static int jointaccountid;
	
	
	public int getJointaccountid() {
		return jointaccountid;
	}

	public static void setJointaccountid(int jointaccountid) {
		Account.jointaccountid = jointaccountid;
	}
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	
	public Account(String accountowner, int accountid, double accountcbalance) {
		super();
		this.accountowner = accountowner;
		Account.accountcbalance = accountcbalance;
		this.accountid = accountid;
	}
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public double getJointaccountbalance() {
		return jointaccountbalance;
	}

	public static void setJointaccountbalance(double jointaccountbalance) {
		Account.jointaccountbalance = jointaccountbalance;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		Account.ammount = ammount;
	}

	public String getAccountowner() {
		return accountowner;
	}
	public void setAccountowner(String accountowner) {
		this.accountowner = accountowner;
	}
	public double getAccountbalance() {
		return accountcbalance;
	}
	public void setAccountbalance(double accountbalance) {
		Account.accountcbalance = accountbalance;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public static void Accountwithdraw() {
		
		Customer c = new Customer();
		Scanner scan = new Scanner(System.in); 
		
		if(jointaccountid != 0) {
			 
			  int Menu = 0;
			   System.out.println("Which account you want to withdraw to:");
			   
			   System.out.println("1. Account Balance");
			   System.out.println("2. JointAcccount Balance");
			   Menu = scan.nextInt();
			    switch(Menu) {
			     case 1:
		
		
		  
		   System.out.println("Enter the ammout you want to withdraw");
		   
		    while (!scan.hasNextDouble()) {
		      System.out.println("Input is not a valid number.");
		      scan.nextLine();
		    }
		    
		    ammount = scan.nextDouble();
		    
		    
		   if(ammount > accountcbalance) {
			   System.out.println("Error Insufficient funds:");
			   Accountwithdraw();
		   }else if(ammount<=0) {
			   System.out.println("Error Amount to be withdrawn should be positive");
			   Accountwithdraw();
			   
		   }else {
			   accountcbalance = accountcbalance - ammount;
			   System.out.println(c.getUsername()+"  account balance is now        " + accountcbalance);
			   logger.info("Withdrew " + ammount + " from " + "accountbalance, "+ " accountbalance is now "+accountcbalance);
			   Status2();
		   }
			     case 2:
				   Menu = scan.nextInt();
				    switch(Menu) {
				     case 1:
			
			
			  
			   System.out.println("Enter the ammout you want to withdraw");
			   
			    while (!scan.hasNextDouble()) {
			      System.out.println("Input is not a valid number.");
			      scan.nextLine();
			    }
			    
			    ammount = scan.nextDouble();
			    
			    
			   if(ammount > jointaccountbalance) {
				   System.out.println("Error Insufficient funds:");
				   Accountwithdraw();
			   }else if(ammount<=0) {
				   System.out.println("Error Amount to be withdrawn should be positive");
				   Accountwithdraw();
				   
			   }else {
				   jointaccountbalance = jointaccountbalance - ammount;
				   System.out.println(c.getUsername()  +" Joint account balance is now        " + jointaccountbalance);
				   logger.info("Withdrew " + ammount + " from " + "jointaccount" + " the balance is now " +jointaccountbalance);
				   Status2();
			   }break;
				    }
			    }
		}else {  System.out.println("Enter the ammout you want to withdraw");
		   
	    while (!scan.hasNextDouble()) {
	      System.out.println("Input is not a valid number.");
	      scan.nextLine();
	    }
	    
	    ammount = scan.nextDouble();
	    
	    
	   if(ammount > accountcbalance) {
		   System.out.println("Error Insufficient funds:");
		   Accountwithdraw();
	   }else if(ammount<=0) {
		   System.out.println("Error Amount to be withdrawn should be positive");
		   Accountwithdraw();
		   
	   }else {
		   accountcbalance = accountcbalance - ammount;
		   System.out.println( c.getUsername()+ "  account balance is now        " + accountcbalance);
		   logger.info("Withdrew " + ammount + " from " + "accountbalance, "+ " accountbalance is now "+accountcbalance);
		   Status2(); }
		}scan.close();
	}
	public static void transfer() {
Scanner scan = new Scanner(System.in); 
	
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
		    	logger.info("Transfer " + ammount + " from " + "accountbalance, "+ "to " + " jointaccountbalance  "+  "accountbalance is now " + accountcbalance + "jointaccountbalance is now " + jointaccountbalance);
		    	Status2();
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
			    	logger.info("Transfer " + ammount + " from " + "jointaccountbalance, "+ "to " + " accountbalance  "+  "jointaccountbalance is now " + jointaccountbalance + "accountbalance is now " + accountcbalance);
			    	Status2();
			       }
			    
			   }
		}else{
			System.out.println("You don't have any other accounts at this time, please apply for Joint if you want to use the transfer feature;");
			Status2();
		}scan.close();
	}

	    
	    
		
	 	
	
	   public static void Accountdeposit() {
		   
		   Scanner scan = new Scanner(System.in);
		   if(jointaccountid != 0) {
			   
		   int Menu = 0;
		   System.out.println("Which account you want to deposit to:");
		   
		   System.out.println("1. Account Balance");
		   System.out.println("2. JointAcccount Balance");
	
	       Menu = scan.nextInt();
		    switch(Menu) {
		     case 1:
		    System.out.println("Enter the ammout you want to deposit");
				   
			 while (!scan.hasNextDouble()) {
					  System.out.println("Input is not a valid number.");
					   scan.nextLine();
					  }
					    
					 ammount = scan.nextDouble();
				   
				   
				     if (ammount <=0){
				          System.out.println("Error Amount to be withdrawn should be positive");
				           Accountdeposit();
				         }
				     else if (ammount > 10000) {
				            System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
				              Accountdeposit();
				         } else {
				         accountcbalance = ammount + accountcbalance;
				         System.out.println("Your balance is now     " + accountcbalance);
				         }
				     logger.info("Deposited " + ammount + " from " + "accountbalance, "+ " accountbalance is now "+accountcbalance);      
			  break;
		    case 2: 
		    	System.out.println("Enter the ammout you want to deposit");
				   
				 while (!scan.hasNextDouble()) {
						  System.out.println("Input is not a valid number.");
						   scan.nextLine();
						  }
						    
						 ammount = scan.nextDouble();
					   
					   
					     if (ammount <=0){
					          System.out.println("Error Amount to be withdrawn should be positive");
					           Accountdeposit();
					         }
					     else if (ammount > 10000) {
					            System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
					              Accountdeposit();
					         } else {
					         jointaccountbalance = ammount + jointaccountbalance;
					         System.out.println("Your balance is now     " + jointaccountbalance);
					         }
			  break;}
		    logger.info("Deposited " + ammount + " from " + "jointaccountbalance, "+ " jointaccountbalance is now "+ jointaccountbalance);
		    Status2();
		    } else { System.out.println("Enter the ammout you want to deposit");
		   
		   while (!scan.hasNextDouble()) {
			      System.out.println("Input is not a valid number.");
			      scan.nextLine();
			    }
			    
			    ammount = scan.nextDouble();
		   
		   
		        if (ammount <=0){
		             System.out.println("Error Amount to be withdrawn should be positive");
		             Accountdeposit();
		         }
		        else if (ammount > 10000) {
		                System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
		                Accountdeposit();
		            } else {
		                accountcbalance = ammount + accountcbalance;
		                System.out.println("Your balance is now     " + accountcbalance);
		                logger.info("Deposited " + ammount + " from " + "accountbalance, "+ " accountbalance is now "+accountcbalance);
		            }
		        Status2();
		          scan.close();
		        }
		    }

	   
	   public void createAccount(){
	    	Scanner scan = new Scanner(System.in);
		   Customer c = new Customer(); 
		   System.out.println(c.getFirstname() + " We have updated your Account:");
		   int min = 10000;
		      int max = 1000000;
		        
		      //Generate random id 
		      //System.out.println("Random value in int from "+min+" to "+max+ ":");
		      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		      //System.out.println(random_int);
		   System.out.println("Your new accountId is:     " + random_int);
		   
		      accountid = random_int + accountid ;
		    System.out.println(accountid);
		   
		   int Menu = 0;
		   System.out.println("Would you like to sign in?");
		   System.out.println("1. Yes");
		   System.out.println("2. No");
	
	 Menu = scan.nextInt();
		 switch(Menu) {
		   case 1:
			Accountlogin();
			  break;
		    case 2:
		    	MainMenu.mainMenu();
			  break;
		
		 
		   
	     }
		 scan.close();
	   }
	   public void Accountlogin() {
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
		   //System.out.println("Please enter your password");
		   String input2 = scan.next();
		   if(c.getPassword().equals(input2)) {
			   Accountstatus();
			   
		   }else {
			   System.out.println("Invaild password please login again");
			   Accountlogin();
		   }
		   scan.close();
	   }
       public static void Accountstatus(){
    	   Customer c = new Customer();
    	   Scanner scan = new Scanner(System.in);
    	  
    	   System.out.println("Hey " + c.getFirstname()+" Your account status here:");
    	   System.out.println( "Balance       " + accountcbalance);
    	   if (accountcbalance == 0) {
    		   System.out.println("You must do a initial deposit?");
    		   //String input1 = scan.next();
    		   Accountdeposit();
    	   } else if(jointaccountid !=0){                                                                            //When Application is Approve
    			   System.out.println("Hey " + c.getFirstname() + "Your Appilcation has been approved!");
    			 //  System.out.println("Your Joint Account ID is " + jointaccountid);
    			   System.out.println("Your JointAccount balance is:    "  + jointaccountbalance);
    			   Status2();
    		    }     
            //  else  if (scan.equals(y)) {
    			  // Accountdeposit();
              else if (accountcbalance != 0) {
    		    		  Status2();
    		    	   
            }  else {
    			   
    			    System.out.println("Invaild input must deposit to continue complete Account!");
    			   Accountstatus();
    		   }
    		     
    	   
    	   scan.close();
       }

       public static void Status2() {
    	   Scanner scan = new Scanner(System.in);
    	   if(jointaccountid !=0) {
    		   System.out.println("Your Joint Account Balance is        " + jointaccountbalance);
    	   }
    	   int Menu = 0;
		   System.out.println("Your  currentbalance is        " + accountcbalance);
    	   System.out.println("Please select an option");
		   System.out.println("1. Deposit");
		   System.out.println("2. Withdraw");
		   System.out.println("3. Transfer");
		   System.out.println("4. Apply for joint");
		   System.out.println("5. View Application");
		   System.out.println("6. Logout");
		   
	 Menu = scan.nextInt();
		 switch(Menu) {
		   case 1:
			Accountdeposit();
			  break;
		    case 2:
		    	Accountwithdraw();
			  break;
		    case 3: transfer();
		    	break;
		    case 4: ApplyforJoint();
		    	break;
		    case 5:
		    	
		    	AccountUsage.Application();
		    	break;
		    case 6:
		    	System.out.println("You have Logged out");
		    	MainMenu.mainMenu();
		    	break;
		    	
       }
       scan.close();
    	   }
       


	@Override
	public String toString() {
		if(jointaccountid == 0) {
		return "Account [accountcbalance=" + accountcbalance + ", accountid=" + accountid
				+ ", accounts=" + accounts + "]";}
		else{return  "Account [accountcbalance=" + accountcbalance + ", accountid=" + accountid + ", jointaccountid = " + jointaccountid
				+ "Jointaccountbalance" + jointaccountbalance + ", accounts=" + accounts + "]";}
		
	}
       public static void ApplyforJoint() {
    	   Scanner scan = new Scanner(System.in);
    	   int Menu = 0;
		   System.out.println("Would you like to apply for a joint Account");
    	  System.out.println("1. Yes");
    	   System.out.println("2. No");
    	   Menu = scan.nextInt();
  		   switch(Menu) {
  		   case 1:
  			AccountUsage.Application();
  			break;
  		    case 2:
  		    	Status2();
  			  break;
    	   
  			 
      }
  		 scan.close(); 
       }
       public static void JointAccountCreated(){
    	   Customer c = new Customer();
    	   int min = 10000;
   		      int max = 1000000;
   		        
   		      //Generate random id 
   		      //System.out.println("Random value in int from "+min+" to "+max+ ":");
   		      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
   		      //System.out.println(random_int);
   		   System.out.println( c.getFirstname() +  " JointAccountId is:     " + random_int);
   		   
   		   jointaccountid = random_int + jointaccountid;
   		   Employee.viewAccounts();
       }
}
