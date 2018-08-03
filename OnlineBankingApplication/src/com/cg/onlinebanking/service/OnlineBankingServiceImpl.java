package com.cg.onlinebanking.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transactions;
import com.cg.onlinebanking.exception.OnlineBankingException;

public class OnlineBankingServiceImpl implements IOnlineBankingService {

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
		// TODO Auto-generated method stub
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

	

}
