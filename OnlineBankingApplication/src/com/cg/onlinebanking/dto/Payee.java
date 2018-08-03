package com.cg.onlinebanking.dto;

public class Payee 
{
	private int accountId;
	private int payeeAccId;
	private String nickname;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPayeeAccId() {
		return payeeAccId;
	}
	public void setPayeeAccId(int payeeAccId) {
		this.payeeAccId = payeeAccId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
