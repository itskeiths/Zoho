import java.util.Scanner;
class Arrangements{
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter numbers of red balls:");
		int r = in.nextInt();
		System.out.println("Enter numbers of green balls:");
		int g = in.nextInt();
		System.out.println("Enter numbers of blue balls:");
		int b = in.nextInt();
		char[] c = new char[r+g+b];
		int k=0;
		for(int i=0;i<r;i++) c[k++]='r';
		for(int i=0;i<g;i++) c[k++]='g';
		for(int i=0;i<b;i++) c[k++]='b';
		permute(c,0);
		System.out.println("Total number of arrangements: "+count);
	}
	
	static boolean same(char[] c, int start, int end){
		for(int i=start;i<end;i++){
			if(c[i]==c[end]) return false;
		}
		return true;
	}
	
	static void permute(char[] c,int idx){
		if(idx==c.length){
			if(check(sb.toString())){
				count++;
			}
			return;
		}
		for(int i=idx;i<c.length;i++){
			if(same(c,idx,i)){
			char temp = c[i];
			c[i]=c[idx];
			c[idx]=temp;
			sb.append(c[idx]);
			permute(c,idx+1);
			sb.deleteCharAt(sb.length()-1);
			c[idx]=c[i];
			c[i]=temp;
			}
		}
	}
	
	static boolean check(String str){
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)) return false;
		}
		return true;
	}
}