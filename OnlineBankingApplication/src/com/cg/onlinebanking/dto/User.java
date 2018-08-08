package com.cg.onlinebanking.dto;

public class User 
{
   private String userId;
   private String password;
   private String secretQuestion;
   private String transactionPassword;
   private String lockStatus;
   private int customerId;
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSecretQuestion() {
	return secretQuestion;
}
public void setSecretQuestion(String secretQuestion) {
	this.secretQuestion = secretQuestion;
}
public String getTransactionPassword() {
	return transactionPassword;
}
public void setTransactionPassword(String transactionPassword) {
	this.transactionPassword = transactionPassword;
}
public String getLockStatus() {
	return lockStatus;
}
public void setLockStatus(String lockStatus) {
	this.lockStatus = lockStatus;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", password=" + password + ", secretQuestion=" + secretQuestion
			+ ", transactionPassword=" + transactionPassword + ", lockStatus=" + lockStatus + "]";
}
   
	

}
