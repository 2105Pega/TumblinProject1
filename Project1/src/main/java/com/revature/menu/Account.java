package com.revature.menu;



import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import org.apache.logging.log4j.Basicconfigure;
import com.revature.driver.MainMenu;
import com.revature.services.AccountServices;
import com.revature.services.CustomerServices;
import com.revature.tay.Customer;
import com.revature.tay.Employee;

//import org.apache.logging.log4j.*;
public class Account {
	private static final Logger logger = LogManager.getLogger(Account.class);
	private String accountowner;
	private static double accountcbalance;
	private static int accountid;
	private static double ammount;
	private static double savingsbalance;
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
		Account.accountid = accountid;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public static double getSavingsbalance() {
		return savingsbalance;
	}

	public static void setSavingsbalance(double savingsbalance) {
		Account.savingsbalance = savingsbalance;
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
		Account.accountid = accountid;
	}

	public static void Accountstatus() {
		Customer c = new Customer();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hey " + c.getFirstname() + " Your account status here:");
		System.out.println("Balance       " + accountcbalance);
		if (accountcbalance == 0) {
			System.out.println("You must do a initial deposit?");
			// String input1 = scan.next();
			InitialDeposit();
		} else if (jointaccountid != 0) { // When Application is Approve
			System.out.println("Hey " + c.getFirstname() + "Your Appilcation has been approved!");
			// System.out.println("Your Joint Account ID is " + jointaccountid);
			// System.out.println("Your Savings balance is: " + savingsbalance);
			Status2();
		}
		// else if (scan.equals(y)) {
		// Accountdeposit();
		else if (accountcbalance != 0) {
			Status2();

		} else {

			System.out.println("Invaild input must deposit to continue complete Account!");
			Accountstatus();
		}

		scan.close();
	}

	public static void InitialDeposit() {
		org.apache.logging.log4j.Logger logger = LogManager.getLogger(Account.class);
		//Logger logger = LogManager.getLogger(Account.class);
		CustomerServices cser = new CustomerServices();
		AccountServices aser = new AccountServices();
		Account a = new Account();
		Customer c = new Customer();
		aser.updateCheckings(a, c);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the ammout you want to deposit");

		while (!scan.hasNextDouble()) {
			System.out.println("Input is not a valid number.");
			scan.nextLine();
		}

		ammount = scan.nextDouble();

		if (ammount <= 0) {
			System.out.println("Error Amount to be deposited should be positive");
			Accountdeposit();
		} else if (ammount > 10000) {
			System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
			Accountdeposit();
		} else {
			accountcbalance = ammount + accountcbalance;
			System.out.println("Your balance is now     " + accountcbalance);
			logger.info("Deposited " + ammount + " from " + "accountbalance, " + " accountbalance is now "
					+ accountcbalance);
			cser.updateAccount(a, c);
			Status2();
		}

		scan.close();
	}

	public static void Accountwithdraw() {
		Logger logger = LogManager.getLogger(Account.class);
		Customer c = new Customer();
		Account a = new Account();
		AccountServices aser = new AccountServices();

		// Customer c = new Customer();
		Scanner scan = new Scanner(System.in);

		if (jointaccountid != 0) {

			int Menu = 0;
			System.out.println("Which account you want to withdraw to:");

			System.out.println("1. Account Balance");
			System.out.println("2. Savings");
			Menu = scan.nextInt();
			switch (Menu) {
			case 1:

				aser.updateCheckings(a, c);

				System.out.println("Enter the ammout you want to withdraw");

				while (!scan.hasNextDouble()) {
					System.out.println("Input is not a valid number.");
					scan.nextLine();
				}

				ammount = scan.nextDouble();

				if (ammount > accountcbalance) {
					System.out.println("Error Insufficient funds:");
					Accountwithdraw();
				} else if (ammount <= 0) {
					System.out.println("Error Amount to be withdrawn should be positive");
					Accountwithdraw();

				} else {
					accountcbalance = accountcbalance - ammount;
					System.out.println(c.getUsername() + "  account balance is now        " + accountcbalance);
					logger.info("Withdrew " + ammount + " from " + "accountbalance, " + " accountbalance is now "
							+ accountcbalance);
					aser.withdraw_Checkings(a, c);
					Status2();
				}

			case 2:

				aser.updateSavingsTrans(a, c);
				System.out.println("Enter the ammout you want to withdraw");

				while (!scan.hasNextDouble()) {
					System.out.println("Input is not a valid number.");
					scan.nextLine();
				}

				ammount = scan.nextDouble();

				if (ammount > savingsbalance) {
					System.out.println("Error Insufficient funds:");
					Accountwithdraw();
				} else if (ammount <= 0) {
					System.out.println("Error Amount to be withdrawn should be positive");
					Accountwithdraw();

				} else {
					savingsbalance = savingsbalance - ammount;
					System.out.println(c.getUsername() + " Savings account balance is now        " + savingsbalance);
					logger.info("Withdrew " + ammount + " from " + "Savingsaccount" + " the balance is now "
							+ savingsbalance);
					aser.withdrawSavings(a, c);
					Status2();
				}
				break;
			}

		} else {
			System.out.println("Enter the ammout you want to withdraw");
			aser.updateCheckings(a, c);
			while (!scan.hasNextDouble()) {
				System.out.println("Input is not a valid number.");
				scan.nextLine();
			}

			ammount = scan.nextDouble();

			if (ammount > accountcbalance) {
				System.out.println("Error Insufficient funds:");
				Accountwithdraw();
			} else if (ammount <= 0) {
				System.out.println("Error Amount to be withdrawn should be positive");
				Accountwithdraw();

			} else {
				accountcbalance = accountcbalance - ammount;
				System.out.println(c.getUsername() + "  account balance is now        " + accountcbalance);
				logger.info("Withdrew " + ammount + " from " + "accountbalance, " + " accountbalance is now "
						+ accountcbalance);
				aser.withdraw_Checkings(a, c);
				Status2();
			}
			scan.close();
		}
	}

