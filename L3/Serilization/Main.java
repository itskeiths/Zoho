import java.util.*;
import java.io.*;
class Main implements Serializable{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		User u1 = new User("100");
		User u2 = new User("101");
		User u3 = new User("102");
		User u4 = new User("103");
		User u5 = new User("104");
		String userId,followerId,content;
		int postId;
		int choice=-1;
		while(choice!=0){
			System.out.println("1)CreatePost\n2)Follow\n3)UnFollow\n4)DeletePost");
			choice = in.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Enter User Id:");
					userId = in.next();
					System.out.println("Enter the content of post:");
					content = in.next();
					Post post = new Post(content);
					User.createPost(userId,post,post.postid);
					break;
						
				case 2:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the followerId:");
					followerId = in.next();
					User.follow(followerId,userId);
					break;
				
				case 3:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the followerId:");
					followerId = in.next();
					User.unfollow(followerId,userId);
					break;
				
				case 4:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the postId:");
					postId= in.nextInt();
					User.deletePost(userId, postId);
					break;
				
	
					
			}
		}
			try{
			FileOutputStream file = new FileOutputStream("Users.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			for(User user:User.users){
				obj.writeObject(user);
			}
			System.out.println("Serialized Sucessfully:");
			obj.close();
			file.close();
		}
			catch(Exception e){System.out.println("");}
			System.out.println("Enter your userID:");
					userId = in.next();
					User user = User.map.get(userId);
					try{
				FileInputStream fi = new FileInputStream("Users.txt");
			ObjectInputStream ob = new ObjectInputStream(fi);
			System.out.println("Your followers:");
			while(ob!=null){
				User u = (User)ob.readObject();
				if(u.userId.equals(userId)){
					for(User f: u.followers){
						System.out.println(f.userId);
					}
				}
			}
			fi.close();
			ob.close();
					}
			catch(Exception e){}
	}
}