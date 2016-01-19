package google;

import java.util.*;

class MatrixPoint {
	int x;
	int y;
	int dist;

	MatrixPoint(int a, int b) {
		x = a;
		y = b;
		dist = Integer.MAX_VALUE;
	}

	MatrixPoint(int a, int b, int c) {
		x = a;
		y = b;
		dist = c;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + x + "," + y;
	}
}

public class MinHammingDistanceMatrix {
	public int minHammingDistance2(int[][] matrix) {
		Set<MatrixPoint> set = new HashSet<>();
		PriorityQueue<MatrixPoint> que = new PriorityQueue<>(10,
				new Comparator<MatrixPoint>() {
					public int compare(MatrixPoint o1, MatrixPoint o2) {
						return o1.dist - o2.dist;
					}
				});
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					que.offer(new MatrixPoint(i, j, 0));
				} else if (matrix[i][j] == 2)
					set.add(new MatrixPoint(i, j));
			}
		}
		while (!que.isEmpty()) {
			MatrixPoint p = que.poll();
			int[] idx = { -1, 1, 0, 0 };
			for (int i = 0; i < 4; i++) {
				int x = p.x + idx[i];
				int y = p.y + idx[3 - i];
				if (x >= 0 && x < matrix.length && y >= 0
						&& y < matrix[0].length) {
					if (set.contains(new MatrixPoint(x, y))) {
						System.out.println("end");
						return p.dist + 1;
					}

					que.offer(new MatrixPoint(x, y, p.dist + 1));
				}
			}
			System.out.println(que);
		}

		return Integer.MAX_VALUE;
	}

	public int minHammingDistance(int[][] matrix) {
		int[][] map = new int[matrix.length][matrix[0].length];
		Queue<int[]> que = new LinkedList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					map[i][j] = 0;
					que.offer(new int[] { i, j });
				} else
					map[i][j] = -1;
			}

		}
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int[] idx = { -1, 1, 0, 0 };
			for (int i = 0; i < 4; i++) {
				int x = cur[0] + idx[i];
				int y = cur[1] + idx[3 - i];
				if (x >= 0 && x < matrix.length && y >= 0
						&& y < matrix[0].length) {
					if (map[x][y] == -1) {
						map[x][y] = map[cur[0]][cur[1]] + 1;
						que.offer(new int[] { x, y });
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 2) {
					min = Math.min(map[i][j], min);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinHammingDistanceMatrix min = new MinHammingDistanceMatrix();
		int[][] matrix = { { 0, 1, 0, 0, 0, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 2, 0 },
				{ 0, 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 0, 0 }, { 2, 0, 0, 0, 0, 0, 0, 1, 0 } };
		System.out.println(min.minHammingDistance(matrix));
	}

}
