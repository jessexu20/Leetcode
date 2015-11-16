/*
Paint House My Submissions Question
Total Accepted: 2991 Total Submissions: 7508 Difficulty: Medium
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

*/
/*Paint House II
There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?

*/

public class PaintHouseMinCost {
    public int minCost(int[][] costs) {
        if(costs.length<1) return 0;
        int [][] dp = new int [costs.length][3];
        for(int i = 0;i<3;i++) dp[0][i]=costs[0][i];
        for(int i = 1; i < costs.length; i++){
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[costs.length-1][0],Math.min(dp[costs.length-1][1],dp[costs.length-1][2]));
    }
    public int minCostII(int[][] costs) {
        if(costs.length<1) return 0;
        int row = costs.length;
        int col = costs[0].length;
        int [][] dp = new int [row][col];
        for(int i = 0;i<col;i++) dp[0][i]=costs[0][i];
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                dp[i][j] = costs[i][j] + findMin(dp[i-1],j,true);
            }
        }
        return findMin(dp[row-1],0,false);
    }
    public int findMin(int [] nums, int index, boolean exclusive){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(exclusive && i==index) continue;
            min = Math.min(min,nums[i]);
        }
        return min;
    }
}