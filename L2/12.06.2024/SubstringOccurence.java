import java.util.Scanner;
class SubstringOccurence{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		System.out.println("Enter maxletters:");
		int maxletters = in.nextInt();
		System.out.println("Enter the minSize:");
		int minSize = in.nextInt();
		System.out.println("Enter the maxSize:");
		int maxSize = in.nextInt();
		int maxOccur = 0;
		for(int i=minSize;i<=maxSize;i++){
			int occur = findOccur(str,i,maxletters,"");
			if(occur>maxOccur) maxOccur=occur;
		}
		System.out.println("Maximum occurence of substring based on given criteria is: "+maxOccur);
	}
	
	static int findOccur(String str, int len , int maxLetter,String cur){
		int maxOccur = 0;
		for(int i=0;i+len<=str.length();i++){
			int occur=1;
			String temp = str.substring(i,i+len);
			if(!checkUnique(temp,maxLetter)){
				continue;
			}
			for(int j=i+1;j+len<=str.length();j++){
				if(temp.equals(str.substring(j,j+len))){
					occur++;
				}
			}
			if(occur>maxOccur) maxOccur = occur;
		}
		return maxOccur;
	}
	
	static boolean checkUnique(String str,int maxLetter){
		int[] count = new int[26];
		int unique=0;
		for(int i=0;i<str.length();i++){
			if(count[str.charAt(i)-'a']==0) unique++;
			count[str.charAt(i)-'a']++;
		}
		return unique<=maxLetter;
	}
}