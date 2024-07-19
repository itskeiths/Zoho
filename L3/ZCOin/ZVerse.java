import java.util.*;
class ZVerse{
	static Scanner in = new Scanner(System.in);
	static List<ZEAgent> agents = new ArrayList<>();
	static Map<String,ZEAgent> agentidentity = new HashMap<>();
	static List<User> signups = new ArrayList<>();
	static List<User> users = new ArrayList<>();
	static Map<String,User> useridentity = new HashMap<>();
	static Map<Integer,User> zididentity = new HashMap<>();
	static boolean validate(String pwd,String name,String email){
		if(pwd.length()<8) return false;
		if(pwd.contains(name)) return false;
		StringBuilder userpart = new StringBuilder();
		for(int i=0;i<email.length();i++){
			if(email.charAt(i)=='@') break;
			userpart.append(email.charAt(i));
		}
		if(pwd.contains(userpart)) return false;
		int lower=0,upper=0,num=0,specialchar=0;
		for(int i=0;i<pwd.length();i++){
			if(pwd.charAt(i)>='a' && pwd.charAt(i)<='z') lower++;
			if(pwd.charAt(i)>='A' && pwd.charAt(i)<='Z') upper++;
			if(pwd.charAt(i)>='1' && pwd.charAt(i)<='9') num++;
			else specialchar++;
		}
		return lower>1&&upper>1&&num>1&&specialchar>1;
	}
	
	static void getAccountDetails(User u){
		System.out.println("User Name:" + u.name);
		System.out.println("User Email:" + u.email);
		System.out.println("User Mobile:" + u.mobile);
		System.out.println("Real Currency Balance:"+u.rc_balance);
		System.out.println("ZCoin Balance:"+u.zc_balance);
	}
	
	static void getTransactionHistory(User u){
		System.out.println("RC Transaction history:");
		for(String s: u.rcTransactions){
			System.out.println(s);
		}
		System.out.println("ZC Transaction history:");
		for(String s: u.zcTransactions){
			System.out.println(s);
		}
	}
	
	static void changePassword(User u){
		System.out.println("Enter your Password:");
		System.out.println("(Doesn't contains your name or email and contains atleast 2 uppercase, lower case, numebers and special chars)");
		String pwd = in.next();
		while(!validate(pwd,u.name,u.email)){
				System.out.println("Password doesn't meet the constraints");
				System.out.println("Renter your Password:");
				pwd = in.next();
		}
		u.pwd = pwd;
		System.out.println("Password changed Sucessfully");
	}
	
	public static void main(String[] args){
		ZEAgent agent1 = new ZEAgent("zagent@zmail.com","zage@12");
		String name;
		String email;
		double mobile;
		String H_ID;
		String pwd;
		double rc_balance;
		double zc_balance;
		int zid;
		while(true){
			System.out.println("--------In-App Currency Management System--------");
			System.out.println("1)Signup\n2)Login");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter your name:");
					name = in.next();
					System.out.println("Enter your email:");
					email = in.next();
					System.out.println("Enter your mobile number:");
					mobile = in.nextDouble();
					System.out.println("Enter your HID:");
					H_ID = in.next();
					System.out.println("Enter your Password:");
					System.out.println("(Doesn't contains your name or email and contains atleast 2 uppercase, lower case, numebers and special chars)");
					pwd = in.next();
					while(!validate(pwd,name,email)){
						System.out.println("Password doesn't meet the constraints");
						System.out.println("Renter your Password:");
						pwd = in.next();
					}
					System.out.println("Enter your intial deposit amount");
					rc_balance=in.nextDouble();
					User u = new User(name,email,mobile,H_ID,pwd,rc_balance);
					signups.add(u);
					useridentity.put(email,u);
					ZEAgent.requests.add(u);
					System.out.println("Signup request send");
					break;
				case 2:
					System.out.println("1)Agent Login\n2)User Login");
					int option = in.nextInt();
					switch(option){
						case 1:
							System.out.println("Enter your Zemail");
							String zmail = in.next();
							System.out.println("Enter your password:");
							String zpwd = in.next();
							if(!agentidentity.containsKey(zmail)){
								System.out.println("Your account not found");
								break;
							}
							ZEAgent agent = agentidentity.get(zmail);
							if(!agent.pwd.equals(zpwd)){
								System.out.println("Your password is incorrect");
								break;
							}
							int o = -1;
							while(o!=0){
							System.out.println("1)View Requests\n2)View User account Details");
							o=in.nextInt();
							switch(o){
								case 1:  
									agent.showRequests();
									break;
								case 2:
									System.out.println("Enter ZID of user");
									zid = in.nextInt();
									if(!zididentity.containsKey(zid)){
										System.out.println("User not found");
										break;
									}
									User user = zididentity.get(zid);
									getAccountDetails(user);
									getTransactionHistory(user);
									break;
								default:
									break;
							}
							}
							break;
							
						case 2:
							System.out.println("Enter your email");
							email = in.next();
							System.out.println("Enter your password:");
							pwd = in.next();
							if(!useridentity.containsKey(email)){
								System.out.println("User details not found Please signup first");
								break;
							}
							User user = useridentity.get(email);
							if(signups.contains(user)){
								System.out.println("Wait until Agent accept your request");
								break;
							}
							System.out.println("Your ZID is: "+ user.zid);
							o=-1;
							while(o!=0){
							System.out.println("1)Account Details\n2)Transaction History\n3)ChangePassword\n4)RC Transactions\n5)ZCoin Transactions");
							o = in.nextInt();
							switch(o){
								case 1:  
									getAccountDetails(user);
									break;
								case 2:
									getTransactionHistory(user);
									break;
								case 3:
									changePassword(user);
									break;
								case 4:
									user.rcTransactions();
									break;
								case 5:
									user.zcTransactions();
									break;
								default:
									break;
							}
							}
							break;
						default:
							break;
					}
					
			}
		}
	}
}