import java.util.*;
class Post{
	static int  postid;
	static List<Post> posts = new ArrayList<>();
	static Map<Integer,Post> postmap = new HashMap<>();
	String content;
	Post(String content){
		postid++;
		this.content = content;
		posts.add(this);
		postmap.put(postid,this);
	}
}