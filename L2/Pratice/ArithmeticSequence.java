import java.util.Scanner;
class ArithmeticSequence{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter elements of array:");
		for(int i=0;i<n;i++) arr[i]=in.nextInt();
		int k=3;
		int count = 0;
		while(k<=n){
		int i=0;
		while(i+k<=n){
			int diff = arr[i+1]-arr[i];
			int flag = 0;
			for(int j=i+1;j<i+k-1;j++){
				if(j+1<n && (arr[j+1]-arr[j]!=diff)){
					flag = 1;
					break;
				}
			}
			if(flag==0){
			count++;
			//for(int j=i;j<i+k;j++) System.out.print(arr[j]+" ");
			//System.out.println();
			}
			i++;
		}
		k++;
		}
		System.out.println(count);
	}
}