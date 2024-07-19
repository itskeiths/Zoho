import java.util.*;
class ValidParentheses{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter parentheses:");
		String str = in.next();
		int n = str.length();
		int[] memo = new int[str.length()];
		int maxParen =0;
		Arrays.fill(memo,-1);
		memo[0]=0;
		for(int i=1;i<n;i++){
			if(str.charAt(i)=='(') memo[i]=0;
			else if(str.charAt(i)==')' && str.charAt(i-1)=='('){
				memo[i]=2;
				if((i-2)>=0) memo[i]+=memo[i-2];
			}
		else if(str.charAt(i)==')' && str.charAt(i-1)==')'){
			int len=0;
			if(i-1>=0) len=memo[i-1];
			if(i-1-len>=0 && str.charAt(i-1-len)=='('){
				memo[i]=2+len;
				if(i-2-len>=0) memo[i]+=memo[i-2-len];
			}
			else memo[i]=0;
		}
		}
		int max =0;
		for(int num:memo) max=max>num?max:num;
		System.out.println(max);
	}
}