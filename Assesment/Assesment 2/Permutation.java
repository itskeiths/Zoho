import java.util.*;
class Permutation{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a String:");
		String str = in.next();
		char[] arr = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i);
		}
		permute(arr,0);
	}
	
	public static boolean check(char[] arr, int start, int cur){
		for(int i=start;i<cur;i++){
			if(arr[i]==arr[cur]) return false;
		}
		return true;
	}
	public static void permute(char[] arr, int start){
		if(start==arr.length){
			for(char i:arr) System.out.print(i);
			System.out.print(",");
		}
		for(int i=start;i<arr.length;i++){
			if(check(arr,start,i)){
			char temp = arr[start];
			arr[start] = arr[i];
			arr[i] = temp;
			permute(arr,start+1);
			arr[i] = arr[start];
			arr[start] = temp;
		}
		}
	}
}