/*7.A storekeeper is a game in which the player pushes boxes around in a warehouse
trying to get them to target locations.
The game is represented by an m x n grid of characters grid where each element
is a wall, floor, or box.
Your task is to move the box 'B' to the target position 'T' under the following
rules:
The character 'S' represents the player. The player can move up, down, left,
right in grid if it is a floor (empty cell).
The character '.' represents the floor which means a free cell to walk.
The character '#' represents the wall which means an obstacle (impossible to
walk there).
There is only one box 'B' and one target cell 'T' in the grid.
The box can be moved to an adjacent free cell by standing next to the box and
then moving in the direction of the box. This is a push.
The player cannot walk through the box.
Return the minimum number of pushes to move the box to the target. If there is
no way to reach the target, return -1*/

import java.util.*;
class PushBox{
public static void main(String[] args){
char grid1[][]={{'#','#','#','#','#','#'},
	{'#','T','#','#','#','#'},
	{'#','.','.','B','.','#'},
	{'#','.','#','#','.','#'},
	{'#','.','.','.','S','#'},
	{'#','#','#','#','#','#'}};
char grid2[][]={{'#','#','#','#','#','#'},
	{'#','T','#','#','#','#'},
	{'#','.','.','B','.','#'},
	{'#','#','#','#','.','#'},
	{'#','.','.','.','S','#'},
	{'#','#','#','#','#','#'}};
char grid3[][]={{'#','#','#','#','#','#'},
	{'#','T','.','.','#','#'},
	{'#','.','#','B','.','#'},
	{'#','.','.','.','.','#'},
	{'#','.','.','.','S','#'},
	{'#','#','#','#','#','#'}};
printF(grid1);
System.out.println("Minimum number of paths to reach the target:"+ solve(grid1));
printF(grid2);
System.out.println("Minimum number of paths to reach the target:"+ solve(grid2));
printF(grid3);
System.out.println("Minimum number of paths to reach the target:"+ solve(grid3));

}

static int solve(char[][] grid){
int m = grid.length;
int n = grid[0].length;
int[][] visited = new int[m][n];
int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
Queue<int[]> q = new LinkedList<>();
int[][] steps = new int[m][n];
int[] target = new int[2];
int[] person = new int[2];
int foundt=0,foundb=0;
for(int i=0;i<m;i++){
if(foundt+foundb==3) break;
for(int j=0;j<n;j++){
if(grid[i][j]=='B') {
	q.offer(new int[]{i,j});
	visited[i][j]=1;
	foundb=1;
}
if(grid[i][j]=='T'){
	target[0]=i;
	target[1]=j;
	foundt=1;
}
}
}
while(!q.isEmpty()){
int[] cur = q.poll();
int x = cur[0];
int y = cur[1];
if(x==target[0] && y==target[1]) return steps[x][y];
for(int[] d:directions){
int newX = x+d[0];
int newY = y+d[1];
int sX = x-d[0];
int sY = y-d[1];
if(newX>=0 && newX<m && newY>=0 && newY<n
 && visited[newX][newY]==0 && grid[newX][newY]!='#' &&
sX>=0 && sX<m && sY>=0 && sY<n && grid[sX][sY]!='#') {
	visited[newX][newY]=1;
	q.offer(new int[]{newX,newY});
	steps[newX][newY]=1+steps[x][y];
}
}
}
return -1;
}

static void printF(char[][]grid){
	for(int i=0;i<grid.length;i++){
	for(int j=0;j<grid[0].length;j++) System.out.print(grid[i][j]+" ");
	System.out.println();
}
System.out.println();
}
}