package com.cg.onlinebanking.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlinebanking.dao.IOnlineBankingDao;
import com.cg.onlinebanking.dao.OnlineBankingDaoImpl;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transactions;
import com.cg.onlinebanking.dto.User;
import com.cg.onlinebanking.exception.OnlineBankingException;

public class OnlineBankingServiceImpl implements IOnlineBankingService {

	IOnlineBankingDao obs=new OnlineBankingDaoImpl();
	
	@Override
	public List<Transactions> viewMiniStatement()throws OnlineBankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String viewCurrentAddressMobile()throws OnlineBankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String trackServiceRequest()throws OnlineBankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createNewAccount(Account a, Customer c)throws OnlineBankingException {
		
		return 0;
	}

	@Override
	public List<Transactions> viewAllTransctions()throws OnlineBankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transactions> viewDetailStatement(LocalDate from, LocalDate to)throws OnlineBankingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeAddressMobile(String address)throws OnlineBankingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferFundDiffAcc(int from, int to)throws OnlineBankingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferFundOwnAcc(int from, int to)throws OnlineBankingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(String pass)throws OnlineBankingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int createNewAccountExistingCustomer(Account a, int customerId) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return obs.createNewAccountExistingCustomer(a, customerId);
	}

	@Override
	public int createNewAccountNewCustomer(Account a, Customer c, User u) throws OnlineBankingException {
		// TODO Auto-generated method stub
		return obs.createNewAccountNewCustomer(a, c, u);
	}
	
	
	/*Account DTO validations*/
	private void isValidAccountDetail(Account details) throws OnlineBankingException {
		List<String> validationErrors = new ArrayList<>();
		
		
		String regexuserid =  "^[A-Z][a-z][0-9]{8}$";
		
		if ( !isValidDetail( details.getAccountbalance() ) )
			validationErrors.add("Account Balance should be within the bank limit.");
		
		if ( !isValidDetail( details.getUserid(), regexuserid) )
			validationErrors.add("Invalid User Id ");
		
		if ( !validationErrors.isEmpty() ) {
			//logger.error("Validation Errors: "+validationErrors);
			throw new OnlineBankingException(""+validationErrors);
		}
	}

	 private boolean isValidDetail(String regex, String data) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(data);
		return matcher.matches();
	}

	private boolean isValidDetail(String accountbalance) {
		IOnlineBankingDao IOnlineBankingDao = new OnlineBankingDaoImpl();
		
		if ( !isValidDetail( accountbalance, "^1[0-9]{3}$" ) ) {
			IOnlineBankingDao = null;
		}
		return false;	
	}
	
	private boolean isValidDetail1(String accounttype) {
		if (accounttype.equalsIgnoreCase("Savings") || accounttype.equalsIgnoreCase("Current") )
        {
             return true;
        }
		else 
	    return false;
		}
	
	/*Customer dto validations done here*/
	private void isValidCustomerDetail(Customer details) throws OnlineBankingException {
		List<String> validationErrors = new ArrayList<>();
		
		String regexcustomerName =  "^[A-Z][a-z]{20}$";
		String regexemail = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
		String regexaddress =  "^[#.0-9{4}[a-zA-Z]\\s,-]+$";
		String regexpanCard =  "^[A-Za-z]{5}\\d{4}[A-Za-z]{1}$";
		
		if ( !isValidDetail( details.getCustomerName(), regexcustomerName) )
			validationErrors.add("Customer Name is incorrect.");
		
		if ( !isValidDetail( details.getEmail(), regexemail) )
			validationErrors.add("email is incorrect.");
		
		if ( !isValidDetail( details.getAddress(), regexaddress) )
			validationErrors.add("Customer Address is incorrect.");
		
		if ( !isValidDetail( details.getPanCard(), regexpanCard) )
			validationErrors.add("PanCard you entered is incorrect.");
		
		if ( !validationErrors.isEmpty() ) {
			//logger.error("Validation Errors: "+validationErrors);
			throw new OnlineBankingException(""+validationErrors);
		}
	}

	/*User Dto validations are done here*/
	private void isValidUserDetail(User details) throws OnlineBankingException {
		List<String> validationErrors = new ArrayList<>();
		
		String regexuserid =  "^[A-Z][a-z][0-9]{8}$";
		String regexpassword = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
		String regextransactionPassword =  "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
				
		if ( !isValidDetail( details.getUserId(), regexuserid) )
			validationErrors.add("Customer UserId is incorrect.");
		
		if ( !isValidDetail( details.getPassword(), regexpassword) )
			validationErrors.add("password is incorrect.");
		
		if ( !isValidDetail( details.getTransactionPassword(), regextransactionPassword) )
			validationErrors.add("Customer Transaction password is incorrect.");
		
		
		if ( !validationErrors.isEmpty() ) {
			//logger.error("Validation Errors: "+validationErrors);
			throw new OnlineBankingException(""+validationErrors);
		}
	}
	
	private boolean isValidpassword(String password,String transactionPassword) {
		if (!password.equals(transactionPassword))
        {
             return true;
        }
		else 
	    return false;
		}
	

}
