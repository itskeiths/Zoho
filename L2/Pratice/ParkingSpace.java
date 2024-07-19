import java.util.Scanner;
class ParkingSpace{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter rows and cols:");
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] mat = new int[m][n];
		System.out.println("Enter elements of matrix");
		for(int i=0;i<m;i++) for(int j=0;j<n;j++) mat[i][j]=in.nextInt();
		int max = 0;int row=1;
		for(int i=0;i<m;i++){
			int count = 0;
			for(int j=0;j<n;j++){
				if(mat[i][j]==1) count++;
			}
			if(count>max){
				max=count;
				row=i+1;
			}
		}
		System.out.println("The row contain most fill parking spaces is "+row);
	}
}