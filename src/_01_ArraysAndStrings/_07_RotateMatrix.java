package _01_ArraysAndStrings;

/*
 Given an image represented by an NxN matrix, where each pixel in the image 
 is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
 in place? 
*/
public class _07_RotateMatrix {
	void rotate(int[][] matrix) {
		int n = matrix.length;

		// Consider all cycles one by one
		for (int i = 0; i < n / 2; i++) {

			// Consider elements in group of 4 as P1, P2, P3 & P4 in current square
			// P1 P2
			// P4 P3
			for (int j = i; j < n - i - 1; j++) {

				// Swap elements in clockwise order
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];                 // Move P4 to P1
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // Move P3 to P4
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // Move P2 to P3
				matrix[j][n - 1 - i] = temp;                      	 // Move P1 to P2
			}
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		new _07_RotateMatrix().printMatrix(mat);
		new _07_RotateMatrix().rotate(mat);
		new _07_RotateMatrix().printMatrix(mat);
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