	public static void transfer() {
		Scanner scan = new Scanner(System.in);
		
		Customer c = new Customer();
		Account a = new Account();
		AccountServices aser = new AccountServices();
		if (jointaccountid != 0) {

			int Menu = 0;
			System.out.println("Which account you want to transfer to:");

			System.out.println("1. Account to Savings Account");
			System.out.println("2. Savings Acccount to Account");
			Menu = scan.nextInt();
			switch (Menu) {
			case 1:
				System.out.println("Select Amount you wish to transfer");
				ammount = scan.nextDouble();
				if (ammount > accountcbalance) {
					System.out.println(" Error Nummber succeceds Balance");
					transfer();
				} else {
					accountcbalance = accountcbalance - ammount;
					savingsbalance = ammount + savingsbalance;
					System.out.println("Transaction Successful");
					logger.info("Transfer " + ammount + " from " + "accountbalance, " + "to " + " Savingsaccountbalance  "
							+ "accountbalance is now " + accountcbalance + "Savingsaccountbalance is now "
							+ savingsbalance);
					aser.transfer(a, c);
					Status2();
				}
			case 2:
				System.out.println("Select Amount you wish to transfer");
				ammount = scan.nextDouble();
				if (ammount > accountcbalance) {
					System.out.println(" Error Nummber succeceds Balance");
					transfer();
				} else {
					savingsbalance = savingsbalance - ammount;
					accountcbalance = ammount + accountcbalance;
					System.out.println("Transaction Successful");
					aser.transfer(a, c);
					logger.info("Transfer " + ammount + " from " + "Savingsaccountbalance, " + "to " + " accountbalance  "
							+ "Savingsaccountbalance is now " + savingsbalance + "accountbalance is now "
							+ accountcbalance);
					Status2();
				}

			}
		} else {
			System.out.println(
					"You don't have any other accounts at this time, please apply for Savings if you want to use the transfer feature;");
			Status2();
		}
		scan.close();
	}

	public static void Accountdeposit() {
		Customer c = new Customer();
		Account a = new Account();
		AccountServices aser = new AccountServices();
		Logger logger = LogManager.getLogger(Account.class);
		Scanner scan = new Scanner(System.in);
		if (jointaccountid != 0) {

			int Menu = 0;
			System.out.println("Which account you want to deposit to:");

			System.out.println("1. Account Balance");
			System.out.println("2. Savings");

			Menu = scan.nextInt();
			switch (Menu) {
			case 1:
				System.out.println("Enter the ammout you want to deposit");
				aser.updateCheckings(a, c);
				while (!scan.hasNextDouble()) {
					System.out.println("Input is not a valid number.");
					scan.nextLine();
				}

				ammount = scan.nextDouble();

				if (ammount <= 0) {
					System.out.println("Error Amount to deposited should be positive");
					Accountdeposit();
				} else if (ammount > 9999.99) {
					System.out.println(
							"You must deposit up to $9999.99, any this over see Bank Manager for full deposit");
					Accountdeposit();
				} else {
					accountcbalance = ammount + accountcbalance;
					System.out.println("Your balance is now     " + accountcbalance);
					aser.depositCheckings(a, c);
				}
				logger.info("Deposited " + ammount + " from " + "accountbalance, " + " accountbalance is now "
						+ accountcbalance);
				break;
			case 2:
				System.out.println("Enter the ammout you want to deposit");
				aser.updateSavingsTrans(a, c);
				while (!scan.hasNextDouble()) {
					System.out.println("Input is not a valid number.");
					scan.nextLine();
				}

				ammount = scan.nextDouble();

				if (ammount <= 0) {
					System.out.println("Error Amount to be deposited should be positive");
					Accountdeposit();
				} else if (ammount > 10000) {
					System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
					Accountdeposit();
				} else {
					savingsbalance = ammount + savingsbalance;
					System.out.println("Your Savings balance is now     " + savingsbalance);
					logger.info("Deposited " + ammount + " from " + "Savingsaccountbalance, " + " Savingsaccountbalance is now "
							+ savingsbalance);
					aser.depositsSavings(a, c);
				}
				break;
			}
			
			Status2();
		} else {
			System.out.println("Enter the ammout you want to deposit");
			aser.updateCheckings(a, c);
			while (!scan.hasNextDouble()) {
				System.out.println("Input is not a valid number.");
				scan.nextLine();
			}

			ammount = scan.nextDouble();

			if (ammount <= 0) {
				System.out.println("Error Amount to be deposited should be positive");
				Accountdeposit();
			} else if (ammount > 10000) {
				System.out.println("You must deposit up to $9999.99, see Bank Manager for full deposit");
				Accountdeposit();
			} else {
				accountcbalance = ammount + accountcbalance;
				System.out.println("Your balance is now     " + accountcbalance);
				logger.info("Deposited " + ammount + " from " + "accountbalance, " + " accountbalance is now "
						+ accountcbalance);
				aser.depositCheckings(a, c);

			}
			Status2();
			scan.close();
		}
	}

