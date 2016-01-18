package google;

import java.util.*;

public class MatrixColor {
	public int countColor(char[][] matrix, int[] start) {
		int row = matrix.length;
		int col = matrix[0].length;
		int p = start[0], q = start[1];
		char cur = matrix[p][q];
		int total = 0;
		int[] idx = { -1, 1, 0, 0 };
		for (int i = 0; i < 4; i++) {
			int x = p + idx[i];
			int y = q + idx[4 - i - 1];
			if (x >= 0 && x < row && y >= 0 && y < col && matrix[x][y] != cur
					&& matrix[x][y] != '*') {
				char c = matrix[x][y];
				int color = helper(matrix, x, y);
				System.out.println("" + c + color);
				total += color;
			}
		}
		total += helper(matrix, p, q);
		return total;
	}

	private int helper(char[][] matrix, int i, int j) {
		Queue<int[]> que = new LinkedList<>();
		int[] s = { i, j };
		que.offer(s);
		int cnt = 1;
		char color = matrix[i][j];
		matrix[i][j] = '*';
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int[] idx = { -1, 1, 0, 0 };
			for (int k = 0; k < 4; k++) {
				int x = cur[0] + idx[k];
				int y = cur[1] + idx[4 - k - 1];
				if (x >= 0 && x < matrix.length && y >= 0
						&& y < matrix[0].length) {
					if (matrix[x][y] == color) {
						cnt++;
						que.offer(new int[] { x, y });
						matrix[x][y] = '*';
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board = { 
				{'r','g','g','y'},
				{'r','b','y','y'},
				{'b','b','g','g'},
				{'r','r','g','y'}};
		MatrixColor matrixColor = new MatrixColor();
		int [] start = {1,1};
		System.out.println(matrixColor.countColor(board, start));
	}

}
