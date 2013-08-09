package ;

public class MinSum {

  private int minSum = 0;
	private int upper;

	public int getMinSum(int[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return minSum;
		int n = matrix.length;
		upper = (1 << n) - 1;
		minSum = Integer.MAX_VALUE;
		Recursion(matrix, 0, 0);
		return minSum;
	}

	private void Recursion(int[][] matrix, int row, int curSum) {
		int position, p;
		if (row != upper) {
			position = upper & (~row);
			while (position != 0) {
				p = position & (-position);
				position = position - p;
				int r = countBit(row);
				int c = matrix.length - 1 - bitLastIndex(p);
				int newSum = curSum + matrix[r][c];
				Recursion(matrix, row + p, newSum);
			}
		} else {
			if (curSum < minSum)
				minSum = curSum;
		}
	}

	public int countBit(int i) {
		int count = 0;
		while (i != 0) {
			i = i & (i - 1);
			count++;
		}
		return count;
	}

	public int bitLastIndex(int i) {
		int index = 0;
		while ((i & 1) != 1) {
			index++;
			i = (i >> 1);
		}
		return index;

	}

	public static void main(String[] args) {
		MinSum ms = new MinSum();
		int[][] matrix = { { 1, 2, 3 }, { 3, 2, 1 }, { 2, 1, 3 } };
		System.out.println(ms.getMinSum(matrix));
	}

}
