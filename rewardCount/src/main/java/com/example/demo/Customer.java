package com.example.demo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	public int customerId;
	public BigDecimal totalSpending = new BigDecimal(0);
	public int numTrans;
	public double totalRewards;
	Map<Integer, Double> monthlyRewards = new HashMap<Integer, Double>();
	
	
	public Map<Integer, Double> getMonthlyRewards() {
		return monthlyRewards;
	}

	public void setMonthlyRewards(Map<Integer, Double> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}

	public Customer(int customerId) {
		setCustomerId(customerId);
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public BigDecimal getTotalSpending() {
		return totalSpending;
	}
	public void setTotalSpending(BigDecimal totalSpending) {
		this.totalSpending = totalSpending;
	}
	public int getNumTrans() {
		return numTrans;
	}
	public void setNumTrans(int numTrans) {
		this.numTrans = numTrans;
	}
	public double getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(double d) {
		this.totalRewards = d;
	}
	
	public String toString() {
		return "total spending:"+this.getTotalSpending()+
				"; number of transactions:"+this.getNumTrans()+
				";total rewards:"+this.getTotalRewards()+
				"; monthly reward:"+this.getMonthlyRewards().toString();
	}
	

}
