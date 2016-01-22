public class DfsGraph{
	public void dfs(int [][]matrix,boolean[] mark, int source){
		System.out.println(source);
		mark[source]=true;
		for(int i=0; i<matrix.length;i++){
			if(matrix[source][i]==1){
				if(!mark[i])
					dfs(matrix,mark,i);
			}
		}
	}
	public static void main(String args[]){
		DfsGraph dg=new DfsGraph();
		int [][]matrix={{1,0,1,0,1},{0,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1},{1,0,0,1,1}};
		boolean[] mark= new boolean[matrix.length];
		for(boolean i: mark) System.out.println(i);
		// for(int i=0;i<matrix.length;i++){
		// 	for(int j=0;j<matrix[0].length;j++){
		// 		System.out.print(matrix[i][j]);
		// 		System.out.print('\t');
		// 	}
		// 	System.out.println();
		// }
		dg.dfs(matrix,mark,0);
	}
}