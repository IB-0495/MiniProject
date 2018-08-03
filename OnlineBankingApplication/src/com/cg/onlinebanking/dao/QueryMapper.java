package com.cg.onlinebanking.dao;

public class QueryMapper {
	
	public static final String mini_statement="SELECT *\r\n" + 
			" FROM (SELECT * FROM Transactions ORDER BY DateofTransaction) sub\r\n" + 
			" WHERE rownum <= 10\r\n" + 
			" ORDER BY DateofTransaction DESC";
			
	
	
	public static final String detailed_statement="SELECT * FROM Transactions WHERE DateofTransaction between ? and ?" ;
	
	
	
    public static final String changeaddandphno="UPDATE customer SET address='?'where\r\n" + 
    		"       customer_id='?'";
    
    
    public static final String req_cheque=" select service_Id from serviceTracker\r\n" + 
    		"     where account_id='?'";
    
    
    
    public static final String track_ser_req="select service_status from serviceTracker\r\n" + 
    		"     where service_id='?'";
    
    
    public static final String fund_transfer="select * from fund_transfer\r\n" + 
    		"     where account_id='?'";
    
    
    public static final String pass_change="update user_table\r\n" + 
    		"     set\r\n" + 
    		"        login_password='?'\r\n" + 
    		"     where\r\n" + 
    		"         user_Id='?'";
    
    
    public static final String new_acc_cust="insert into customer(customer_id,customer_name,phone_number,emailid,city,ad\r\n" + 
    		"dress) values(?,'?',?,'?','?','')";
    public static final String new_acc_accdet="insert into account_master(account_id,account_type,account_balance,open_dat\r\n" + 
    		"e,accholder_name) values(?,'?',?,'?','?')";
    
    
    public static final String transdet_of_all="select * from Transactions";
    
    
}








}
