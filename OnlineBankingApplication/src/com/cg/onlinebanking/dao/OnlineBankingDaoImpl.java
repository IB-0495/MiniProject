package com.cg.onlinebanking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.cg.ems.utility.DatabaseConnection;
import com.cg.onlinebanking.dto.Account;
import com.cg.onlinebanking.dto.Customer;
import com.cg.onlinebanking.dto.Transactions;
import com.cg.onlinebanking.dto.User;
import com.cg.onlinebanking.exception.OnlineBankingException;

public class OnlineBankingDaoImpl implements IOnlineBankingDao {

	Connection con;
	PreparedStatement ps;
	Logger logger=Logger.getRootLogger();

	@Override
	public List<Transactions> viewMiniStatement() throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		List<Transactions> lst=new ArrayList<Transactions>();
		try {
			ps=con.prepareStatement(QueryMapper.mini_statement);

			ResultSet rs=ps.executeQuery();
			
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
			
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical error refer log");
		}
		return lst;
	}

	@Override
	public List<Transactions> viewDetailStatement(LocalDate from,LocalDate to) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		try {
			ps=con.prepareStatement(QueryMapper.detailed_statement);
			ps.setDate(1, Date.valueOf(from));
			ps.setDate(2, Date.valueOf(to));
			
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
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical error refer log");
		}
	}

	@Override
	public String viewCurrentAddressMobile() throws OnlineBankingException{
	
		con= DatabaseConnection.getConnection();
		//ps=con.prepareStatement(QueryMapper.);
		
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
	public boolean changeAddressMobile(Customer c) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		boolean flag = false;
		try {
			ps=con.prepareStatement(QueryMapper.changeaddandphno);
			ps.setString(1, c.getAddress());
			ps.setInt(2, c.getAccNo());	
			
			int r=ps.executeUpdate();
			if(r==1)
				flag=true;
			else
				flag=false;
			
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical error refer log");
		}
		return flag;
	
	}

	@Override
	public String trackServiceRequest() throws OnlineBankingException{
	
		con= DatabaseConnection.getConnection();
		String s;
		try {
			ps=con.prepareStatement(QueryMapper.track_ser_req);
			
			ResultSet rs=ps.executeQuery();
			s = null;
			while(rs.next())
			{
				s=rs.getString("service_status");
			}
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical error refer log");
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
		try {
			ps=con.prepareStatement(QueryMapper.pass_change);
			ps.setString(1, pass);
			
			int r=ps.executeUpdate();
			if(r==1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical error refer log");
		}
	}

	@Override
	public int createNewAccountExistingCustomer(Account a,int customerId) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		int id = 0;
		try {
				PreparedStatement ps=con.prepareStatement(QueryMapper.new_acc_accdet);
				ps.setString(1,a.getAccounttype());
				ps.setInt(2,a.getAccountbalance());
				
				ps.setInt(3,customerId);
				
				int rs=ps.executeUpdate();
				if(rs==0)
				{
					logger.info("Account creation failed");
					throw new OnlineBankingException("Account creation failed");
				}
				else
				{
					Statement s=con.createStatement();
					ResultSet r=s.executeQuery("select accountid_seq.currval from dual");
					if(r.next())
					{
						id=r.getInt(1);
					}
				}
				
				
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical Error refer log");
		}
				
		return id;
		
	}
	
	@Override
	public int createNewAccountNewCustomer(Account a,Customer c,User u) throws OnlineBankingException{
		
		con= DatabaseConnection.getConnection();
		int id;
		try {
				PreparedStatement ps2=con.prepareStatement(QueryMapper.new_acc_user);
				ps2.setString(1,u.getUserId());
				ps2.setString(2,u.getPassword());
				ps2.setString(3, u.getSecretQuestion());
				ps2.setString(5,u.getLockStatus());
				ps2.setString(4,u.getTransactionPassword());
				int rs2=ps2.executeUpdate();	
				PreparedStatement ps=con.prepareStatement(QueryMapper.new_acc_cust);
				ps.setString(1, c.getCustomerName());
				ps.setString(2, c.getEmail());
				ps.setString(3, c.getAddress());
				ps.setString(4, c.getPanCard());
				ps.setString(5, u.getUserId());
				int rs1=ps.executeUpdate();
				Statement s=con.createStatement();
				ResultSet r=s.executeQuery("select customerid_seq.currval from dual");
				if(r.next())
				{
					u.setCustomerId(r.getInt(1));
				}
												
				id=createNewAccountExistingCustomer(a, u.getCustomerId());
				
		} catch (SQLException e) {
			
			logger.error(e.getMessage());
			throw new OnlineBankingException("Technical Error refer log");
		}
				
		return id;
		
	}
	@Override
	public List<Transactions> viewAllTransctions() throws OnlineBankingException {
		
		con= DatabaseConnection.getConnection();
		ps=con.prepareStatement(QueryMapper.transdet_of_all);
		
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
