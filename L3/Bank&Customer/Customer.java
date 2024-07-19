import java.util.*;
import java.io.*;
class Customer{
	int cust_id;
	int acc_no;
	String name;
	double balance;
	String pwd;
	int no_of_transactions=0;
	List<String> transactions;
	List<String> pwdhistory;
	FileWriter fw;
	
	static void createWriter(Customer cus) throws IOException{
		cus.fw = new FileWriter("Customer"+cus.cust_id+".txt");
		cus.fw.write("TransId,TransType,Amount,Balance");
	}
	
	Customer(int cust_id,int acc_no,String name, double balance, String pwd) {
		this.cust_id= cust_id;
		this.acc_no = acc_no;
		this.name = name;
		this.balance = balance;
		this.pwd = pwd;
		this.pwdhistory = new ArrayList<>();
		this.transactions = new ArrayList<>();
		this.pwdhistory.add(pwd);
		try{this.createWriter(this);}
		catch(Exception e){}
		this.no_of_transactions++;
		this.transactions.add(no_of_transactions+","+"Opening"+","+balance+","+balance);
	}
}