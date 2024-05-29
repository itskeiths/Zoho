class FindIndices{	
	public static void main(String[] args){
		String s="barfoofoobarthefoobarman";
		String[] words ={"bar","foo","the"};
		findIndices(s,words);
		/*String s = "wordgoodgoodgoodbestword";
		String[] words ={"word","good","best","word"};
		findIndices(s,words);*/
	}
	
	public static void findIndices(String s, String[] words){
		int len = words[0].length();
		int totallen= len*words.length;
		int i=0;
		int found = 0;
		int count=0;
		while(i+len<s.length()){
			found=1;
			boolean[] assigned = new boolean[words.length];
			int j=i;
			while(j<i+totallen && j<s.length()){
				for(int k=0;k<words.length;k++){
				if(!assigned[k] && subString(s,j,j+len).equals(words[k])){
					assigned[k] = true;
					break;
				}
				}
				j+=len;
			}
			for(int k=0;k<words.length;k++) {
				if(!assigned[k]) found=0;
			}
			if(found==1) System.out.println(i);
			i=i+len;
		}
	}
	
	public static String subString(String s, int start, int end){
		String res="";
		for(int i=start;i<end;i++) res+=s.charAt(i);
		return res;
	}
}