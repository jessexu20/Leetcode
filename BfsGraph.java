package graph;

import java.util.;
public class BfsGraph{
	public void bfs(int [][]matrix,boolean[] mark, int source){
		Queue <Integer> queue= new LinkedList();
		mark[source]=true;
		queue.offer(source);
		while(!queue.isEmpty()){
			int v=queue.poll();
			System.out.println(v);
			for(int i=0;i<matrix.length;i++){
				if(matrix[v][i]==1 && mark[i]==false){
					queue.offer(i);
					mark[i]=true;
				}
					
			}
		}
	}
	public static void main(String args[]){
		BfsGraph bg=new BfsGraph();
		int [][]matrix={{1,0,1,0,1},{0,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1},{1,0,0,1,1}};
		boolean[] mark= new boolean[matrix.length];
		// for(boolean i: mark) System.out.println(i);
		// for(int i=0;i<matrix.length;i++){
		// 	for(int j=0;j<matrix[0].length;j++){
		// 		System.out.print(matrix[i][j]);
		// 		System.out.print('\t');
		// 	}
		// 	System.out.println();
		// }
		bg.bfs(matrix,mark,0);
	}
}