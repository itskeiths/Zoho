/*Write a Java program to sort a numeric array and a string array.*/

class SortArray{
	public static void main(String[] args){
	String[] strarr = {"banana","orange","apple","mango","cucumber","ban","ball"};
	for(int i=1;i<strarr.length;i++){
		int j=i-1;
		String key = strarr[i];
		while(j>=0 && compare(key,strarr[j])<0){
			strarr[j+1]=strarr[j];
			j--;
		}
		strarr[j+1]=key;
	}
	for(int i=0;i<strarr.length;i++) System.out.print(strarr[i]+" ");
}
	
	public static int compare(String s1, String s2){	
		if(s1.charAt(0)>s2.charAt(0)) return 1;
		else if(s1.charAt(0)<s2.charAt(0)) return -1;
		int i = 0,j=0;
		while(i<s1.length() && j<s2.length()){
			if(s1.charAt(i)>s2.charAt(j)) return 1;
			i++;
			j++;
		}
		return i==s1.length()?-1:1;
	}
}