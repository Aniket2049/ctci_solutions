package _04_TreesAndGraphs;

/*
Given a sorted (increasing order) array with unique integer elements, write an 
algorithm to create a binary search tree with minimal height. 
*/

public class _02_MinimalTree {
	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	TreeNode createMinimalBST(int arr[]) {
		return createMinimalBST(arr, 0, arr.length - 1);
	}

	private TreeNode createMinimalBST(int[] arr, int start, int end) {
		if (end < start)
			return null;

		int mid = (end - start) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinimalBST(arr, start, mid - 1);
		root.right = createMinimalBST(arr, mid + 1, end);

		return root;
	}
}
