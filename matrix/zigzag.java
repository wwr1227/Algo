/*
1	  3	  4	  10	11	
2	  5	  9	  12	17	
6	  8	  13	16	18	
7	  14	15	19	20	
1234567891011121314151617181920
*/
public class Zigzag {
	public void printZigzagMatrix1(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0, j = 0;
		int dir = 1;
		for (int num = 0; num < m * n; num++) {
			System.out.print(matrix[i][j]);
			if (dir == 1) {
				if (i + 1 < m && j - 1 >= 0) {
					i++;
					j--;
				} else if (i + 1 >= m) {
					dir = -1;
					i = m - 1;
					j++;
				} else if (j - 1 < 0) {
					dir = -1;
					j = 0;
					i++;
				}
			} else {
				if (i - 1 >= 0 && j + 1 < n) {
					i--;
					j++;
				} else if (i - 1 < 0) {
					dir = 1;
					i = 0;
					j++;
				} else if (j + 1 >= n) {
					dir = 1;
					j = n - 1;
					i++;
				}
			}
		}
	}

	public int[][] conductZigzagMatrix1(int m, int n) {
		int[][] matrix = new int[m][n];
		if (m == 0 && n == 0)
			return matrix;
		int dir = 1;
		int i = 0, j = 0;
		for (int value = 1; value <= m * n; value++) {
			matrix[i][j] = value;
			if (dir == 1) {
				if (i + 1 < m && j - 1 >= 0) {
					i++;
					j--;
				} else if (i + 1 >= m) {
					dir = -1;
					i = m - 1;
					j++;
				} else if (j - 1 < 0) {
					dir = -1;
					j = 0;
					i++;
				}
			} else {
				if (i - 1 >= 0 && j + 1 < n) {
					i--;
					j++;
				} else if (i - 1 < 0) {
					dir = 1;
					i = 0;
					j++;
				} else if (j + 1 >= n) {
					dir = 1;
					j = n - 1;
					i++;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int m = 4;
		int n = 5;

		int[][] matrix = new Zigzag().conductZigzagMatrix1(m, n);
		print(matrix);
		new Zigzag().printZigzagMatrix1(matrix);
		// print(matrix);
	}

	private static void print(int[][] matrix) {
		// TODO Auto-generated method stub
		if (matrix == null || matrix.length == 0)
			return;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + "	");
			System.out.println();
		}

	}
}
