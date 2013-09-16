// 给一颗普通二叉树，设计算法得到最深最右叶子节点，优化算法达到空间复杂度O(1)。
public TreeNode findMostDeepRightNode(TreeNode root){
	if(root==null)
		return root;
	TreeNode cur=root;
	TreeNode ans;
	int curDeep=0;
	int maxDeep=0;
	while(cur!=null){
		if(cur.left!=null){
			TreeNode rightNode = cur.left;
			int deep = 1;
			while(rightNode.right!=null&&rightNode.right!=parent){
				rightNode=rightNode.right;
				deep++;
			}
			if(rightNode.right==null){
				rightNode.right=parent;
				cur = cur.left;
				curDeep++;
			}else if(rightNode.right==parent)
				rightNode.right==null;
				cur=cur.right;
				curDeep-=deep;		
		}else{			
			if (curDeep > maxDeep) {
				maxDeep = curDeep;
				ans = root;
			}
			curDeep++;
			cur =cur.right;		
		}
	}
	return ans;
}
//////////////////////////////////////////////////////////////////
public TreeNode findMostDeepRightNode(TreeNode root){
	if(root==null)
		return root;
	Queue<TreeNode> queue = new Queue<TreeNode>();
	queue.offer(root);
	queue.offer(null);
	TreeNode ans=null, cur=null;
	while(!queue.isEmpty()){
		ans = cur;
		cur = queue.poll();
		if(cur==null){
			if(queue.isEmpty()) break;
			queue.offer(null);
		}else{
			if(cur.left!=null)
				queue.offer(cur.left);
			if(cur.right!=null)
				queue.offer(cur.right);
		}		
	}
	return ans;
}
