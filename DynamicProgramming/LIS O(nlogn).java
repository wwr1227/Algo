import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述： 给定一个整型数组， 求这个数组的最长严格递增子序列的长度。 譬如序列1 2 2 4 3
 * 的最长严格递增子序列为1，2，4或1，2，3.他们的长度为3。 
 * 输入： 输入可能包含多个测试案例。
 * 对于每个测试案例，输入的第一行为一个整数n(1<=n<=100000)：代表将要输入的序列长度
 * 输入的第二行包括n个整数，代表这个数组中的数字。整数均在int范围内。 
 * 输出： 对于每个测试案例，输出其最长严格递增子序列长度。 
 * 样例输入： 
 * 4 
 * 4 0 1 3 
 * 5
 * 1 1 1 1 1 
 * 样例输出： 2 1
 * 
 * @author dongywan
 * 
 */

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			int[] nums = new int[n];
			Arrays.fill(nums, 0);
			for (int i = 0; i < n; i++)
				nums[i] = cin.nextInt();
			int[] up = new int[n];
			Arrays.fill(up, 0);
			up[0] = nums[0];
			int index = 0;
			for (int i = 1; i < n; i++) {
				if (nums[i] > up[index])
					up[++index] = nums[i];
				else {
					int pos = binarySearch(up, 0, index, nums[i]);
					up[pos] = nums[i];
				}

			}
			System.out.println(index + 1);
		}
	}

	private static int binarySearch(int[] up, int left, int right, int target) {
		// TODO Auto-generated method stub
		if (left > right)
			return 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (up[mid] >= target)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
}
