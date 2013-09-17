import java.util.ArrayList;
/**
整数划分问题是把一个正整数 N 拆分成一组数，并且使这组数相加等于 N 的问题.
比如:
6
5 + 1 
4 + 2, 4 + 1 + 1
3 + 3, 3 + 2 + 1, 3 + 1 + 1 + 1
2 + 2 + 2, 2 + 2 + 1 + 1, 2 + 1 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1 + 1

这里，5+1和1+5是同一种分法。
这里探讨整数划分的可行解的数目。
问题求解：
首先假设正整数n拆分成k个数(不允许有0)，用f(n,k)表示正整数n拆分成k个数的可行拆分种类的数目。
那么
f(n,n)表示n拆分成n个数(即只有n个1)，显然f(n,n) = 1
然后，可以按照这k份中是否有一份的数为1分成两类：
1)   这k份中没有1份含1的：那么可以在n中拿出k个"1"出来，分到k份中，再将剩下n-k分到k份中，于是这时有
f(n,k) = f(n-k,k)
2)  这k份中至少有一份含有1：首先在n中拿1个"1"出来，再将剩下n-1分到k-1份中，于是这时有：f(n,k) = f(n-1,k-1)

综合起来就是：
f(n,n) = 1
f(n,k) = f(n-k,k) + f(n-1,k-1)
这两个递归式可以使用动态规划求解。
**/

public class Number {
	public int splitNumCount(int num) {
		if (num <= 0)
			return 0;
		int[][] dp = new int[num + 1][num + 1];

		for (int i = 0; i <= num; i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				dp[i][j] = dp[i - 1][j - 1];
				if (i - j > 0)
					dp[i][j] += dp[i - j][j];
			}
		}
		int count = 0;
		for (int i = 2; i <= num; i++)
			count += dp[num][i];
		return count;
	}

	public ArrayList<ArrayList<Integer>> splitNum(int num) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (num <= 0)
			return ans;
		int[] candidate = new int[num];
		for (int i = 0; i < num; i++) {
			candidate[i] = i + 1;
		}
		dfs(ans, item, candidate, 0, 0, num);
		return ans;
	}

	private void dfs(ArrayList<ArrayList<Integer>> ans,
			ArrayList<Integer> item, int[] candidate, int sum, int pos, int num) {
		// TODO Auto-generated method stub
		if (sum > num || pos >= candidate.length - 1)
			return;
		if (sum == num) {
			ans.add(new ArrayList<Integer>(item));
			return;
		}
		item.add(candidate[pos]);
		dfs(ans, item, candidate, sum + candidate[pos], pos, num);
		item.remove(item.size() - 1);
		dfs(ans, item, candidate, sum, pos + 1, num);
	}

	public static void main(String[] args) {
		// System.out.println(new Number().splitNum(6));
		// System.out.println(new Number().splitNum(6).size() + "?="
		// + new Number().splitNumCount(6));
	}
}
