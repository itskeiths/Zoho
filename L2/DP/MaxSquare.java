import java.util.Scanner;
class MaxSquare{
public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Enter rows and columns:");
	int R = in.nextInt();
	int C = in.nextInt();
	System.out.println("Enter elements of matrix:");
	int[][] mat = new int[R][C];
	for(int i=0;i<R;i++) for(int j=0;j<C;j++) mat[i][j]=in.nextInt();
	int[][] temp = new int[R][C];
	for(int i=0;i<R;i++) temp[i][0]=mat[i][0];
	for(int j=0;j<C;j++) temp[0][j]=mat[0][j];
	for(int i=1;i<R;i++){
		for(int j=1;j<C;j++){
			if(mat[i][j]==1){
				temp[i][j]=Math.min(temp[i][j-1],Math.min(temp[i-1][j-1],temp[i-1][j]))+1;
			}
			else temp[i][j]=0;
		}
	}
	int maxS = mat[0][0];
	int maxR = 0, maxC=0;
	for(int i=0;i<R;i++){
		for(int j=0;j<C;j++){
			if(maxS<temp[i][j]){
				maxS = temp[i][j];
				maxR = i;
				maxC = j;
			}
		}
	}
	
System.out.println(maxS);
	
	/*for(int i=maxR;i>maxR-maxS;i--){
		for(int j=maxC;j>maxC-maxS;j--){
			System.out.print(mat[i][j]+" ");
		}
		System.out.println();
	}*/
}
}