// 给出无序整型数组 定义一个操作把某个数增加或减少x，x<=m
// 通过若干次操作 可以使得整个数组严格升序 求最小的m
public static void main(String[] args) {
	Solution object = new Solution();
	int[] nums = { 100, 8, 6, 5, 9, 8, 99, 3 };
	System.out.print(object.getMinGap(nums));
}

public void print(int[] nums) {
	for (int i = 0; i < nums.length; i++)
		System.out.print(nums[i] + " ");
	System.out.println();
}
public int getMinGap(int[] nums) {
	int ans = 0;
	if (nums == null || nums.length <= 1)
		return ans;
	int len = nums.length;
	int[] auxArray = new int[len];
	for (int i = 0; i < len; i++)
		auxArray[i] = nums[i] - i;
	print(auxArray);
	// nums[j]-nums[i]>j-i
	int cur = Integer.MAX_VALUE;
	int[] leftMin = new int[len];
	for (int i = 0; i < auxArray.length; i++) {
		if (auxArray[i] < cur)
			cur = auxArray[i];
		leftMin[i] = Math.min(auxArray[i], cur);
	}
	cur = Integer.MIN_VALUE;
	int[] rightMax = new int[len];
	for (int i = 0; i < auxArray.length; i++) {
		if (auxArray[i] > cur)
			cur = auxArray[i];
		rightMax[i] = Math.max(auxArray[i], cur);
	}

	for (int i = 0; i < auxArray.length; i++) {
		ans = Math.max((rightMax[i] - leftMin[i] + 1) / 2, ans);
	}
	return ans;
}
