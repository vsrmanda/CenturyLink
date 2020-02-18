package rewards;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CountRewards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("monthly rewards:");
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

	
	ArrayList<Transaction> transList = new ArrayList<Transaction>();
	
	transList.add(t1);
	transList.add(t2);
	transList.add(t3);
	transList.add(t4);
	transList.add(t5);
	transList.add(t6);
	transList.add(t7);
	transList.add(t8);
	transList.add(t9);
	
	Customer c1 = new Customer(1);
	Customer c2 = new Customer(2);
	Customer c3 = new Customer(3);
	
	Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	
	customers.put(1, c1);
	customers.put(2, c2);
	customers.put(3, c3);
	
	for(Transaction tran:transList) {
		 
		if(tran.getTranAmout() > 50 && tran.getTranAmout() < 100) {
			customers.get(tran.customerId).numTrans++;
			//customers.get(tran.customerId).setTotalRewards(tran.getTranAmout());
			
		}
	}
	
	}

}
