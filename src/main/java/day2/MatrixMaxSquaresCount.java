package day2;

public class MatrixMaxSquaresCount {

	public static void main(String[] args) {
		int matrix[][] = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } };

		System.out.println(squaresCount(matrix));
	}

	static int squaresCount(int[][] mat) {
		final int rows = mat.length;
		if (rows == 0) {
			return 0;
		}

		final int cols = mat[0].length;
		if (cols == 0) {
			return 0;
		}

		final int[][] res = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {

				if (mat[i][j] == 1) {
					res[i][j] = 0;
				} else {
					if (i - 1 < 0 || j - 1 < 0) {
						res[i][j] = 1;
					} else {
						res[i][j] = 1 + minOfThree(res[i - 1][j], res[i][j - 1], res[i - 1][j - 1]);
					}
				}
			}
		}

		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (res[i][j] > 0) {
					count += res[i][j];
				}
			}
		}

		return count;
	}

	static int minOfThree(int a, int b, int c) {
		int min = a;
		if (b < min) {
			min = b;
		}
		if (c < min) {
			min = c;
		}
		return min;
	}

}
