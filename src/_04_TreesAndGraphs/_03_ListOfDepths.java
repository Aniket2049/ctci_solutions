package _04_TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Given a binary tree, design an algorithm which creates a linked list of all the
nodes at each depth (e.g., if you have a tree with depth D, you'll have D 
linked lists). 
*/

public class _03_ListOfDepths {
	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		public TreeNode(int data) {
			this.data = data;
		}
	}

	ArrayList<LinkedList<TreeNode>> createLevelLinkedLists(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<_03_ListOfDepths.TreeNode>();
		current.add(root);

		while (current.size() > 0) {
			res.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<_03_ListOfDepths.TreeNode>();
			for (TreeNode parent : parents) {
				if (parent.left != null)
					current.add(parent.left);
				if (parent.right != null)
					current.add(parent.right);
			}
		}
		
		return res;
	}
}
