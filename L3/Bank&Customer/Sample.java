class Sample{
	public static void main(String[] args){
		System.out.println(encrypt("AB12ab"));
		System.out.println(decrypt("BC23bc"));
	}
	
	static String encrypt(String str){
		String res ="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='9') res+='0';
			else if(str.charAt(i)=='Z') res+=""+'A';
			else if(str.charAt(i)=='z') res+=""+'a';
			else{
				char temp = (char)(str.charAt(i)+1);
				res+=""+temp;
			}
		}
		return res;
	}
	
	static String decrypt(String str){
		String res ="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='0') res+='9';
			else if(str.charAt(i)=='A') res+=""+'Z';
			else if(str.charAt(i)=='a') res+=""+'z';
			else{
				char temp = (char)(str.charAt(i)-1);
				res+=""+temp;
			}
		}
		return res;
	}
}