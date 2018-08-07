CREATE TABLE Account_Master(Account_ID NUMBER(10) PRIMARY KEY,Account_Type VARCHAR2(25),Account_Balance NUMBER(15),Open_Date DATE, user_id VARCHAR2(20) REFERENCES User_Table(user_id), Customer_ID NUMBER(10) REFERENCES Customer(Customer_ID));

CREATE TABLE Customer(Customer_ID NUMBER(10) PRIMARY KEY, customer_name VARCHAR2(50), Email VARCHAR2(30), Address VARCHAR2(100), Pancard VARCHAR2(15),user_id VARCHAR2(20) REFERENCES User_Table(user_id));

CREATE TABLE Transaction(Transaction_ID NUMBER(10) PRIMARY KEY,Tran_description VARCHAR2(100), DateofTransaction DATE , TransactionType VARCHAR2(1), TranAmount NUMBER(15) ,Account_No NUMBER(10) REFERENCES Account_Master(Account_ID));

CREATE TABLE Service_Tracker(Service_ID NUMBER(10) PRIMARY KEY, Service_Description VARCHAR2(100),Account_ID NUMBER(20) REFERENCES Account_Master(Account_ID), Service_Raised_Date DATE ,Service_status VARCHAR2(20));

CREATE TABLE User_Table(user_id VARCHAR2(20) PRIMARY KEY,login_password VARCHAR2(15),secret_question VARCHAR2(50),Transaction_password VARCHAR2(15),lock_status VARCHAR2(1));

CREATE TABLE Fund_Transfer(FundTransfer_ID NUMBER PRIMARY KEY,Account_ID NUMBER(10) REFERENCES Account_Master(Account_ID) ,Payee_Account_ID NUMBER(10), Date_Of_Transfer DATE, Transfer_Amount NUMBER(15));

CREATE TABLE PayeeTable(Account_Id NUMBER REFERENCES Account_Master(Account_ID),Payee_Account_Id NUMBER PRIMARY KEY, Nick_name VARCHAR2(40));
