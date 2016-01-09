import java.util.*;
public class CandyCrush{
	int [][] board;
	int num;
	public CandyCrush(int [][]table, int number){
		// if(m < 3 || n < 3 || num < 1)
		// 	return;
		board = table;
		num = number;
		init();
		show();
	}
	private void init(){
		int [] pos = new int [2];
		pos = fill();
		System.out.println(pos[0]+"\t"+pos[1]);
		boolean [][] visited = new boolean [board.length][board[0].length];
		Queue<int []> que = new LinkedList<>();
		que.offer(pos);
		while(!que.isEmpty()){
			int [] cur = new int[2];
			cur = que.poll();
			int curx = cur[0];
			int cury = cur[1];

			if(curx>0 && !visited[curx-1][cury]){
				if(board[curx-1][cury]==-1){
					board[curx-1][cury] = nextNumber(curx-1,cury);
				}
				int [] next = {curx-1,cury};
				que.offer(next);	
				visited[curx-1][cury] = true;
			}
			if(curx<board.length-1 && !visited[curx+1][cury]){
				if(board[curx+1][cury]==-1){
					board[curx+1][cury] = nextNumber(curx+1,cury);
				}
				int [] next = {curx+1,cury};
				que.offer(next);
				visited[curx+1][cury] = true;	
			}
			if(cury>0 && !visited[curx][cury-1]){
				if(board[curx][cury-1]==-1){
					board[curx][cury-1] = nextNumber(curx,cury-1);
				}
				int [] next = {curx,cury-1};
				que.offer(next);	
				visited[curx][cury-1] = true;
			}
			if(cury<board[0].length-1 && !visited[curx][cury+1]){
				if(board[curx][cury+1]==-1){
					board[curx][cury+1] = nextNumber(curx,cury+1);
				}
				int [] next = {curx,cury+1};
				que.offer(next);
				visited[curx][cury+1] = true;	
			}
		}
	
	}
	private int nextNumber(int curx, int cury){
		int curNumber = pattern();
		while(!check(curx,cury,curNumber))
			curNumber = pattern();
		return curNumber;
	}
	private boolean check(int x, int y, int number){
		if(x > 0 && number == board[x-1][y]) return false;
		if(y > 0 && number == board[x][y-1]) return false;
		if(x < board.length-1 && number == board[x+1][y]) return false;
		if(y < board[0].length-1 && number == board[x][y+1]) return false;
		return true;
	}
	private int[] fill(){
		Random random = new Random();
		int row = random.nextInt(this.num);
		int col = random.nextInt(this.num);
		while(row + 4 > board.length && col+4> board[0].length)
			row = random.nextInt(this.num);
		if(row +4 <= board.length)
			rowFill(row,col);
		else colFill(row,col);
		int [] result = {row,col};
		return result;
	}
	private void rowFill(int x, int y){
		Random random = new Random();
		int number = pattern();
		int diff = pattern();
		while(diff==number)
			diff = pattern(); 
		for(int i = x; i < x+4;i++){
			board[i][y] = number;
		}
		board[x+2][y] = diff;
	}
	private void colFill(int x, int y){
		Random random = new Random();
		int number = pattern();
		int diff = pattern();
		while(diff==number)
			diff = pattern(); 
		for(int i = y; i < y+4;i++){
			board[x][i] = number;
		}
		board[x][y+2] = diff;
	}
	private int pattern(){
		Random random = new Random();
		return random.nextInt(this.num);
	}
	public void show(){
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int [][] board = new int[10][10];
		for(int i = 0; i < 10; i++){
			Arrays.fill(board[i],-1);
		}
		CandyCrush cc = new CandyCrush(board,4);
		
		// cc.show();
	}
}