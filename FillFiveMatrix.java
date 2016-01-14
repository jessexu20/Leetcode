import java.util.Arrays;

public class FillFiveMatrix {
	int count = 0;
	int max = 25;
	int sqrt = (int) Math.sqrt(max);

	public int fill() {
		int[] matrix = new int[max];
		Arrays.fill(matrix, -1);
		matrix[0] = 1;
		helper(matrix, 2);
		return count;
	}

	public void helper(int[] matrix, int number) {
		if (number > max) {
			count++;
			return;
		}
		for (int i = 0; i < max; i++) {
			if (matrix[i] != -1)
				continue;
			boolean flag1 = i < sqrt && i > 0 && matrix[i - 1] != -1;
			boolean flag2 = i >= sqrt && i % sqrt == 0
					&& matrix[i - sqrt] != -1;
			boolean flag3 = i >= sqrt && matrix[i - 1] != -1
					&& matrix[i - sqrt] != -1;
			if (flag1 || flag2 || flag3) {
				matrix[i] = number;
				helper(matrix, number + 1);
				matrix[i] = -1;
			}
		}
	}

	public static void main(String args[]) {
		FillFiveMatrix fm = new FillFiveMatrix();
		System.out.println(fm.fill());
	}
}