public class DungeonGame {
		//     public int calculateMinimumHP(int[][] dungeon) {
		// int row=dungeon.length;
		// if(row<1)
		// 	return 0;
		// int col=dungeon[0].length;
		// int [][]dp=new int [row][col];
		// dp[row-1][col-1]=Math.max(1-dungeon[row-1][col-1], 1);
		// for(int i=row-2;i>=0;i--){
		// 	dp[i][col-1]=Math.max(1,dp[i+1][col-1]-dungeon[i][col-1]);
		// }
		// for(int i=col-2;i>=0;i--){
		// 	dp[row-1][i]=Math.max(1,dp[row-1][i+1]-dungeon[row-1][i]);
		// }
		//         for(int i=row-2;i>=0;i--){
		//         	for(int j=col-2;j>=0;j--){
		// 		dp[i][j]=Math.max(1,Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j]);
		//         	}
		//         }
		//         for(int i=0;i<row;i++){
		//         	for(int j=0;j<col;j++){
		//         		System.out.print(dp[i][j]+"\t");
		//         	}
		// 	System.out.println();
		//         }
		// return dp[0][0];
		//     }
    public int calculateMinimumHP(int[][] dungeon) {
        int column = dungeon.length;
        int row = dungeon[0].length;
        int[][] dp = new int[column][row];
        dp[column-1][row-1] = Math.max(1-dungeon[column-1][row-1], 1);

        for(int i=column-2; i>=0; i--) {
            dp[i][row-1] = Math.max(1, dp[i+1][row-1]-dungeon[i][row-1]);
        }
        for(int j=row-2; j>=0; j--) {
            dp[column-1][j] = Math.max(1, dp[column-1][j+1]-dungeon[column-1][j]); 
        }
        for(int i=column-2; i>=0; i--) {
            for(int j=row-2; j>=0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j]-dungeon[i][j], dp[i][j+1]-dungeon[i][j]));
            }
        }
        return dp[0][0];
    }
	public static void main(String args[]){
		DungeonGame dg= new DungeonGame();
		// int [][] matrix={
		// 	{-2,-3,3},
		// 	{-5,-10,1},
		// 	{10,30,-5}
		// };
		int [][]matrix={
			{1},{-5}
		};
		System.out.println(dg.calculateMinimumHP(matrix));
	}
}