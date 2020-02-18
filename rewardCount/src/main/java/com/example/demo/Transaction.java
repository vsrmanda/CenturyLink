package com.example.demo;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	public int tranId;
	public int customerId;
	public double tranAmount;
	public Date tranDate;
	
	public Transaction(int tranId, int customerId, double tranAmount, Date tranDate) {
		setTranId(tranId);
		setCustomerId(customerId);
		setTranAmount(tranAmount);
		setTranDate(tranDate);
	}
	
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTranAmout() {
		return tranAmount;
	}
	public void setTranAmount(double tranAmout) {
		this.tranAmount = tranAmout;
	}
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
		
}
