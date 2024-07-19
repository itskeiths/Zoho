import java.util.*;
class IP{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a ipV4 address:");
		String ip = in.next();
		System.out.println("Enter other ipv4 address:");
		String ip2 = in.next();
		String mergeIp=binToDec(andOperation(convertBinary(ip),convertBinary(ip2)));
		System.out.println(mergeIp);
		
	}
	
	static String andOperation(String s1,String s2){
		StringBuilder and = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)=='1' && s2.charAt(i)=='1') and.append('1');
			else if(s1.charAt(i)!='.') and.append('0');
			else and.append('.');
		}
		return and.toString();
	}
	
	static String convertBinary(String s){
		String[] arr = new String[4];
		StringBuilder temp = new StringBuilder();
		int j=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='.'){
				arr[j++]=temp.toString();
				temp = new StringBuilder();
			}
			else temp.append(s.charAt(i));
		}
		arr[j]=temp.toString();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			sb.append(decToBin(Integer.parseInt(arr[i])));
			if(i!=arr.length-1) sb.append('.');
		}
		return sb.toString();
	}
	
	static String binToDec(String s){
		StringBuilder temp = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)!='.') temp.append(s.charAt(i));
			else{
				ans.append(bin(temp.toString()));
				ans.append('.');
				temp = new StringBuilder();
			}
		}
		ans.append(bin(temp.toString()));
		return ans.toString();
	}
	
	static String bin(String s){
		int temp=0;
		int pow = 0;
		for(int i=s.length()-1;i>=0;i--){
			temp+=(int)(Math.pow(2,pow++))*(int)(s.charAt(i)-'0');
		}
		return String.valueOf(temp);
	}
	
	static String decToBin(int num){
		StringBuilder res = new StringBuilder();
		while(num>0){
			int temp = num%2;
			res.append(temp);
			num=num/2;
		}
		while(res.length()<8) res.append(0);
		return res.reverse().toString();
	}
}