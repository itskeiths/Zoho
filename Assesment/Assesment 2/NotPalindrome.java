import java.util.Scanner;
class NotPalindrome{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a sentence:");
		String str = in.nextLine();
		String substr = "";
		for(int i=0;i<str.length();i++){
			substr+=str.charAt(i);
			if(str.charAt(i)==' ' || i==str.length()-1){
				if(!isPalindrome(substr)){
					System.out.println(substr);
				}
				substr="";
			}
		}
	}
	
	public static boolean isPalindrome(String str){
		int i=0,j=str.length()-1;
		if(str.charAt(j)==' ') j--;
		while(i<j){
			if(str.charAt(i)==str.charAt(j)+32 || str.charAt(i)==str.charAt(j)-32){
				i++;j--;
				continue;
			}
			if(str.charAt(i)!=str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}