package leetcode;

import java.util.HashMap;

public class ValidSudoku {
	public boolean check(char[][] mini,int x1,int x2,int y1,int y2) {//x->row,y->col
		HashMap map=new HashMap();
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (map.containsKey(mini[i][j])) {
					return false;
				}
				else{
					if (mini[i][j]!='.') {
						map.put(mini[i][j], 'Y');
					}
				}
			}
		}
		// System.out.println(map);
		return true;
	}
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!check(board,i,i+1,0,9)) return false;
			if (!check(board, 0, 9, i, i+1))	return false;
		}
		for(int i=0;i<board.length;i+=3){
			for(int j=0;j<board.length;j+=3){
				if(!check(board,i,i+3,j,j+3)) return false;
			}
		}
		return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-g	enerated method stub
		String[]str={".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		char [][]board=new char[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j]=str[i].charAt(j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		ValidSudoku vsSudoku=new ValidSudoku();
		System.out.println(vsSudoku.isValidSudoku(board));
	}

}
