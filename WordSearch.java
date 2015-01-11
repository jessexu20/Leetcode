public class WordSearch{
	public boolean findNext(char[][] board, String word,int x,int y,int k){
		if((x+1<board[0].length && board[x+1][y]==word.charAt(k))
			el(y+1<board.length && board[x][y+1]==word.charAt(k))||
		(x-1>0 && board[x-1][y]==word.charAt(k)) ||(y-1 >0 && board[x][y-1]==word.charAt(k)){
			findNext(board,word,)
		}
		return true;
	}
    public boolean exist(char[][] board, String word) {
		if (board.length<1)
			return false;
		int n=board.length;
		int m=board[0].length;
		int tempx=-1;
		int tempy=-1;
		for(int i=0;i<n;i++){
			for (int j=0; j<m;j++){
				if(board[i][j]==word.charAt(0)){
					tempx=i;tempy=j;
					if(findNext(board,word,tempx,tempy,1))
						return true;
				}
			}
		}
        return false;
    }
	public static void main(String args[]){
		WordSearch ws=new WordSearch();
		char [][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="ABCCED";
		System.out.println(ws.exist(board,word));
	}
}