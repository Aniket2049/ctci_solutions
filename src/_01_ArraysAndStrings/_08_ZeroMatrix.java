package _01_ArraysAndStrings;

/*
Write an algorithm such that if an element in an MxN matrix is 0, its entire 
row and column are set to 0.

*/
public class _08_ZeroMatrix {

	void nullifyRow(int[][] matrix, int row) {
		for (int c = 0; c < matrix[0].length; c++) {
			matrix[row][c] = 0;
		}
	}

	void nullifyColumn(int[][] matrix, int col) {
		for (int r = 0; r < matrix.length; r++) {
			matrix[r][col] = 0;
		}
	}

	void setZeros(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = true;

		for (int c = 0; c < matrix[0].length; c++) {
			if (matrix[0][c] == 0) {
				rowHasZero = true;
				break;
			}
		}

		for (int r = 0; r < matrix.length; r++) {
			if (matrix[r][0] == 0) {
				colHasZero = true;
				break;
			}
		}

		for (int r = 1; r < matrix.length; r++) {
			for (int c = 1; c < matrix[0].length; c++) {
				if (matrix[r][c] == 0) {
					matrix[r][0] = 0;
					matrix[0][c] = 0;
				}
			}
		}

		for (int r = 1; r < matrix.length; r++) {
			if (matrix[r][0] == 0)
				nullifyRow(matrix, r);
		}

		for (int c = 1; c < matrix[0].length; c++) {
			if (matrix[0][c] == 0)
				nullifyColumn(matrix, c);
		}

		if (rowHasZero)
			nullifyRow(matrix, 0);

		if (colHasZero)
			nullifyColumn(matrix, 0);
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 3, 4 }, { 5, 6, 7, 0 }, { 0, 10, 11, 12 }, { 13, 14, 15, 16 } };

		new _08_ZeroMatrix().printMatrix(mat);
		new _08_ZeroMatrix().setZeros(mat);
		new _08_ZeroMatrix().printMatrix(mat);

	}
	
	private void printMatrix(int[][] matrix) {
		System.out.println();
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + " ");
			}
			System.out.println();
		}
	}

}
