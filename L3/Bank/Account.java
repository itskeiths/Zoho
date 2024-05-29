import java.util.*;
public class Account{
	private String name;
	protected static double acc_no=1000000000;
	protected double balance=0;
	protected String acc_type;
	Account(String name, double balance ){
		this.name = name;
		this.balance += balance;
		this.acc_no = acc_no;
	}
	
	void displayAccountDetails(){
		System.out.println("Name: "+this.name);
		System.out.println("Account No: "+ (int)this.acc_no);
		System.out.println("Account Type: " + this.acc_type);
		System.out.println("Balance: Rs."+this.balance);
	}
	public void withDraw(double amount){};
	public void deposit(double amount){};
	public void checkBalance(){};
	public void calculateInterest(int time){System.out.println("This account can't provide any interest");}
}

class SavingsAccount extends Account{
	private double account_number;
	public SavingsAccount(String name, double balance){
		super(name,balance);
		super.acc_type= "Savings";
		acc_no++;
	}
	
	public void calculateInterest(int time){
		double interest = super.balance*0.01*time;
		System.out.println("Interest to be added: "+interest);
		super.balance +=interest;
		checkBalance();
		
	}
	public void withDraw(double amount){
		if(amount>super.balance){
			System.out.println("Balance is low!");
			return;
		}
		System.out.println("Amount withdrawn Sucessfully");
		super.balance-=amount;
		System.out.println("Your balance is Rs."+super.balance);
		
	}
	
	public void deposit(double amount){
		if(amount<=0) {
			System.out.println("Enter a valid amount");
			return;
		}
		System.out.println("Amount Deposited Sucessfully");
		super.balance+=amount;
	}
	
	public void checkBalance(){
		System.out.println("Your Balance :Rs. "+super.balance);
	}	
}

class CurrentAccount extends Account{
	private int min_balance = 1000;
	private double account_number;
	public CurrentAccount(String name, double balance){
		super(name,balance);
		acc_no++;
		super.acc_type="Current";
		checkMinBalance();
	}
	
	public void checkMinBalance(){
		if(super.balance<this.min_balance && super.balance>0){
			balance-=0.1*balance;
		}
	}
	
	public void checkBalance(){
		checkMinBalance();
		if(super.balance<this.min_balance){
			System.out.println("Balance less than minimum balance!\n Penalty deducted from Balance");
		}
		System.out.println("Your balance is Rs."+super.balance);
	}
	
	public void deposit(double amount){
		if(amount<=0) {
			System.out.println("Enter a valid amount");
			return;
		}
		System.out.println("Amount Deposited Sucessfully");
		super.balance+=amount;
	}
	
	public void withDraw(double amount){
		if(amount>super.balance){
			System.out.println("Balance is low!");
			return;
		}
		System.out.println("Amount withdrawn Sucessfully");
		super.balance-=amount;
		System.out.println("Your balance is Rs."+super.balance);
		
	}
	
}