public class Solution {
	/**
	 * @param args
	 */
	/**
    *  	      0   
    *    1       2 
    *  3   4       
    *        5    
    */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		TreeNode rootNode = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		rootNode.left = node1;
		rootNode.right = node2;
		node1.left = node3;
		node1.right = node4;
		node4.right = node5;
		su.printTree(rootNode);
	}

	// print tree
	public void printTree(TreeNode root) {
		int flag = -10000;
		Map<TreeNode, Integer> traversal = getInOrderTraversal(root);
		int[][] treeGraph = new int[traversal.size()][traversal.size()];
		for (int i = 0; i < traversal.size(); i++)
			Arrays.fill(treeGraph[i], flag);
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		queue.offer(null);
		int layer = 0;
		int col = traversal.get(root);
		treeGraph[layer][col] = root.val;
		while (!queue.isEmpty()) {
			TreeNode curNode = queue.poll();
			if (curNode == null) {
				layer++;
				if (queue.isEmpty())
					break;
				queue.offer(null);
			} else {
				col = traversal.get(curNode);
				treeGraph[layer][col] = curNode.val;
				if (curNode.left != null)
					queue.offer(curNode.left);
				if (curNode.right != null)
					queue.offer(curNode.right);
			}
		}
		for (int i = 0; i < layer; i++) {
			for (int j = 0; j < traversal.size(); j++) {
				if (treeGraph[i][j] == flag)
					System.out.print(" " + " ");
				else
					System.out.print(treeGraph[i][j] + " ");
			}
			System.out.println();
		}
	}

	private Map<TreeNode, Integer> getInOrderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		if (root == null)
			return map;
		ArrayList<TreeNode> ans = new ArrayList<TreeNode>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {

				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			ans.add(cur);
			cur = cur.right;
		}
		for (int i = 0; i < ans.size(); i++)
			map.put(ans.get(i), i);
		return map;
	}
}
