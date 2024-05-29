class MaxProfit{
	public static void main(String[] args){
		int prices1[] = {7,1,5,3,6,4};
		int prices2[] = {7,6,4,3,1};
		maxProfit(prices1);
		maxProfit(prices2);
		
	}
	
	public static void maxProfit(int[] prices){
		int cur = prices[0];
		int profit = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]<cur) cur=prices[i];
			if(prices[i]-cur>profit) profit = prices[i]-cur;
		}
		System.out.println("Max Profit: "+profit);
	}
}