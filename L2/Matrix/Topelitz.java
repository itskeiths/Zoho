class Topelitz{
	public static void main(String[] args){
		//int[][] mat = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		int[][] mat = {{1,2},{2,2}};
		for(int i=0;i<1;i++){
			for(int j=0;j<mat[0].length;j++){
				if(!checkDiagonal(mat,i,j)){
					System.out.println("Not Topelitz");
					return;
				}
			}
		}
		for(int i=1;i<mat.length;i++){
			if(!checkDiagonal(mat,i,0)){
					System.out.println("Not Topelitz");
					return;
				}
		}
		System.out.println("Topelitz matix");
	}
	
	static boolean checkDiagonal(int[][] mat ,int row ,int col){
		int ele = mat[row][col];
		int i=row,j=col;
		while(i<mat.length){
			if(j<mat[0].length){
				if(ele!=mat[i][j]) return false;
			}
			i++;
			j++;
		}
		return true;
	}
}