import java.util.*;
class GenerateParentheses{
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n: ");
		generateParentheses(in.nextInt(),0,0);
	}
	
	public static void generateParentheses(int n, int open, int close){
		if(open==close && open==n) {
			System.out.print(sb+" ,");
			return;
		}
		if(open<n){
			sb.append('(');
			open++;
			generateParentheses(n,open,close);
			open--;
			sb.deleteCharAt(sb.length()-1);
		}
		if(open>close && close<n){
			sb.append(')');
			close++;
			generateParentheses(n,open,close);
			close--;
			sb.deleteCharAt(sb.length()-1);
		}
	}
}