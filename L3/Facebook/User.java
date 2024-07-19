import java.util.*;
class User{
	String userId;
	List<Post> posts;
	List<User> followers;
	List<User> following;
	static List<User> users=new ArrayList<>();
	List<Post> newsFeed;
	static Map<String,User> map = new HashMap<>();
	
	User(String userId){
		this.userId = userId;
		posts = new ArrayList<>();
		followers = new ArrayList<>();
		following = new ArrayList<>();
		newsFeed = new ArrayList<>();
		users.add(this);
		map.put(userId,this);
	}
	
	static void follow(String followerId, String followeeId){
			if(!map.containsKey(followerId) || !map.containsKey(followeeId)){
				System.out.println("User or follower not found:");
				return;
			}
			User user = map.get(followeeId);
			User follower = map.get(followerId);
			user.following.add(follower);
			follower.followers.add(user);
			System.out.println("You are following user :"+follower.userId);
	}
		
	
	static void unfollow(String followerId, String followeeId){
			if(!map.containsKey(followerId) || !map.containsKey(followeeId)){
				System.out.println("User or follower not found:");
				return;
			}
			User user = map.get(followeeId);
			User follower = map.get(followerId);
			user.following.remove(follower);
			follower.followers.remove(user);
			System.out.println("You are unfollowing user :"+follower.userId);
	}
	
	static void createPost(String userId, Post post,int postid){
			if(!map.containsKey(userId)){
				System.out.println("User not found:");
				return;
			}
			User user = map.get(userId);
			user.posts.add(post);
			user.newsFeed.add(post);
			for(User follow:user.following){
				follow.newsFeed.add(post);
			}
			System.out.println("Post created sucessfully!");
			System.out.println("Your Post id is: "+postid);
	}
	
	static void deletePost(String userId, int postid){
		if(!map.containsKey(userId)){
				System.out.println("User not found:");
				return;
		}
		User user = map.get(userId);
		Post p = Post.postmap.get(postid);
		if(!user.posts.contains(p)){
				System.out.println("This is not your post or post not found!");
				return;
		}
		Post.posts.remove(p);
		Post.postmap.remove(p);
		user.posts.remove(p);
		user.newsFeed.remove(p);
		
		
		System.out.println("Post deleted sucessfully!");
	}
	
	static void getNewsFeed(String userId){
			if(!map.containsKey(userId)){
				System.out.println("User not found:");
				return;
			}
			User user = map.get(userId);
			System.out.println("The recently posted posts: ");
			int count = 0;
			for(Post p: user.newsFeed){
				if(count==10) break;
				if(Post.posts.contains(p)) System.out.println(p.postid);
			}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		User u1 = new User("100");
		User u2 = new User("101");
		User u3 = new User("102");
		User u4 = new User("103");
		User u5 = new User("104");
		String userId,followerId,content;
		int postId;
		while(true){
			System.out.println("1)CreatePost\n2)getNewsFeed\n3)Follow\n4)UnFollow\n5)DeletePost\n6)GetNewsFeedPaginated");
			int choice = in.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter User Id:");
					userId = in.next();
					System.out.println("Enter the content of post:");
					content = in.next();
					Post post = new Post(content);
					createPost(userId,post,post.postid);
					break;
						
				case 2:
					System.out.println("Enter User Id:");
					userId = in.next();
					getNewsFeed(userId);
					break;
				
				case 3:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the followerId:");
					followerId = in.next();
					follow(followerId,userId);
					break;
				
				case 4:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the followerId:");
					followerId = in.next();
					follow(followerId,userId);
					break;
				
				case 5:
					System.out.println("Enter your userID:");
					userId = in.next();
					System.out.println("Enter the postId:");
					postId= in.nextInt();
					deletePost(userId, postId);
					
					
			}
		}
	}
}