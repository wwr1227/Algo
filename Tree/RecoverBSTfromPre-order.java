// Given the pre-order visit sequence of a binary search tree, could you
// re-construct the original tree? Assume all elements are unique.
private void printTree(TreeNode node) {
	// TODO Auto-generated method stub
	if (node == null)
		return;
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	queue.offer(node);
	queue.offer(null);
	while (!queue.isEmpty()) {
		TreeNode cur = queue.poll();
		if (cur == null) {
			System.out.println();
			if (!queue.isEmpty())
				queue.offer(null);
		} else {
			System.out.print(cur.val + " ");
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
		}
	}

}


public TreeNode recoverBST(int[] nums) {
	if (nums == null || nums.length == 0)
		return null;
	return solve(nums, 0, nums.length - 1);
}

public TreeNode solve(int[] nums, int start, int end) {
	if (start > end)
		return null;
	TreeNode root = new TreeNode(nums[start]);
	if (start == end)
		return root;
	int i = start + 1;
	while (i < end && nums[i] < nums[start])
		i++;		
	root.left = solve(nums, start + 1, i - 1);		
	root.right = solve(nums, i, end);
	return root;
}
