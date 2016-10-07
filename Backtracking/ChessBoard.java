public class ChessBoard{
	int [][] matrix = new int[8][8];
	public boolean move(int x, int y){
		print();
		if(helper(x,y,1))
			return true;
		else
			return false;
	}
	public boolean helper(int x, int y, int cnt){
		if(cnt == 1 + 64 )
			return true;
		if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y]!=0)
			return false;
		
		
		int [] index = {2,-2,2,-2,1,-1,-1,1};
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		for(int i = 0; i < 8; i++){
			matrix[x][y] = cnt;
			int newX = x + xMove[i];
			// int newY = y + index[7 - i];
			int newY = y + yMove[i];
			if(helper(newX, newY, cnt+1))
				return true;
			else
				matrix[x][y] = 0;
		}
		return false;
	}
	public void print(){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String [] args){
		ChessBoard cb = new ChessBoard();
		// System.out.println(cb.move(0,0));
		cb.print();
		int [] index = {2,-2,2,-2,1,-1,-1,1};
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
		for(int i =0; i < 8; i++){
			System.out.print("\t"+index[i] + "\t" + index[7-i]);
		}
		System.out.println();
		for(int i =0; i < 8; i++){
			System.out.print("\t"+xMove[i] + "\t" + yMove[i]);
		}
		
	}
}