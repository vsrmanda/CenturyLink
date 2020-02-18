package rewards;

import java.math.BigDecimal;

public class Customer {
	public int customerId;
	public BigDecimal totalSpending;
	public int numTrans;
	public int totalRewards;
	
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
	public int getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}
	

}
