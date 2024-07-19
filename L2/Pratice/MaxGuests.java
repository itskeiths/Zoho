import java.util.Scanner;
class MaxGuests{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the hours:");
		int t = in.nextInt();
		int[] arr = new int[t];
		int[] exit = new int[t];
		System.out.println("Enter the number of guests arrive:");
		System.out.println("Enter the arriving time:");
		for(int i=0;i<t;i++) arr[i]=in.nextInt();
		System.out.println("Enter the number of guests exit:");
		System.out.println("Enter the exiting time:");
		for(int i=0;i<t;i++) exit[i]=in.nextInt();
		int guests = arr[0]-exit[0];
		int max = guests;
		for(int i=1;i<t;i++){
			int num = guests+arr[i]-exit[i];
			guests = num;
			max=max<guests?guests:max;
		}
		System.out.println(max);
	}
}