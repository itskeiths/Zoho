import java.util.*;
class BoggleBoard{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		List<String> ans = new ArrayList<>();
		System.out.println("Enter rows and columns:");
		int row = in.nextInt();
		int col = in.nextInt();
		char[][] board = new char[row][col];
		System.out.println("Enter the characters in board:");
		for(int i=0;i<row;i++)
		for(int j=0;j<col;j++) board[i][j]=in.next().charAt(0);
		System.out.println("Enter the number of words to search:");
		int n = in.nextInt();
		String[] words = new String[n];
		System.out.println("Enter words to search:");
		for(int i=0;i<n;i++) words[i]=in.next();
		for(int i=0;i<n;i++){
			if(isFound(board,words[i])) ans.add(words[i]);
		}
		System.out.println(ans);
	}
	
	public static boolean isFound(char[][] board, String word){
		Stack<int[]> s = new Stack<>();
		int[][] directions={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
		int m = board.length;
		int n = board[0].length;
		int[][] visited = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(board[i][j]==word.charAt(0)) {
					s.push(new int[]{i,j});
					visited[i][j]=1;
					break;
				}
			}
		}
		int pos=1;
		while(!s.isEmpty()){
			int[] cur = s.pop();
			int x = cur[0];
			int y = cur[1];
			if(pos==word.length()) return true;
			for(int[] dir:directions){
				int newX = x+dir[0];
				int newY = y+dir[1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && pos<word.length() && board[newX][newY]==word.charAt(pos) && visited[newX][newY]==0){
					s.push(new int[]{newX,newY});
					visited[newX][newY]=1;
					pos++;
				}
			}
		}	
		return pos==word.length();
	}
}