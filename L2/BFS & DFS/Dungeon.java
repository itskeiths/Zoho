import java.util.*;
class Dungeon{
	static List<int[]> sp = new ArrayList<>();
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter dimensions:");
		int row = in.nextInt();
		int col = in.nextInt();
		System.out.println("Enter Position of adventerer:");
		int startx = in.nextInt();
		int starty = in.nextInt();
		startx--;
		starty--;
		System.out.println("Enter Position of Monster:");
		int monsterx = in.nextInt();
		int monstery = in.nextInt();
		monsterx--;
		monstery--;
		System.out.println("Enter Position of trigger:");
		int triggerx = in.nextInt();
		int triggery = in.nextInt();
		triggerx--;
		triggery--;
		System.out.println("Enter Position of Gold:");
		int targetx = in.nextInt();
		int targety = in.nextInt();
		targetx--;
		targety--;
		int[][] pits = new int[row][col];
		List<int[]> shortestpath = new ArrayList<>();
		System.out.println("Enter the number of pits");
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			System.out.println("Enter position "+(i+1)+":"); 
			pits[in.nextInt()-1][in.nextInt()-1]=1;
		}
		int[][] empty = new int[row][col];
		int patha=bfs(startx,starty,targetx,targety,row,col,pits);
		shortestpath = sp;
		
		int pathm=bfs(monsterx,monstery,targetx,targety,row,col,empty);
		int path=0;
		if(patha<=pathm){
			System.out.println("Minimum steps to reach gold: "+patha);
		}
		else{
			int pathatot=bfs(startx,starty,triggerx,triggery,row,col,pits);
			shortestpath = sp;
	
			int pathmtot=bfs(monsterx,monstery,triggerx,triggery,row,col,empty);
			if(pathatot<=pathmtot){
				path = bfs(triggerx,triggery,targetx,targety,row,col,pits)+pathatot;
				sp.remove(0);
				shortestpath.addAll(sp);
				System.out.println("Minimum steps to reach gold: "+path);
			}
			else System.out.println("Not Possible");
		}
		for(int[] arr:shortestpath){
			System.out.print("("+(arr[0]+1)+","+(arr[1]+1)+")"+"-> ");
		}
	}
	
	static int bfs(int startx, int starty,int targetx, int targety,int row, int col,int[][] pits){
		sp.clear();
		int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
		int[][] movpath = new int[row][col];
		for(int[] rows: movpath) Arrays.fill(rows,-1);
		Queue<int[]> q = new LinkedList<>();
		movpath[startx][starty]=0;
		q.offer(new int[]{startx,starty});
		int path=0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			if(x==targetx && y==targety){
				int[] current = new int[]{x,y};
				 while (movpath[current[0]][current[1]] != 0) {
					sp.add(0, current);
					for (int[] dir : directions) {
                    int newX = current[0] - dir[0];
                    int newY = current[1] - dir[1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col &&
                            movpath[newX][newY] == movpath[current[0]][current[1]] - 1) {
                        current = new int[]{newX, newY};
                        break;
                    }
                }
			}
			sp.add(0, new int[]{startx, starty}); 
			break;
			}
			for(int[] dir:directions){
				int newX = x+dir[0];
				int newY = y+dir[1];
			if(newX>=0 && newX<row && newY>=0 && newY<col && movpath[newX][newY]==-1 && pits[newX][newY]==0){
				q.offer(new int[]{newX,newY});
				path=1+movpath[x][y];
				movpath[newX][newY]=path;
			}
		}

	}
			
	return movpath[targetx][targety];
	}
}