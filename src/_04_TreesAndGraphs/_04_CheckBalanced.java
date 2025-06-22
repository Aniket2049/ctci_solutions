package _04_TreesAndGraphs;

/*
Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of
the two subtrees of any node never differ by more than one. 
*/
public class _04_CheckBalanced {
	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	boolean isBalanced(TreeNode root) {
		return getHeight(root) != Integer.MIN_VALUE ? true : false;
	}

	private int getHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = getHeight(root.left);
		if (leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		int rightHeight = getHeight(root.right);
		if (rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		if (Math.abs(rightHeight - leftHeight) > 1)
			return Integer.MIN_VALUE;

		int heightSelf = 1 + Math.max(leftHeight, rightHeight);
		return heightSelf;
	}
}
