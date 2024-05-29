import java.util.*;
public class Customer{
	private String name;
	private double opening_balance;
	private int acc_type;
	private int password;
	private Account acc;
	static List<Customer> customers= new ArrayList<Customer>();
	Customer(String name,int password, double opening_balance,int acc_type){
		this.name = name;
		this.password = password;
		this.opening_balance = opening_balance;
		this.acc_type = acc_type;
	}
		
	int getPassword(){
		return this.password;
	}

	Account createAccount(){
		customers.add(this);
		if(acc_type==0) return (this.acc=new SavingsAccount(name,opening_balance));
		else return (this.acc =new CurrentAccount(name,opening_balance));
	}
	
	Account getAccount(){return this.acc;}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Customer c1 = new Customer("Ravi",123456,1000,0);
		Account a1 = c1.createAccount();
		Customer c2 = new Customer("Keith",123456,40000,1);
		Account a2 = c2.createAccount();
		Customer c3 = new Customer("Surya",123456,50000,1);
		Account a3 = c3.createAccount();
	
		System.out.println("Enter Name:");
		String name = in.next();
		System.out.println("Enter Password:");
		int password = in.nextInt();
		Customer cus = null ;
		Account acc = null;
		for(Customer c: customers){
			if(c.name.equals(name) && password == c.getPassword()) {
				cus = c;
				acc = c.getAccount();
			}
		}	
		if(cus==null){
			System.out.println("Invalid Details");
			return;
		}
		System.out.println("Welcome "+cus.name);
		while(true){	
			System.out.println("-------------------------------------------------------");
			System.out.println(" 1.Deposit Amount \n 2.Display Account Details \n 3.Compute and deposit Interest\n 4.Withdraw Amount \n 5.Check for mininum balance");
			System.out.println("-------------------------------------------------------");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter Amount to deposit:");
					int amount = in.nextInt();	
					acc.deposit(amount);
					break;
				case 2:
					acc.displayAccountDetails();
					break;
				case 3:
					System.out.println("Enter the time period(in months):");
					int time = in.nextInt();
					acc.calculateInterest(time);
					break;
				case 4:
					acc.checkBalance();
					System.out.println("Enter the amount to withdraw:");
					acc.withDraw(in.nextInt());
					break;
				case 5:
					acc.checkBalance();
					break;
				default:
					return;
					
			}
		}
		
	}
}