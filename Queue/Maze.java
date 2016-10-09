import java.util.*;
//给了个迷宫用小球走，每次确定一个方向之后小球会一直走到碰到障碍物或者边界才会停下，如果停下的地方恰好是出口就算出去了。再他提示下我算是想出来了要新建一个和迷宫同样大小的matrix，先遍历整个图两遍，把每个空位上下左右的障碍物的位置都存到那个点的array里，然后再用bfs就可以直接读到从任意一个点出发小球能停到的位置，这样可以降低时间复杂度。然后我写了一次遍历这张图要用的code和完成预处理之后再做BFS所用的code，
class Point{
	boolean block;
	Point[] arr = new Point[4];
	Point(){
		block = false;
	}
}
public class Maze{
	public int minStep(int [][] matrix, int st_x,int st_y, int e_x, int e_y){
		if(matrix.length < 1)
			return -1;
		Point [][] map = init(matrix);
		Queue<Point> que = new LinkedList<Point>();
		Set<Point> visited = new HashSet<>();
		visited.add(map[st_x][st_y]);
		que.offer(map[st_x][st_y]);
		int cnt = 0;
		if(st_x==e_x && st_y == e_y)
			return cnt;
		while(!que.isEmpty()){
			int size = que.size();
			cnt++;
			for(int i = 0; i < size; i++){
				Point p = que.poll();
				for(Point t: p.arr){
					if(t==map[e_x][e_y])
						return cnt;
					if(t!=null && !t.block && visited.add(t)){
						que.offer(t);
					}
				}
			}
		}
		return -1;
	}
	public Point[][] init(int [][] matrix){
		Point [][] map = new Point [matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				map[i][j] = new Point();
			}
		}
		for(int i = 0; i < matrix.length; i++){
			int j = 0, k = 0;
			while(j < matrix[0].length){
				while(j < matrix[0].length && matrix[i][j]==0)
					j++;
				for(int t = k; t < j; t++){
					map[i][t].arr[0] = map[i][k];//left boundary
					map[i][t].arr[1] = map[i][j-1]; //right boundary
				}
				while(j < matrix[0].length && matrix[i][j] == 1){
					map[i][j].block = true;
					j++;
				}
				k = j;
			}
		}
		for(int i = 0; i < matrix[0].length; i++){
			int j = 0, k = 0;
			while(j < matrix.length){
				while(j < matrix.length && matrix[j][i]==0)
					j++;
				for(int t = k; t < j; t++){
					map[t][i].arr[2] = map[k][i];//up boundary
					map[t][i].arr[3] = map[j-1][i];//down boundary
				}
				while(j < matrix.length && matrix[j][i] == 1){
					map[j][i].block = true;
					j++;
				}
				k = j;
			}
		}
		return map;
	}
	public static void main(String args[]){
		int [][] matrix = {{0,0,0,0,0,1},{0,0,1,0,0,0},{1,0,0,0,0,0},{0,0,1,0,0,0}};
		Maze maze = new Maze();
		System.out.println(maze.minStep(matrix,0,0,3,5));
	}
}