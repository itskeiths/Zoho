/*5.Write a program to count the number of 1's in the 2D grid map of 0's and 1's.*/

class Count1{
public static void main(String[] args){
int matrix[][]={{1,0,1},{0,1,0},{1,1,0}};
int count = 0;
int m = matrix.length, n= matrix[0].length;
for(int i=0;i<m;i++)
for(int j=0;j<n;j++) 
if(matrix[i][j]==1) count++;
System.out.println("Number of 1's :"+count);
}
}