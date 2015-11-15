public class FindLongestPath{
	int max = Integer.MIN_VALUE;
	int [][] distance;
	public int findPath(int [][] matrix){
		distance = new int [matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				helper(matrix,i,j);
			}
		}
		return max;
	}
	public void helper(int [][] matrix,int i, int j){
		distance[i][j] = 1;
		int l = 0, r = 0, u = 0, d = 0;
		if(i>0 && matrix[i-1][j]==matrix[i][j]+1){
			if(distance[i-1][j]!=0) u = distance[i-1][j];
			else{
				helper(matrix,i-1,j);
				u = distance[i-1][j];
			}
		}
		if(i+1 < matrix.length && matrix[i+1][j]== matrix[i][j]+1){
			if(distance[i+1][j]!=0) d = distance[i+1][j];
			else{
				helper(matrix,i+1,j);
				u = distance[i+1][j];
			}
		}
		if(j>0 && matrix[i][j-1]==matrix[i][j]+1){
			if(distance[i][j-1]!=0) l = distance[i][j-1];
			else{
				helper(matrix,i,j-1);
				l = distance[i][j-1];
			}
		}
		if(j+1 < matrix[0].length && matrix[i][j+1]== matrix[i][j]+1){
			if(distance[i][j+1]!=0) r = distance[i][j+1];
			else{
				helper(matrix,i,j+1);
				r = distance[i][j+1];
			}
		}
		distance[i][j] = Math.max(distance[i][j],1+Math.max(Math.max(l,r),Math.max(u,d)));
		max = Math.max(max,distance[i][j]);
	}
	public static void main(String args[]){
		FindLongestPath fp = new FindLongestPath();
		int [][] matrix = {{7,8,6},{9,4,5},{2,3,1}};
		System.out.println(fp.findPath(matrix));
	}
}