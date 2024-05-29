import java.util.Scanner;
class Pattern{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a String:");
		String str = in.next();
		System.out.println("Enter number of rows:");
		int rows = in.nextInt();
		int i=0;
		String[] res = new String[rows];
		for(int j=0;j<rows;j++) res[j]="";
		while(i<str.length()){
			for(int j=0;j<rows;j++){
				if(i<str.length()) res[j]+=str.charAt(i++);
			}
			for(int k=rows-2;k>0;k--){
				if(i<str.length()) res[k]+=str.charAt(i++);
			}
		}
		String result ="";
		for(int j=0;j<rows;j++) result+=res[j];
		System.out.println(result);
	}
}