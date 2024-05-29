import java.util.*;
class Parentheses{
	static List<String> list = new ArrayList<>();
	static List<Character> temp = new ArrayList<>();
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n: ");
		generateParentheses(in.nextInt(),0,0);
		System.out.println(list);
	}
	
	public static void generateParentheses(int n, int open, int close){
		if(open==close && open==n) {
			String res = "";
			for(int i=0;i<temp.size();i++) res+=temp.get(i);
			list.add(res);
			return;
		}
		if(open<n){
			temp.add('(');
			open++;
			generateParentheses(n,open,close);
			open--;
			temp.remove(temp.size()-1);
		}
		if(open>close && close<n){
			temp.add(')');
			close++;
			generateParentheses(n,open,close);
			close--;
			temp.remove(temp.size()-1);
		}
	}
}