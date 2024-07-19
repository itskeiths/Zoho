import java.util.*;
class Sample{
	
	public static void main(String[] args){
		User u = new User("Ravi","ravi@gmail.com",344343434,"gaaga","raafaf",1000);
		List<User> user = new ArrayList<>();
		user.add(u);
		user.remove(u);
	}
}