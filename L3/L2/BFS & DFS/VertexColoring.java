//Vertex Coloring

import java.util.*;

class VertexColoring{
	private int vertices;
	private List<Integer>[] adjacency;
	private int[] result;
	private  boolean[] available;
	
	public static void main(String[] args){
		VertexColoring v = new VertexColoring(4);
		v.addEdge(0,1);
		v.addEdge(0,2);
		v.addEdge(1,2);
		v.addEdge(1,3);
		v.addEdge(2,3);
		v.findColors();
	}
	
	VertexColoring(int vertices){
		this.vertices = vertices;
		adjacency= new ArrayList[vertices];
		result = new int[vertices];
		available = new boolean[vertices];
		for(int i=0;i<vertices;i++){
			adjacency[i] = new ArrayList<Integer>();
		}
		Arrays.fill(result,-1);
		Arrays.fill(available,true);
	} 
	
	void addEdge(int node1, int node2){
		adjacency[node1].add(node2);
		adjacency[node2].add(node1);
	}

	void findColors(){
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		result[0]=0;
		while(!q.isEmpty()){
			int cur = q.poll();
			for(int adj: adjacency[cur]){
				if(result[adj]!=-1){
					available[result[adj]]=false;
				}
				if(result[adj]==-1) q.add(adj);
			}
			int color;
			for(color=0;color<vertices;color++){
				if(available[color]) break;
			}
			result[cur]=color;
			Arrays.fill(available,true);
		}
		for(int i=0;i<vertices;i++){
			System.out.printf("Color of vertex %d is %d\n" ,i,result[i]);
		}
	}
	
}