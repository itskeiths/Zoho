import java.util.*;
class User{
	static Scanner in = new Scanner(System.in);
	String name;
	String email;
	double mobile;
	String H_ID;
	String pwd;
	double rc_balance;
	double zc_balance;
	int zid;
	List<String> rcTransactions;
	List<String> zcTransactions;
	User(String name, String email, double mobile,String H_ID,String pwd, double rc_balance){
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.H_ID = H_ID;
		this.pwd = pwd;
		this.rc_balance=rc_balance;
		this.zc_balance=0;
		rcTransactions = new ArrayList<>();
		zcTransactions = new ArrayList<>();
		rcTransactions.add("Deposited Amount:" + rc_balance);
	}
	
	void rcTransactions(){
		System.out.println("Your RC Balance is: "+rc_balance);
		while(true){
			System.out.println("1)Deposit RC\n2)Withdraw RC\n3)Convert RC to ZCoin");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter the amount to deposit:");
					double amount = in.nextDouble();
					if(amount<0){
						System.out.println("Invalid Amount");
						break;
					}
					rc_balance+=amount;
					System.out.println("Amount Deposited Sucessfully:");
					rcTransactions.add("Amount Deposited Sucessfully:"+amount);
					System.out.println("Your RC Balance is: "+rc_balance);
					break;
				case 2:
					System.out.println("Enter the amount to withdraw:");
					amount = in.nextDouble();
					if(amount<0){
						System.out.println("Invalid Amount");
						break;
					}
					if(rc_balance<amount){
						System.out.println("Insufficent Balance");
						return;
					}
					rc_balance-=amount;
					System.out.println("Amount Withdrawn Sucessfully:");
					rcTransactions.add("Amount Withdrawn Sucessfully:"+amount);
					System.out.println("Your RC Balance is: "+rc_balance);
					break;
				case 3:
					System.out.println("Enter amount to transfer RC to ZC");
					amount = in.nextDouble();
					if(amount<0){
						System.out.println("Invalid Amount");
						break;
					}
					if(rc_balance<amount){
						System.out.println("Insufficent Balance");
						break;
					}
					rc_balance-=amount;
					zc_balance+=amount/2;
					System.out.println("Amount succesfully converted");
					rcTransactions.add("RC to ZC coin conversion:"+amount);
					System.out.println("Your RC Balance is: "+rc_balance);
					System.out.println("Your ZC Balance is: "+zc_balance);
					break;
					
				default:
					return;
			}
		}
	}
	
	void zcTransactions(){
		System.out.println("Your ZC Balance is: "+zc_balance);
		while(true){
			System.out.println("1)Transfer ZC to another account\n2)Convert ZC to RC");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter amount to transfer ZC to RC");
					double amount = in.nextDouble();
					if(amount<0){
						System.out.println("Invalid Amount");
						break;
					}
					if(zc_balance<amount){
						System.out.println("Insufficent Balance");
						break;
					}
					System.out.println("Enter the beneficiary ZID");
					int uzid = in.nextInt();
					if(!ZVerse.zididentity.containsKey(uzid)){
						System.out.println("User not found");
						break;
					}
					User u = ZVerse.zididentity.get(uzid);
					zc_balance-=amount;
					u.zc_balance+=amount;
					zcTransactions.add("Transfer from " +zid+" to "+uzid+" zcoin="+amount);
					u.zcTransactions.add("Received from " +zid + " zcoin= "+amount);
					break;
				
				case 2:
					System.out.println("Enter amount to transfer ZC to RC");
					amount = in.nextDouble();
					if(amount<0){
						System.out.println("Invalid Amount");
						break;
					}
					if(zc_balance<amount){
						System.out.println("Insufficent Balance");
						return;
					}
					zc_balance-=amount;
					rc_balance+=amount*2;
					rc_balance-=(amount*0.15);
					System.out.println("Amount succesfully converted");
					zcTransactions.add("ZC to RC coin conversion:"+amount);
					System.out.println("Your RC Balance is: "+rc_balance);
					System.out.println("Your ZC Balance is: "+zc_balance);
					break;
					
				default:
					return;
			}
		}
	}
}