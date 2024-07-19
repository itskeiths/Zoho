/*
Example 1:

 +---+---+---+     +---+---+---+     +---+---+---+
 | 0 | 0 | 0 |     | 1 | 2 | 1 |     | 1 | 3 | 1 |
 +---+---+---+ --> +---+---+---+ --> +---+---+---+
 | 0 | 0 | 0 |     | 0 | 1 | 0 |     | 1 | 3 | 1 | 
 +---+---+---+     +---+---+---+     +---+---+---+

Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
*/

import java.util.Scanner;
class OddIncrement{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter m:");
		int m = in.nextInt();
		System.out.println("Enter n:");
		int n = in.nextInt();
		System.out.println("Enter rows and cols:");
		int row = in.nextInt();
		int col = in.nextInt();
		System.out.println("Enter elements of matrix:");
		int[][] ind = new int[row][col];
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++) ind[i][j]=in.nextInt(); 
		}
		int[] rows = new int[m];
		int[] cols = new int[n];
		for(int[] x: ind){
			rows[x[0]]++;
			cols[x[1]]++;
		}
		int count =0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if((rows[i]+cols[j])%2==1) count++;
			}
		}
		System.out.println(count);
	}
}