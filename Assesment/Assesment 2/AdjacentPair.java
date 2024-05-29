import java.util.Scanner;
class AdjacentPairs{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two strings:");
		String str1 = in.next();
		String str2 = in.next();
		int len = str1.length();
		int i=0;
		System.out.println("Adjacent Pairs");
		while(i<len){
			int flag=0;
			String res1="",res2="";
			while(i<len && str1.charAt(i)!=str2.charAt(i)){
				res1+=str1.charAt(i);
				res2+=str2.charAt(i);
				i++;
				flag=1;
			}
			if(flag==1){
				System.out.println(res1+"-"+res2);
				i--;
			}
			i++;
		}
	}
}