package _04_TreesAndGraphs;
/*
Write an algorithm to find the "next" node (i.e., in-order successor) of a 
given node in a binary search tree. You may assume that each node has a link 
to its parent. 
*/

// https://medium.com/cracking-the-coding-interview-in-ruby-python-and/4-5-the-next-node-in-a-binary-search-tree-in-javascript-ruby-and-python-mastering-algorithms-af20d044bd88

public class _06_Successor {
	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	TreeNode inorderSucc(TreeNode n) {
		if (n == null)
			return null;

		if (n.right != null)
			return leftMostChild(n.right);
		else {
			TreeNode temp = n;
			TreeNode parent = n.parent;

			while (parent != null && n == parent.right) {
				temp = parent;
				parent = parent.parent;
			}

			return parent;
		}

	}

	TreeNode leftMostChild(TreeNode n) {
		if (n == null)
			return null;

		while (n.left != null)
			n = n.left;

		return n;
	}
}
