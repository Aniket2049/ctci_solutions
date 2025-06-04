package _02_LinkedLists;

/*
 Implement a function to check if a linked list is a palindrome. 
*/

public class _06_Palindrome {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	boolean isPalindrome(LinkedListNode head) {
		LinkedListNode reversed = reverseAndClone(head);
		return isEqual(head, reversed);

	}

	private boolean isEqual(LinkedListNode one, LinkedListNode two) {
		while (one != null && two != null) {
			if (one.data != two.data)
				return false;
		
			one = one.next;
			two = two.next;
		}
		return one == null && two == null;
	}

	private LinkedListNode reverseAndClone(LinkedListNode node) {
		LinkedListNode newHead = null;
		while (node != null) {
			LinkedListNode n = new LinkedListNode(node.data, null);
			n.next = newHead;
			newHead = n;
			node = node.next;
		}
		return newHead;
	}
}
