import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
public class SurroundedRegions{
	public void findSide(char[][] board,List<List<Integer>> position){
		for(int i=0;i<board[0].length;i++){
			if(board[0][i]=='O'){
				List<Integer> pos=new ArrayList();
				pos.add(0);pos.add(i);
				position.add(pos);
			}
			if(board[board.length-1][i]=='O'){
				List<Integer> pos=new ArrayList();
				pos.add(board.length-1);pos.add(i);
				position.add(pos);
			}
		}
		for(int i=0;i<board.length;i++){
			if(board[i][0]=='O'){
				List<Integer> pos=new ArrayList();
				pos.add(i);pos.add(0);
				position.add(pos);
			}
			if(board[i][board[0].length-1]=='O'){
				List<Integer> pos=new ArrayList();
				pos.add(i);pos.add(board[0].length-1);
				position.add(pos);
			}
		}
	}
	public void findInside(char[][] board,List<List<Integer>> position){
		for(int i=1;i<board.length-1;i++){
			for(int j=1;j<board[0].length-1;j++){
				if(board[i][j]=='O' ){
					List<Integer> pos=new ArrayList();
					pos.add(i);pos.add(j);
					position.add(pos);
				}
			}
		}
	}
	public void solve(char[][] board) {
        if(board.length<=2)
			return;
		int height=board.length;
		int length=board[0].length;
		Queue <List<Integer>> queue=new LinkedList();
		boolean [][] mark= new boolean[height][length];
		List<List<Integer>> side=new ArrayList();
		List<List<Integer>> inside=new ArrayList();
		findSide(board,side);
		findInside(board,inside);
		queue.addAll(side);
		for(List<Integer> list:side){
			int x=list.get(0);
			int y=list.get(1);
			mark[x][y]=true;
		}
		while(!queue.isEmpty()){
			List<Integer> temp=queue.poll();
			int x=temp.get(0);
			int y=temp.get(1);
			if(y!=board[0].length-1 && board[x][y+1]=='O' && mark[x][y+1]==false){
				List<Integer> t=new ArrayList();
				t.add(x);t.add(y+1);
				queue.offer(t);
				side.add(t);
				mark[x][y+1]=true;
			}
			if(y!=0 && board[x][y-1]=='o'&& mark[x][y-1]==false){
				List<Integer> t=new ArrayList();
				t.add(x);t.add(y-1);
				queue.offer(t);
				side.add(t);
				mark[x][y-1]=true;
			}
			if(x!= board.length-1 &&board[x+1][y]=='O'&& mark[x+1][y]==false){
				List<Integer> t=new ArrayList();
				t.add(x+1);t.add(y);
				queue.offer(t);
				side.add(t);
				mark[x+1][y]=true;
			}
			if(x!=0 && board[x-1][y]=='O'&& mark[x-1][y]==false){
				List<Integer> t=new ArrayList();
				t.add(x-1);t.add(y);
				queue.offer(t);
				side.add(t);
				mark[x-1][y]=true;
			}
		}
		inside.removeAll(side);
		for(List<Integer> list:inside){
			int x=list.get(0);
			int y=list.get(1);
			board[x][y]='X';
		}
    }
	public static void main(String args[]){
		char[][] box={{'X','X','X','X','X'},
					  {'X','O','X','O','X'},
				      {'X','X','O','O','O'},
					  {'X','O','O','X','O'}
					};
		SurroundedRegions sr=new SurroundedRegions();
		sr.solve(box);
		for(int i=0;i<box.length;i++){
			for(int j=0;j<box[0].length;j++){
				System.out.print(box[i][j]);
			}
			System.out.println();
		}
	}
}
