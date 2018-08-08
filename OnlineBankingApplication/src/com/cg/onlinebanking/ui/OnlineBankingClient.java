package com.cg.onlinebanking.ui;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cg.onlinebanking.bean.Account;
import com.cg.onlinebanking.bean.Customer;
import com.cg.onlinebanking.bean.User;



public class OnlineBankingClient {
	static Scanner sc = new Scanner(System.in);
	static Account account =new Account();
	static User user=new User();
	static Customer customer = new Customer();
	public static void main(String[] args) {
		String username;
		String pswd;
		
		System.out.println("Username : ");
		username = sc.next();
		System.out.println("Password : ");
		pswd = sc.next();
        clearConsole();
        System.out.println("Welcome "+username);
        
        //call the login function 
        boolean login=true;
        int choice=0;
        if(login==true)
        {
        	boolean user=true;//check if user is log in or admin is log into
        	if(user==true)
        	{
        	    //user module	
        		do
        		{
        			System.out.println("Welcome to Bank");
        			System.out.println("-----------------");
        			System.out.println("1. View Mini/Detailed statement");
        			System.out.println("2. Change address");
        			System.out.println("3. Request for cheque book");
        			System.out.println("4. Track service request");
        			System.out.println("5. Fund Transfer");
        			System.out.println("6. Change password");	
        			System.out.println("7. Exit");
        			System.out.println("---------------------------");
        			System.out.println("Enter your choice...");
        			choice= sc.nextInt();
        			switch(choice)
        			{
        			case 1:
        				//MiniStatement
        				clearConsole();
        				System.out.println("1. Mini Statement");
        				System.out.println("2. Detailed Statement");
        				System.out.println("----------------------");
        				System.out.println("Enter your choice...");
        				int option=sc.nextInt();
        				viewStatementSwitch(option);
        				break;
        			case 2:
        				clearConsole();
        				//change address
        				System.out.println("Your Current Address : Sample address");
        				//here call the function from serviceimpl for showing user address
        				System.out.println("Enter new address");
        				String address=sc.next();//call changeAddressmobile(address)
        				/*
        				 if(function return true)
        				 {
        				   print(address changed)
        				 }
        				 else
        				 {
        				    print not changed
        				 }
        				 */
        				break;
        			case 3:
        				//request for cheque book
        				System.out.println("Are you sure you want to request for Cheque Book (Y/N)");
        				char request=sc.next().charAt(0);
        				if(request=='Y' || request=='y' )
        				{
        					System.out.println("Request generated ...");
        				}
        				else
        				{
        					System.out.println("Request declined");
        				}
        				break;
        			case 4:
        				//track service
        				break;
        			case 5:
        				//fund transfer
        			case 6:
        				//change password
        				clearConsole();
        				System.out.println("Enter New Password");
        				String password=sc.next();
        				System.out.println("Enter Confirm Password");
        				String cnf=sc.next();
        				if(password.equals(cnf))
        				{
        					//call changePassword(password);
        					if(true)
        					{
        					System.out.println("password changed");}
        				}
        				else
        				{
        					System.out.println("Password does not match");
        				}
        				break;
        			case 7:
        				clearConsole();
        				System.out.println("Thank You!");
        				System.exit(0);
        			default:
        				System.out.println("Oops..Wrong Choice!!");
        			}
        	
        		}while(true);
        	}
        	else
        	{
        		//admin module
        		do {
        			System.out.println("Welcome Admin");
        			System.out.println("-----------------");
        			System.out.println("1. Create Account");
        			System.out.println("2. View Transactions");	
        			System.out.println("3. Exit");
        			System.out.println("---------------------------");
        			System.out.println("Enter your choice...");
        			choice= sc.nextInt();
        			switch (choice) {
					case 1:
						//Create Account
						clearConsole();
						System.out.println("1. New User");
						System.out.println("2. Existing User");
						System.out.println("-------------------");
						System.out.println("Enter your choice");
						int option=sc.nextInt();
						//call createNewAccount(Account a,Customer c)
						break;
					case 2:
						clearConsole();
						//call viewAllTransctions()
						break;
					case 3:
						clearConsole();
        				System.out.println("Thank You!");
        				System.exit(0);
					default:
						System.out.println("Oops..Wrong Choice!!");
						break;
					}
        		}while(true);
        	}
        }
        else
        {
        	System.out.println("ioInvalid credential...");
        }
	}
	
	public final static void clearConsole()
	{
		System.out.println("**************************************");
		System.out.println("**************************************");
	}

	
/*
 * this function is for switch of mini and detailed statement
 * */
	public static void viewStatementSwitch(int choice)
	{
		clearConsole();
		switch(choice)
		{
		case 1:
			//call viewMiniStatement() function from service layer
			System.out.println("Mini Statement");
			break;
		case 2:
			System.out.println("Enter Start date");
			String date = sc.next();
		    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		    LocalDate startdate= LocalDate.parse(date, dateFormat);
		    System.out.println("Enter End date");
			String date1 = sc.next();
		    LocalDate enddate= LocalDate.parse(date1, dateFormat);
		    //call viewDetailStatement(startdate,enddate)
		    break;
		    default:
		    	System.out.println("Oops..Wrong Choice!!");
		}
	}
	
	/*Function for nested switch case for create account*/
	public static void viewSwitchForAccount(int option)
	{
		switch (option) {
		case 1:
			//new user
			getCustomerData(customer);
			getUserData(user);
			getAccountDetails(account);
			break;
		case 2:
			//check if it is valid/present
			System.out.println("Enter Customer ID");
			int cid=sc.nextInt();
			/*call the function for validation of customer id it
			will return true or false*/
			boolean valid=true;//true ki jagah function call karna hai
			if(valid==true)
			{
				getAccountDetails(account);
			}
			else
			{
				System.out.println("Customer Id "+cid+" do not exist");
			}
		default:
			break;
		}
	}
	
	/*Function for getting customer details*/
	public static Customer getCustomerData(Customer customer)
	{
		
		System.out.println("Enter Customer Name");
		customer.setCustomerName(sc.next());
		System.out.println("Enter Email");
		customer.setEmail(sc.next());
		System.out.println("Enter Address");
		customer.setAddress(sc.next());
		System.out.println("Enter Pancard");
		customer.setPanCard(sc.next());
		return customer;
		
	}
	
	/*Function for getting user details*/
	public static User getUserData(User user)
	{
		System.out.println("Enter User ID");
		user.setUserId(sc.next());
		System.out.println("Enter Password");
		user.setPassword(sc.next());
		System.out.println("Enter Secret Question");
		user.setSecretQuestion(sc.next());
		System.out.println("Enter Transaction password");
		user.setTransactionPassword(sc.next());
		return user;
		
	}
	
	/*function for getting account details*/
	public static Account getAccountDetails(Account account)
	{
		System.out.println("Enter Account Type");
		account.setAccounttype(sc.next());
		System.out.println("Enter Opening Balance");
		account.setAccountbalance(sc.nextDouble());
		return account;
		
	}
 
}
