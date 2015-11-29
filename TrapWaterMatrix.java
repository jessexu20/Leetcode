import java.util.*;
class Cell{
	int x;
	int y;
	int h;
	Cell(int x, int y, int h){
		this.x = x;
		this.y = y;
		this.h = h;
	}
}
public class TrapWaterMatrix{
	public int trap(int [][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		boolean [][] visited = new boolean [row][col];
		Queue<Cell> que = new PriorityQueue<Cell>(10,new Comparator<Cell>(){
			public int compare(Cell c1, Cell c2){
				return c1.h - c2.h;
			}
		});
		for(int i = 0; i < col; i++){
			if(!visited[0][i])
				que.offer(new Cell(0,i,matrix[0][i]));
			visited[0][i]= true;
			if(!visited[row-1][i])
				que.offer(new Cell(row-1,i,matrix[row-1][i]));
			visited[row-1][i]= true;
		}
		for(int i = 0; i < row; i++){
			if(!visited[i][0])
				que.offer(new Cell(i,0,matrix[i][0]));
			visited[i][0]= true;
			if(!visited[i][col-1])
				que.offer(new Cell(i,col-1,matrix[i][col-1]));
			visited[i][col-1] = true;
		}
		int count = 0;
		int [] index = {-1,1,0,0};
		while(!que.isEmpty()){
			Cell cur = que.poll();
			for(int i = 0; i < 4; i++){
				int newX = cur.x + index[i];
				int newY = cur.y + index[3-i];
				if((newX < 0 || newY < 0 || newX >= row || newY >= col) || visited[newX][newY])
					continue;
				Cell c = new Cell(newX,newY,matrix[newX][newY]);
				if(cur.h > c.h){
					count+=(cur.h-c.h);
					c.h = cur.h;
				}
				visited[newX][newY] = true;
				que.offer(c);
			}
		}
		return count;
		
	}
	public static void main(String args[]){
		TrapWaterMatrix t = new TrapWaterMatrix();
		int [][] matrix = {{12,13,0,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
		System.out.println(t.trap(matrix));
	}
}