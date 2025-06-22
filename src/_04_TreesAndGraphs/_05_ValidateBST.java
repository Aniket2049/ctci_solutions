package _04_TreesAndGraphs;

/*
Implement a function to check if a binary tree is a binary search tree.
*/

public class _05_ValidateBST {
	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	boolean checkBST(TreeNode root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean checkBST(TreeNode root, int minValue, int maxValue) {
		if (root == null)
			return true;

		if (!(minValue < root.data && root.data < maxValue))
			return false;

		return checkBST(root.left, minValue, root.data) && checkBST(root.right, root.data, maxValue);
	}
}
