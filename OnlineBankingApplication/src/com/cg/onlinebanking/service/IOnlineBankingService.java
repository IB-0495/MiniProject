package com.cg.onlinebanking.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transactions;
import com.cg.onlinebanking.dto.User;
import com.cg.onlinebanking.exception.OnlineBankingException;

public interface IOnlineBankingService {

	public List<Transactions> viewMiniStatement()throws OnlineBankingException;
	public String viewCurrentAddressMobile()throws OnlineBankingException;
	public String trackServiceRequest()throws OnlineBankingException;
	public int createNewAccount(Account a,Customer c)throws OnlineBankingException;
	public List<Transactions> viewAllTransctions()throws OnlineBankingException;
	public List<Transactions> viewDetailStatement(LocalDate from, LocalDate to)throws OnlineBankingException;
	public boolean changeAddressMobile(String address)throws OnlineBankingException;
	public boolean transferFundDiffAcc(int from, int to)throws OnlineBankingException;
	public boolean transferFundOwnAcc(int from, int to)throws OnlineBankingException;
	public boolean changePassword(String pass)throws OnlineBankingException;
	public int createNewAccountExistingCustomer(Account a, int customerId) throws OnlineBankingException;
	public int createNewAccountNewCustomer(Account a, Customer c, User u) throws OnlineBankingException;
	public String login(String userName,String password) throws OnlineBankingException;

}
