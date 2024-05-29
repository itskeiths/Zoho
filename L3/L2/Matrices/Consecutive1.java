/*6.Write a program to count the number of consecutive 1's formed by connecting adjacent 1's
horizontally in the 2D grid map of 0's and 1's.*/

class Consecutive1{
public static void main(String[] args){
int matrix[][] ={{0,0,1,1,0},{1,1,0,1,1},{0,1,1,1,0},{0,0,0,0,0},{0,1,1,0,1}};
int m = matrix.length;
int n = matrix[0].length;
int i=0,j=0;
int count=0;
while(i<m){
j=0;
while(j<n){
if(matrix[i][j]==1){
count++;
while(j<n && matrix[i][j]==1) j++;
}
j++;
}
i++;
}
System.out.println(count);
}
}