	public void createAccount() {
		Account a = new Account();
		CustomerServices cser = new CustomerServices();
		Scanner scan = new Scanner(System.in);
		Customer c = new Customer();
		System.out.println(c.getFirstname() + " We have updated your Account:");
		int min = 10000;
		int max = 1000000;
		cser.createAccount(c, a);
		// Generate random id
		// System.out.println("Random value in int from "+min+" to "+max+ ":");
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		// System.out.println(random_int);
		System.out.println("Your new accountId is:     " + random_int);

		accountid = random_int + accountid;
		System.out.println(accountid);

		int Menu = 0;
		System.out.println("Would you like to sign in?");
		System.out.println("1. Yes");
		System.out.println("2. No");

		Menu = scan.nextInt();
		switch (Menu) {
		case 1:
			Customer.Accountlogin();
			break;
		case 2:
			MainMenu.mainMenu();
			break;

		}
		scan.close();
	}

	public static void Status2() {
		Scanner scan = new Scanner(System.in);
		if (jointaccountid != 0) {
			System.out.println("Your Savings  Account Balance is        " + savingsbalance);
		}
		int Menu = 0;
		System.out.println("Your  currentbalance is        " + accountcbalance);
		System.out.println("Please select an option");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Transfer");
		System.out.println("4. Apply for Savings");
		System.out.println("5. View Application");
		System.out.println("6. Logout");
        System.out.println("7. Delete an Account");
		Menu = scan.nextInt();
		switch (Menu) {
		case 1:
			Accountdeposit();
			break;
		case 2:
			Accountwithdraw();
			break;
		case 3:
			transfer();
			break;
		case 4:
			ApplyforJoint();
			break;
		case 5:

			AccountUsage.Application();
			break;
		case 6:
			System.out.println("You have Logged out");
			MainMenu.mainMenu();
			break;
		case 7:
			RemoveAccount();
			break;
		case 8:
			
			break;
			

		}
		scan.close();
	}

	
	
	@Override
	public String toString() {
		if (jointaccountid == 0) {
			return "Account [accountcbalance= " + accountcbalance + ", accountid= " + " 23412 " + "]";
		} else {
			return "Account [accountcbalance= " + accountcbalance + ", accountid= " + accountid + ", Savingsaccountid = "
					+ jointaccountid + " Savingsaccountbalance " + savingsbalance + "]";
		}

	}

	public static void ApplyforJoint() {
		Scanner scan = new Scanner(System.in);
		int Menu = 0;
		System.out.println("Would you like to apply for a Savings Account");
		System.out.println("1. Yes");
		System.out.println("2. No");
		Menu = scan.nextInt();
		switch (Menu) {
		case 1:
			AccountUsage.Application();
			break;
		case 2:
			Status2();
			break;

		}
		scan.close();
	}

	public static void JointAccountCreated() {
		CustomerServices cser = new CustomerServices();
		Account a = new Account();
		Customer c = new Customer();
		int min = 10000;
		int max = 1000000;

		// Generate random id
		// System.out.println("Random value in int from "+min+" to "+max+ ":");
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		// System.out.println(random_int);
		System.out.println(c.getFirstname() + " SavingsId is:     " + random_int);

		jointaccountid = random_int + jointaccountid;
		cser.UpdateSaving(a, c);
		Employee.viewAccounts();
	}
	
	
	public static void RemoveAccount() {
		Scanner scan = new Scanner(System.in);
		//Account a = new Account();
		if(Account.savingsbalance <= 0) {
			System.out.println("Savings account balance is at " + Account.getSavingsbalance() + "  Are you sure you want to delete it");
			int Menu1 = 0;
			System.out.println("1.  Yes");
			System.out.println("2.  No");
			Menu1 = scan.nextInt();
			switch (Menu1) {
			case 1:
		     //Double savingsbalance = null;
			Status2();
			break;
			case 2:
				Status2();
				break;
			}
		}else {
			System.out.println("Accounts full, you must have no balance to remove");
			Status2();
		}
		scan.close();
	}
	
}

