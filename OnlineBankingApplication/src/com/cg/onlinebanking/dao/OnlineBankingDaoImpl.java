package com.cg.onlinebanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.cg.ems.utility.DatabaseConnection;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transactions;
import com.cg.onlinebanking.exception.OnlineBankingException;

public class OnlineBankingDaoImpl implements IOnlineBankingDao {

	Connection con;
	PreparedStatement ps;
	Logger logger=Logger.getRootLogger();

	@Override
	public List<Transactions> viewMiniStatement() throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		ResultSet rs=ps.executeQuery();
		List<Transactions> lst=new ArrayList<Transactions>();
		Transactions t=null;
		while(rs.next())
		{
			t=new Transactions();
			t.setAccNo(rs.getInt("account_no"));
			t.setDateofTransaction(rs.getDate("dateoftransaction").toLocalDate());
			t.setTransAmount(rs.getInt("tranamount"));
			t.setTransDecription(rs.getString("tran_description"));
			t.setTransId(rs.getInt("transaction_id"));
			t.setTransType(rs.getString("transactiontype"));
			lst.add(t);
		}
		return lst;
	}

	@Override
	public List<Transactions> viewDetailStatement(LocalDate from,LocalDate to) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		ResultSet rs=ps.executeQuery();
		List<Transactions> lst=new ArrayList<Transactions>();
		Transactions t=null;
		while(rs.next())
		{
			t=new Transactions();
			t.setAccNo(rs.getInt("account_no"));
			t.setDateofTransaction(rs.getDate("dateoftransaction").toLocalDate());
			t.setTransAmount(rs.getInt("tranamount"));
			t.setTransDecription(rs.getString("tran_description"));
			t.setTransId(rs.getInt("transaction_id"));
			t.setTransType(rs.getString("transactiontype"));
			lst.add(t);
		}
		return lst;
	}

	@Override
	public String viewCurrentAddressMobile() throws OnlineBankingException{
	
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		ResultSet rs=ps.executeQuery();
		String s=null;
		while(rs.next())
		{
			s=rs.getString("address");
		}
		return s;
	}

	@Override
	public boolean changeAddressMobile(String address) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		int r=ps.executeUpdate();
		if(r==1)
			return true;
		else
			return false;
	
	}

	@Override
	public String trackServiceRequest() throws OnlineBankingException{
	
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		ResultSet rs=ps.executeQuery();
		String s=null;
		while(rs.next())
		{
			s=rs.getString("service_status");
		}
		return s;
	}

	@Override
	public boolean transferFundDiffAcc(int from,int to) throws OnlineBankingException{
	
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		int r=ps.executeUpdate();
		if(r==1)
			return true;
		else
			return false;
		
	}

	@Override
	public boolean changePassword(String pass) throws OnlineBankingException {
	
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		int r=ps.executeUpdate();
		if(r==1)
			return true;
		else
			return false;
	}

	@Override
	public int createNewAccount(Account a,Customer c) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		
		return ps.executeUpdate();
		
	}

	@Override
	public List<Transactions> viewAllTransctions() throws OnlineBankingException {
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		ResultSet rs=ps.executeQuery();
		List<Transactions> lst=new ArrayList<Transactions>();
		Transactions t=null;
		while(rs.next())
		{
			t=new Transactions();
			t.setAccNo(rs.getInt("account_no"));
			t.setDateofTransaction(rs.getDate("dateoftransaction").toLocalDate());
			t.setTransAmount(rs.getInt("tranamount"));
			t.setTransDecription(rs.getString("tran_description"));
			t.setTransId(rs.getInt("transaction_id"));
			t.setTransType(rs.getString("transactiontype"));
			lst.add(t);
		}
		return lst;
		
	}

	@Override
	public boolean transferFundOwnAcc(int from,int to) throws OnlineBankingException{

		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(sql);
		
		//add preparestatement
		
		int r=ps.executeUpdate();
		if(r==1)
			return true;
		else
			return false;
		
		
	}


}
