import java.util.Scanner;
class CountSay{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		String res = "";
		int i=1;
		int count=1;
		while(i<str.length()){
			while(i<str.length() && str.charAt(i)==str.charAt(i-1)){
				count++;
				i++;
			}
			res+=count;
			res+=str.charAt(i-1);
			count=1;
			i++;
		}
		if(i==str.length()){
			res+=1;
			res+=str.charAt(i-1);
		}
		System.out.println(res);
	}
}