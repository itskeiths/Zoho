import java.util.*;
class ZEAgent{
	static Scanner in = new Scanner(System.in);
	static List<User> requests = new ArrayList<>();
	String email,pwd;
	static int zid=100;
	ZEAgent(String email, String pwd){
		this.email = email;
		this.pwd = pwd;
		ZVerse.agents.add(this);
		ZVerse.agentidentity.put(email,this);
	}
	
	static void showRequests(){
		if(requests.size()<1){
			System.out.println("No Requests");
			return;
		}
		for(int i=0;i<requests.size();i++){
			System.out.println("User Details:");
			System.out.println("HID "+requests.get(i).H_ID+"\nEmail: "+requests.get(i).email);
			System.out.println("Enter 1 for accept");
			int choice = in.nextInt();
			if(choice==1){
				ZVerse.signups.remove(requests.get(i));
				ZVerse.users.add(requests.get(i));
				ZVerse.useridentity.put(requests.get(i).email,requests.get(i));
				requests.get(i).zid = zid++;
				ZVerse.zididentity.put(requests.get(i).zid,requests.get(i));
				requests.remove(i);
			}
		}
		
	}
	
}