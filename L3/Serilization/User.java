import java.util.*;
import java.io.*;
class User implements Serializable{
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
		System.out.println("Post deleted sucessfully!");
	}
	
}