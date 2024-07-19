import java.util.Scanner;
class ValidString{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String of # and *:");
		String str = in.next();
		int countstar=0;
		int counthash=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='*') countstar++;
			else if(str.charAt(i)=='#') counthash++;
		}
		if(countstar==counthash) System.out.println("Valid String");
		else System.out.println(countstar-counthash);
	}
}