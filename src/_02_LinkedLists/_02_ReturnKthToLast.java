package _02_LinkedLists;

/*
 Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class _02_ReturnKthToLast {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	LinkedListNode kthToLast(LinkedListNode root, int k) {
		LinkedListNode head = root;
		LinkedListNode preHead = root;

		while (k != 0) {
			head = head.next;
		}

		while (head != null) {
			preHead = preHead.next;
			head = head.next;
		}

		return preHead;
	}

	int kthToLastRecursion(LinkedListNode root, int k) {
		if (root == null)
			return 0;

		int index = kthToLastRecursion(root.next, k) + 1;
		if (index == k)
			System.out.println(k + "th to last node is " + root.data);

		return index;
	}
}
