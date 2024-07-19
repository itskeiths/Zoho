import java.util.Scanner;
class LongestSubstring{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		int n = str.length();
		int[] count = new int[26];
		int i=0,j=0,maxlen=0,len=0;
		while(j<n){
			if(count[str.charAt(j)-'a']==0) count[str.charAt(j)-'a']++;
			else{
				len = j-i;
				for(int k=i;k<j;k++) count[str.charAt(k)-'a']--;
				count[str.charAt(j)-'a']++;
				i=j;
				if(len>maxlen) maxlen=len;
			}
			j++;
		}
		System.out.println("Length of longest substring without repeating characters is: "+maxlen);
	}
}