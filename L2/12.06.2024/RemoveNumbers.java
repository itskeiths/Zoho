import java.util.Scanner;
class RemoveNumbers{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n:");
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=1;i<=n;i++){
				arr[i-1]=i;
		}
		int size = n;
		int dir = 0;
		int temp[] = new int[n];
		while(size>1){
			size = remove(arr,dir);
			temp = new int[size];
			int j=0;
			for(int i=0;i<arr.length;i++){
				if(arr[i]!=0) temp[j++]=arr[i];
			}
			arr=temp;
			dir=1-dir;
		}
		System.out.println("Last number remain: "+temp[0]);
	}
	
	static int remove(int[] arr, int dir){
		int n = arr.length;
		int i=0;
		int count = 0;
		if(dir==0){
			while(i<n){
				arr[i]=0;
				i+=2;
				count++;
			}
		}
		if(dir==1){
			i=n-1;
			while(i>=0){
				arr[i]=0;
				i-=2;
				count++;
			}
		}
		return n-count;
	}
}