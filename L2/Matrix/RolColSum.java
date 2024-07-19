/*Example 1:

Input: rowSum = [3,8], colSum = [4,7]
Output: [[3,0],
         [1,7]]
Explanation: 
0th row: 3 + 0 = 3 == rowSum[0]
1st row: 1 + 7 = 8 == rowSum[1]
0th column: 3 + 1 = 4 == colSum[0]
1st column: 0 + 7 = 7 == colSum[1]
The row and column sums match, and all matrix elements are non-negative.
Another possible matrix is: [[1,2],
                             [3,5]]*/
import java.util.Scanner;
class RowColSum{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the matrix size:");
		int n = in.nextInt();
		int[] rowSum = new int[n];
		int[] colSum = new int[n];
		System.out.println("Enter elements of rowSum:");
		for(int i=0;i<n;i++) rowSum[i]=in.nextInt();
		System.out.println("Enter elements of colSum:");
		for(int i=0;i<n;i++) colSum[i]=in.nextInt();
		int[][] ans = new int[n][n];
		int i=0,j=0;
		while(i<n && j<n){
			ans[i][j]=Math.min(rowSum[i],colSum[j]);
			rowSum[i]-=ans[i][j];
			colSum[j]-=ans[i][j];
			if(rowSum[i]==0) i++;
			if(colSum[j]==0) j++;
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++) System.out.print(ans[i][j]+" ");
			System.out.println();
		}
	}
}
