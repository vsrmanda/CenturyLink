package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Customer;
import com.example.demo.Transaction;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello Springboot");
	
		// loop thru transactions file, build customer objects, add to collection

		// build Transaction objects for testing
		Transaction t1 = new Transaction(1, 1, 64.99, new Date(2019, Calendar.OCTOBER, 22));
		Transaction t2 = new Transaction(2, 2, 109.99, new Date(2019, Calendar.OCTOBER, 22));
		Transaction t3 = new Transaction(3, 3, 44.99, new Date(2019, Calendar.OCTOBER, 22));
		Transaction t4 = new Transaction(4, 1, 64.99, new Date(2019, Calendar.NOVEMBER, 22));
		Transaction t5 = new Transaction(5, 2, 109.99, new Date(2019, Calendar.NOVEMBER, 22));
		Transaction t6 = new Transaction(6, 3, 44.99, new Date(2019, Calendar.NOVEMBER, 22));
		Transaction t7 = new Transaction(7, 3, 44.99, new Date(2019, Calendar.DECEMBER, 22));
		Transaction t8 = new Transaction(8, 2, 109.99, new Date(2019, Calendar.DECEMBER, 22));
		Transaction t9 = new Transaction(9, 1, 64.99, new Date(2019, Calendar.DECEMBER, 22));

		// declare ArryList to hold list of transacctions for iterating. Same list can be built from file IO or from Database resultset.
		ArrayList<Transaction> transList = new ArrayList<Transaction>();
		
		// add all transactions to list
		transList.add(t1);
		transList.add(t2);
		transList.add(t3);
		transList.add(t4);
		transList.add(t5);
		transList.add(t6);
		transList.add(t7);
		transList.add(t8);
		transList.add(t9);
		
		//declare customer objects for testing.
		Customer c1 = new Customer(1);
		Customer c2 = new Customer(2);
		Customer c3 = new Customer(3);
		
		// declare Map to hold customer objects with customer id as key to acccess.
		Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
		
		// add customer objects to map.
		customers.put(1, c1);
		customers.put(2, c2);
		customers.put(3, c3);
		
		// Iterate thru list of transactions for processing rewards.
		for(Transaction tran:transList) {
			 
			// transactions amount below 50
			if(tran.getTranAmout() < 50) {
				Customer tempCustomer = new Customer(tran.getCustomerId());
				tempCustomer.setTotalSpending(customers.get(tran.customerId).getTotalSpending().add(BigDecimal.valueOf(tran.getTranAmout())));
				tempCustomer.setNumTrans(customers.get(tran.customerId).getNumTrans()+1);
				
				Map<Integer, Double> tempMonthlyReward = new HashMap<Integer, Double>();
				tempMonthlyReward.put(Integer.valueOf(tran.getTranDate().getMonth()), Double.valueOf(customers.get(tran.customerId).getTotalRewards()));
				tempCustomer.getMonthlyRewards().putAll(tempMonthlyReward);
				tempCustomer.getMonthlyRewards().putAll(customers.get(tran.customerId).getMonthlyRewards());
				
				tempCustomer.setTotalRewards(customers.get(tran.customerId).getTotalRewards());
				customers.replace(tran.customerId, tempCustomer);
				
			// transactions amount about 100	
			} else if(tran.getTranAmout() > 100) {
				Customer tempCustomer = new Customer(tran.getCustomerId());
				tempCustomer.setTotalSpending(customers.get(tran.customerId).getTotalSpending().add(BigDecimal.valueOf(tran.getTranAmout())));
				tempCustomer.setNumTrans(customers.get(tran.customerId).getNumTrans()+1);
				
				Map<Integer, Double> tempMonthlyReward = new HashMap<Integer, Double>();
				tempMonthlyReward.put(Integer.valueOf(tran.getTranDate().getMonth()), Double.valueOf(50+2*(tran.getTranAmout()-100)));
				tempCustomer.getMonthlyRewards().putAll(tempMonthlyReward);
				tempCustomer.getMonthlyRewards().putAll(customers.get(tran.customerId).getMonthlyRewards());
				
				tempCustomer.setTotalRewards(customers.get(tran.customerId).getTotalRewards()+50+2*(tran.getTranAmout()-100));
				customers.replace(tran.customerId, tempCustomer);
				
			// transactions amount between 50 to 100
			} else {
				Customer tempCustomer = new Customer(tran.getCustomerId());
				tempCustomer.setTotalSpending(customers.get(tran.customerId).getTotalSpending().add(BigDecimal.valueOf(tran.getTranAmout())));
				tempCustomer.setNumTrans(customers.get(tran.customerId).getNumTrans()+1);
				
				Map<Integer, Double> tempMonthlyReward = new HashMap<Integer, Double>();
				tempMonthlyReward.put(Integer.valueOf(tran.getTranDate().getMonth()), Double.valueOf(tran.getTranAmout()-50));
				tempCustomer.getMonthlyRewards().putAll(tempMonthlyReward);
				tempCustomer.getMonthlyRewards().putAll(customers.get(tran.customerId).getMonthlyRewards());
				
				tempCustomer.setTotalRewards(customers.get(tran.customerId).getTotalRewards()+(tran.getTranAmout()-50));
				customers.replace(tran.customerId, tempCustomer);
			}
		}
		
		// print bout Customer rewards info, report generation, can be written to file or database.
		Iterator custIterator = customers.entrySet().iterator();
		while(custIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry)custIterator.next(); 
            System.out.println("customerid: "+ mapElement.getKey() + "; " + 
            									mapElement.getValue().toString()); 
		}

	}

}
