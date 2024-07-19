/*Write a Java program to sort an array of positive integers of a given array. In the sorted array the value of the first element should be maximum, the second value should be the minimum value, the third should be the second maximum, the fourth second be the second minimum and so on.*/

class MaxMin{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
System.out.println("Enter number of elements:");
int n = in.nextInt();
int[] arr = new int[n];
System.out.println("Enter elements of array:");
for(int i=0;i<n;i++) arr[i]=in.nextInt();
	for(int i=1;i<n;i++){
		int key = arr[i];
		int j = i-1;
		while(j>=0 && key<=arr[j]){
			arr[j+1]=arr[j];
			j--;
		}
		arr[j+1] = key;
	}
	int[] ans = new int[arr.length];
	int max = arr.length-1;
	int min = 0;
	int k = 0;
	for(int i=0;i<arr.length;i++){
		if(i%2==0) ans[k++]=arr[max--];
		else ans[k++]=arr[min++];
	}
	for(int i=0;i<arr.length;i++) System.out.print(ans[i]+" ");
}
}