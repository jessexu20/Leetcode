/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
*/
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) 
                    q.offer(new int[] {i,j});
            }
        }
        
        while (!q.isEmpty()) {
            // get current node's neighbors
            int[] cur = q.poll();
            int[][] neighbors = { {cur[0]-1, cur[1]}, {cur[0]+1, cur[1]}, {cur[0], cur[1]-1}, {cur[0], cur[1]+1} };
            
            for (int[] nei : neighbors) {
                if (nei[0] < 0 || nei[0] >= rooms.length || nei[1] < 0 || nei[1] >= rooms[0].length 
                        || rooms[nei[0]][nei[1]] <= rooms[cur[0]][cur[1]] + 1)
                    continue;
                q.offer(new int[]{nei[0], nei[1]});
                rooms[nei[0]][nei[1]] = rooms[cur[0]][cur[1]] + 1;
            }
        }
    }
}