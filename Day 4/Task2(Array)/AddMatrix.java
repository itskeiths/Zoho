/*.Write a Java program to add two matrices of the same size.*/

class AddMatrix{
public static void main(String[] args){
int mat1[][] ={{1,2,3},{4,5,6},{7,8,9}};
int mat2[][] ={{1,2,3},{4,5,6},{7,8,9}};
int m = mat1.length;
int n = mat2.length;
int result[][] = new int[m][n];
for(int i=0;i<m;i++){
for(int j=0;j<n;j++) System.out.print(mat1[i][j]+mat2[i][j]+"  ");
System.out.println();
}

}
}