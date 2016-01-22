package google;

public class SummableTable {
	int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	int[][] single = new int[matrix.length][matrix[0].length];
	int[][] agg = new int[matrix.length][matrix[0].length];

	public SummableTable() {
		// TODO Auto-generated constructor stub
		// init sum
		for (int i = 0; i < single.length; i++) {
			single[i][0] = matrix[i][0];
			if (i > 0)
				single[i][0] += single[i - 1][0];
		}
		for (int i = 0; i < single[0].length; i++) {
			single[0][i] = matrix[0][i];
			if (i > 0)
				single[0][i] += single[0][i - 1];
		}
		for (int i = 1; i < single.length; i++) {
			for (int j = 1; j < single[0].length; j++) {
				single[i][j] = matrix[i][j] + single[i - 1][j]
						+ single[i][j - 1] - single[i - 1][j - 1];
			}
		}
		// init row
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				agg[i][j] += matrix[i][j];
				if (j > 0)
					agg[i][j] += agg[i][j - 1];
			}
		}
	}

	public void set1(int x, int y, int value) {
		if (x < matrix.length && y < matrix[0].length)
			matrix[x][y] = value;
	}

	public int sum1(int x, int y) {
		int sum = 0;
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++)
				sum += matrix[i][j];
		}
		return sum;
	}

	public void set2(int x, int y, int value) {
		int temp = 0;
		if (x < matrix.length && y < matrix[0].length) {
			temp = matrix[x][y];
			matrix[x][y] = value;
		}
		for (int i = x; i < matrix.length; i++) {
			for (int j = y; j < matrix[0].length; j++) {
				single[i][j] = single[i][j] - temp + value;
			}
		}
	}

	public int sum2(int x, int y) {
		return single[x][y];
	}

	public void set3(int x, int y, int value) {
		int temp = 0;
		if (x < matrix.length && y < matrix[0].length) {
			temp = matrix[x][y];
			matrix[x][y] = value;
		}
		for (int i = y; i < matrix[0].length; i++) {
			agg[x][i] = agg[x][i] - temp + value;
		}

	}

	public int sum3(int x, int y) {
		int sum = 0;
		for (int i = 0; i <= x; i++) {
			sum += agg[i][y];
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SummableTable st = new SummableTable();
		// st.set1(1, 2, 3);
		// st.set2(1, 2, 3);
		st.set3(1, 2, 3);
		// System.out.println(st.sum2(2, 3));
		System.out.println(st.sum3(1, 3));
		// System.out.println(st.sum1(2,3));
	}

}
