/*
A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
We return the result as an array: [1, 1, 2, 3]

Challenge:

Can you do it in time complexity O(k log mn), where k is the length of the positions?
*/
public class NumberofIslandsII {
    int [][] matrix; 
    int count = 0;
    int [] union;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        matrix = new int [m][n];
        union = new int [m*n];
        List<Integer> result = new ArrayList();
         for(int i = 0; i < union.length; i++) union[i]=i;
        for(int i = 0; i < positions.length;i++){
            int temp = helper(positions[i][0],positions[i][1]);
            result.add(temp);
        }
        return result;
    }
    public int helper(int x, int y){
        matrix[x][y] = 1;
        count++;
        int cur = getIndex(x,y);
        if(x>0 && matrix[x-1][y]==1){
            if(union(cur,getIndex(x-1,y)))
                count--;
        }
        if(y>0 && matrix[x][y-1]==1){
            if(union(cur,getIndex(x,y-1)))
                count--;
        }
        if(x+1<matrix.length && matrix[x+1][y]==1){
            if(union(cur,getIndex(x+1,y)))
                count--;
        }
        if(y+1 < matrix[0].length && matrix[x][y+1]==1){
            if(union(cur,getIndex(x,y+1)))
                count--;
        }
        return count;
    }
    public int getIndex(int x, int y){
        return x * matrix[0].length + y;
    }
    public int find(int x){
        if(union[x]==x) return x;
        else return find(union[x]);
    }
    public boolean union(int i, int j){
        int x = find(i);
        int y = find(j);
        if(x==y) return false;
        if(x<y){
            union[x] = y;
        }
        else union[y] = x;
        return true;
    }
}