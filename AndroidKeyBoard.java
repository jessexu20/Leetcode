package google;

import java.util.*;

public class AndroidKeyBoard {
	char[][] board = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

	public List<String> generate() {
		// Set<String> result = new HashSet<String>();
		List<String> result = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				helper(result, "", i, j);
			}
		}
		System.out.println(result.size());
		return result;
	}

	private void helper(List<String> result, String temp, int x, int y) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
				|| board[x][y] == '*')
			return;

		char t = board[x][y];

		temp += board[x][y];
		if (temp.length() >= 4) {
			result.add(temp);
		}

		board[x][y] = '*';
		helper(result, temp, x - 1, y + 1);

		// 8 directional
		helper(result, temp, x - 1, y - 1);
		helper(result, temp, x - 1, y);
		helper(result, temp, x, y - 1);
		helper(result, temp, x, y + 1);
		helper(result, temp, x + 1, y + 1);
		helper(result, temp, x + 1, y);
		helper(result, temp, x + 1, y - 1);

		// cross!
		helper(result, temp, x - 2, y - 1);
		helper(result, temp, x + 2, y - 1);
		helper(result, temp, x - 2, y + 1);
		helper(result, temp, x + 2, y + 1);

		helper(result, temp, x + 1, y - 2);
		helper(result, temp, x - 1, y - 2);
		helper(result, temp, x + 1, y + 2);
		helper(result, temp, x - 1, y + 2);

		// allow jump
		if (x + 1 < board.length && board[x + 1][y] == '*')
			helper(result, temp, x + 2, y);
		if (y + 1 < board[0].length && board[x][y + 1] == '*')
			helper(result, temp, x, y + 2);
		if (x > 0 && board[x - 1][y] == '*')
			helper(result, temp, x - 2, y);
		if (y > 0 && board[x][y - 1] == '*')
			helper(result, temp, x, y - 2);
		if (x > 0 && y > 0 && board[x - 1][y - 1] == '*')
			helper(result, temp, x - 2, y - 2);
		if (x + 1 < board.length && y + 1 < board[0].length
				&& board[x + 1][y + 1] == '*')
			helper(result, temp, x + 2, y + 2);
		if (x > 0 && y + 1 < board[0].length && board[x - 1][y + 1] == '*')
			helper(result, temp, x - 2, y + 2);
		if (x + 1 < board.length && y > 0 && board[x + 1][y - 1] == '*')
			helper(result, temp, x + 2, y - 2);
		board[x][y] = t;
	}

	public static void main(String args[]) {
		AndroidKeyBoard android = new AndroidKeyBoard();
		android.generate();
	}
}