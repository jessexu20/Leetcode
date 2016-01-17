public class WalkMatrix{
	public int walk(int [][] matrix){
		int [][] dp = new int [matrix.length][matrix[0].length];
		dp[0][0] = matrix[0][0];
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[0].length; j++){

				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + matrix[i][j];
			}
		}
		return dp[matrix.length-1][matrix[0].length-1];
	}
	
}