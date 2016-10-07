import java.util.*;
public class KnightMove{
	//NOTE: GOOGLE INTERVIEW has another matrix called cost which make it even complicated.
	int [][] matrix;
	int row;
	int col;
	KnightMove(int [][] map){
		if(map.length < 1)
			return;
		row = map.length;
		col = map[0].length;
		matrix = map;
	}
	public int move(int [] start, int [] end){
		Queue<int[]> que = new LinkedList<>();
		que.offer(start);
		int dist = 1;
		while(!que.isEmpty()){
			int size = que.size();
			for(int i = 0; i < size; i++){
				int [] cur = que.poll();
				int [] arr = {2,-2,2,-2,-1,1,1,-1};
				for(int j = 0; j < 8; j++){
					int cur_x = cur[0] + arr[j];
					int cur_y = cur[1] + arr[7-j];
					if(cur_x < row && cur_x >=0 && cur_y < col && cur_y >=0 && matrix[cur_x][cur_y] == 0){
						if(cur_x ==end[0] && cur_y == end[1])
							return dist;
						else{
							que.offer(new int [] {cur_x, cur_y});
							matrix[cur_x][cur_y] = -1;
						}
					}
				}
			}
		}
		return -1;
	}
}