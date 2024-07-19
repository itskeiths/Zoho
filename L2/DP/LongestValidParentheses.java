import java.util.*;
class LongestValidParentheses{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter parentheses:");
		String str = in.next();
		int[] memo = new int[str.length()];
		int maxParen =0;
		Arrays.fill(memo,-1);
		for(int i=0;i<str.length();i++){
			maxParen=Math.max(maxParen,lonParen(str,i,memo));
		}
		System.out.println("Longest valid parentheses length: "+maxParen);
	}
	
	static int lonParen(String str,int i, int[] memo){
		if(i<=0) return 0;
		if(memo[i]!=-1) return memo[i];
		if(str.charAt(i)=='(') return memo[i]=0;
		else if(str.charAt(i)==')' && str.charAt(i-1)=='('){
			return memo[i]= lonParen(str,i-2,memo)+2;
		}
		else if(str.charAt(i)==')' && str.charAt(i-1)==')'){
			int len = lonParen(str,i-1,memo);
			if(i-1-len>=0 && str.charAt(i-1-len)=='('){
				return memo[i]=len+lonParen(str,i-2-len,memo)+2;
			}
			else return memo[i]=0;
		}
		return memo[i]=0;
	}
}