import java.util.*;
import java.io.*;
class Bank{
	static Scanner in = new Scanner(System.in);
	static List<Customer> customers = new ArrayList<>();
	static HashMap<Integer,Customer> identifycustomer = new HashMap<>();
	static HashMap<Integer,Customer> accmap  = new HashMap<>();
	static int cusid=0;
	static int acc=10000;
	static void createObject(String str){
		String[] res = str.split(",");
		int cus_id = Integer.parseInt(res[0]);
		int acc_no = Integer.parseInt(res[1]);
		String name = res[2];
		double balance = Double.parseDouble(res[3]);
		String pwd = res[4];
		Customer cus = new Customer(cus_id,acc_no,name,balance,pwd);
		customers.add(cus);
		identifycustomer.put(cus_id,cus);
		accmap.put(acc_no,cus);
	}
	
	static String encrypt(String str){
		String res ="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='9') res+='0';
			else if(str.charAt(i)=='Z') res+=""+'A';
			else if(str.charAt(i)=='z') res+=""+'a';
			else{
				char temp = (char)(str.charAt(i)+1);
				res+=""+temp;
			}
		}
		return res;
	}
	
	
	static boolean authentication(int cust_id, String pwd){
		Customer cus = null;
		if(identifycustomer.containsKey(cust_id)){
			cus = identifycustomer.get(cust_id);
			if(cus.pwd.equals(encrypt(pwd))) return true;
		}
		return false;
	}
	
	static void withDraw(Customer cus){
		cus.no_of_transactions++;
		System.out.println("Enter the amount to withdraw:");
		double amount = in.nextDouble();
		if(amount>5000){
			cus.transactions.add(cus.no_of_transactions+","+"NOMINAL FEE"+","+10+","+(cus.balance-10));
			cus.no_of_transactions++;
			amount +=10;
		}
		if(cus.no_of_transactions%10==0){
			cus.transactions.add(cus.no_of_transactions+","+"MAINTANACE FEE"+","+100+","+(cus.balance-100));
			cus.no_of_transactions++;
			amount +=100;
		}
		if(cus.balance-amount<1000) System.out.println("Insufficient Balance:");
		cus.balance-=amount;
		cus.transactions.add(cus.no_of_transactions+","+"ATMWithdrawl"+","+amount+","+cus.balance);
		System.out.println("Withdrawn sucessfully!");
		System.out.println("Your balance is:" + cus.balance);
					
	}
	
	static void changePassword(Customer cus){
		if(cus.pwdhistory.size()>3) cus.pwdhistory.remove(0);
		System.out.println("Enter the new Password:");
		String newPassword = in.next();
		System.out.println("Retype the Password:");
		String retype = in.next();
		if(cus.pwdhistory.contains(encrypt(newPassword))){
			System.out.println("Password is same as previous");
			return;
		}
		if(!vaildate(newPassword,retype)){
			System.out.println("Passwords doesn't match or violated");
			return;
		}
		cus.pwd = encrypt(newPassword);
		cus.pwdhistory.add(cus.pwd);
		System.out.println("Password changed Successfully!");
	}
	
	static void transferAmount(Customer cus){
		cus.no_of_transactions++;
		System.out.println("Enter the beneficiary Account number:");
		int beneficiary = in.nextInt();
		if(!accmap.containsKey(beneficiary)){
			System.out.println("Beneficiary Account not found:");
			return;
		}
		System.out.println("Enter the amount to transfer:");
		double amount = in.nextDouble();
		if(amount>5000){
			cus.transactions.add(cus.no_of_transactions+","+"NOMINAL FEE"+","+10+","+(cus.balance-10));
			cus.no_of_transactions++;
			amount +=10;
		}
		if(cus.no_of_transactions%10==0){
			cus.transactions.add(cus.no_of_transactions+","+"MAINTANACE FEE"+","+100+","+(cus.balance-100));
			cus.no_of_transactions++;
			amount +=100;
		}
		if(cus.balance-amount<1000) System.out.println("Insufficient Balance:");
		cus.balance-=amount;
		cus.transactions.add(cus.no_of_transactions+","+"TransferTo"+beneficiary+","+amount+","+cus.balance);
		Customer to = accmap.get(beneficiary);
		to.balance+=amount;
		to.no_of_transactions++;
		to.transactions.add(to.no_of_transactions+","+"TransferFrom"+cus.acc_no+","+amount+","+to.balance);
		System.out.println("Amount Transfered Sucessfully!");
		System.out.println("Your balance is:" + cus.balance);
					
	}
	
	static void deposit(Customer cus){
		cus.no_of_transactions++;
		System.out.println("Enter the amount to deposit:");
		double amount = in.nextDouble();
		if(amount<0) System.out.println("Invalid Amount");
		if(cus.no_of_transactions%10==0){
			cus.transactions.add(cus.no_of_transactions+","+"MAINTANACE FEE"+","+100+","+(cus.balance-100));
			cus.no_of_transactions++;
			amount +=100;
		}
		cus.balance+=amount;
		cus.transactions.add(cus.no_of_transactions+","+"Cash Deposit"+","+amount+","+cus.balance);
		System.out.println("Deposited sucessfully!");
		System.out.println("Your balance is:" + cus.balance);
	}
	
	static boolean vaildate(String str1,String str2){
		if(!str1.equals(str2)) return false;
		if(str1.length()<6) return false;
		int countlower=0,countupper=0,countnumber=0;
		for(int i=0;i<str1.length();i++){
			if(str1.charAt(i)>='a' && str1.charAt(i)<='z') countlower++;
			if(str1.charAt(i)>='A' && str1.charAt(i)<='Z') countupper++;
			if(str1.charAt(i)>='1' && str1.charAt(i)<='9') countnumber++;
		}
		return (countlower>1 && countupper>1 && countnumber>1);
	}
	
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("bank.txt");
		File file = new File("bank_db.txt");
		Scanner data = new Scanner(file);
		data.nextLine();
		while(data.hasNextLine()){
			String customer = data.nextLine();
			try{createObject(customer);}
			catch(Exception e){}
		}
		int cus_id,acc_no;
		String name,password,retype;
		double balance,amount;
		while(true){
			System.out.println("1)Create New Account\n2)Withdraw amount\n3)Deposit amount\n4)Transfer amount\n5)Change Password");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter Your Name:");
					name = in.next();
					System.out.println("Type Password:");
					password = in.next();
					System.out.println("Retype Password:");
					retype = in.next();
					if(!vaildate(password,retype)){
						System.out.println("Passwords doesn't match or violated");
						break;
					}
					cusid++;
					acc++;
					Customer cus = new Customer(cusid,acc,name,10000,encrypt(password));
					System.out.println("Your account created sucessfully!");
					System.out.println("Your customer id is:" + cusid);
					System.out.println("Your account number is:" + acc);
					customers.add(cus);
					identifycustomer.put(cusid,cus);
					accmap.put(acc,cus);
					try{
						fw.append(cusid+","+acc+","+name+","+10000+","+encrypt(password));
						fw.close();
					}
					catch(Exception e){}
					break;
				case 2:
					System.out.println("Enter your customer id:");
					cus_id=in.nextInt();
					System.out.println("Enter your password:");
					password = in.next();
					if(!authentication(cus_id,password)){
						System.out.println("User name or password is not correct!");
						break;
					}
					System.out.println("Authenticated succesfully!");
					cus = identifycustomer.get(cus_id);
					if(cus.no_of_transactions%5==0){
						System.out.println("You need to change Password:");
						changePassword(cus);
					}
					withDraw(cus);
					break;
				case 3:
					System.out.println("Enter your customer id:");
					cus_id=in.nextInt();
					System.out.println("Enter your password:");
					password = in.next();
					if(!authentication(cus_id,password)){
						System.out.println("User name or password is not correct!");
						break;
					}
					System.out.println("Authenticated succesfully!");
					cus = identifycustomer.get(cus_id);
					if(cus.no_of_transactions%5==0){
						System.out.println("You need to change Password:");
						changePassword(cus);
					}
					deposit(cus);
					break;
				case 4:
					System.out.println("Enter your customer id:");
					cus_id=in.nextInt();
					System.out.println("Enter your password:");
					password = in.next();
					if(!authentication(cus_id,password)){
						System.out.println("User name or password is not correct!");
						break;
					}
					System.out.println("Authenticated succesfully!");
					cus = identifycustomer.get(cus_id);
					if(cus.no_of_transactions%5==0){
						System.out.println("You need to change Password:");
						changePassword(cus);
					}
					transferAmount(cus);
					break;
				case 5:
					System.out.println("Enter your customer id:");
					cus_id=in.nextInt();
					System.out.println("Enter your password:");
					password = in.next();
					if(!authentication(cus_id,password)){
						System.out.println("User name or password is not correct!");
						break;
					}
					System.out.println("Authenticated succesfully!");
					cus = identifycustomer.get(cus_id);
					changePassword(cus);
					break;
			}
		}
		
	}
}