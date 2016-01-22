public class SudokuSolver {
	HashMap<Integer,HashSet<Character>> rows=new HashMap();
	HashMap<Integer,HashSet<Character>> cols=new HashMap();
	HashMap<Integer,HashSet<Character>> blocks=new HashMap();
	public boolean notValid(int i,int j,char c){
		return rows.get(i).contains(c)||cols.get(j).contains(c)||blocks.get(i/3*3+j/3).contains(c);
	}
	public boolean solve(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				char c= board[i][j];
				if(c=='.'){
					for(char k='1';k<='9';k++){
						if(!notValid(i,j,k)){
							board[i][j]=k;
							rows.get(i).add(k);
							cols.get(j).add(k);
							blocks.get(i/3*3+j/3).add(k);
							if(solve(board))
								return true;
							else{
								board[i][j]='.';
								rows.get(i).remove(k);
								cols.get(j).remove(k);
								blocks.get(i/3*3+j/3).remove(k);
							}
								
						}
					}
					return false;
				}

			}
		}
		return true;
	}
    public void solveSudoku(char[][] board) {
		for(int i=0;i<9;i++){
			rows.put(i,new HashSet<Character>());
			cols.put(i,new HashSet<Character>());
			blocks.put(i,new HashSet<Character>());
		}
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!='.'){
					rows.get(i).add(board[i][j]);
					cols.get(j).add(board[i][j]);
				}
			}
		}
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(board[i][j]!='.'){
					blocks.get(i/3*3+j/3).add(board[i][j]);
				}
			}
		}
		solve(board);

    }
	public static void main(String args[]){
		SudokuSolver ss=new SudokuSolver();
		char [][] board= new char [9][9];
		board={["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]}
		ss.solveSudoku();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}
}