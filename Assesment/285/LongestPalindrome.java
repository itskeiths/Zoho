import java.util.Scanner;
class LongestPalindrome{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		if(str.length()==0) return;
		int[] count = new int[52];
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='a' && str.charAt(i)<='z') count[str.charAt(i)-'a']++;
			else count[str.charAt(i)-'A'+26]++;
		}
		int length = 1;
		for(int i=0;i<52;i++){
			if(count[i]>1){
				if(count[i]%2==0) length+=count[i];
				else length+=count[i]-1;
			}
		}
		System.out.println("Max length: "+length);
	}
}