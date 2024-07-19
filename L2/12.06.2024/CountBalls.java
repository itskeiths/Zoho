import java.util.Scanner;
class CountBalls{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter lower limit:");
		int lower = in.nextInt();
		System.out.println("Enter higher limit:");
		int higher = in.nextInt();
		int maxballs = 0;
		int[] count = new int[46];
		for(int i=lower;i<=higher;i++){
			int num = sumDigits(i);
			count[num]++;
		}
		for(int i=0;i<46;i++){
			if(count[i]>maxballs) maxballs=count[i];
		}
		System.out.println("Most number of balls in box is: "+maxballs);
	}
	
	static int sumDigits(int num){
		if(num<10) return num;
		int sum = 0;
		while(num>0){
			sum+=(num%10);
			num/=10;
		}
		return sum;
	}
}