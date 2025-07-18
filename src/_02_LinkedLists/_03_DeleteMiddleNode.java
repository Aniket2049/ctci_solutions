package _02_LinkedLists;

/*
Implement an algorithm to delete a node in the middle (i.e., any node but the 
first and last node, not necessarily the exact middle) of a singly linked list,
given only access to that node. 
EXAMPLE 
Input: the node c from the linked list a -> b -> c -> d -> e -> f 
Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f 
*/

public class _03_DeleteMiddleNode {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	boolean deleteNode(LinkedListNode node) {
		if (node == null || node.next == null)
			return false;

		LinkedListNode next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}
}
