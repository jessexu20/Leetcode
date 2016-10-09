/*
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

    1 - 0 - 2 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

Hide Company Tags Google Zenefits
Hide Tags Breadth-first Search
Hide Similar Problems (M) Walls and Gates (H) Best Meeting Point

*/
import java.util.*;
class Point{
	int x;
	int y;
	Point(int a, int b){
		x = a;
		y = b;
	}
}
public class ShortestDistanceAllBuildings{
	public int shortestDistance(int [][] grid){
		int [][] dist = new int [grid.length][grid[0].length];
		int value = 0;//value of the number of 1s 
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j]==1){
					int [][] temp = new int [grid.length][grid[0].length];
					Queue<Point> que = new LinkedList<>();
					que.offer(new Point(i,j));
					while(!que.isEmpty()){
						Point cur = que.poll();
						int [] pos = {1,-1,0,0};
						for(int k = 0; k < 4; k++){
							int nextX = cur.x + pos[k];
							int nextY = cur.y + pos[3-k];
							if(nextX >=0 && nextY>=0 && nextX < grid.length && nextY < grid[0].length && grid[nextX][nextY] == value){
								grid[nextX][nextY]--;
								temp[nextX][nextY] = temp[cur.x][cur.y]+1;
								dist[nextX][nextY] += temp[nextX][nextY];
								que.offer(new Point(nextX,nextY));
							}
						}
					}
					value--;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j <grid[0].length; j++){
				if(grid[i][j]==value && dist[i][j]<min){
					min = dist[i][j];
				}
			}
		}
		return min == Integer.MAX_VALUE ? -1: min;
	}
	public static void main(String args[]){
		ShortestDistanceAllBuildings sdab = new ShortestDistanceAllBuildings();
		int [][] grid = new int [3][5];
		grid[0][0] = 1;grid[0][4] = 1;grid[2][2] = 1;
		grid[0][2] = 2;
		System.out.println(sdab.shortestDistance(grid));
	}
}