package _02_LinkedLists;

/*
 Given a circular linked list, implement an algorithm that 
 returns the node at the beginning of the loop. 
 Circular linked list: A (corrupt) linked list in which a node's next pointer 
 points to an earlier node, so as to make a loop in the linked list. 

 EXAMPLE
 +--------+----------------------------------------------------+
 | Input  | A -> B -> C -> D -> E -> C (the same C as earlier) |
 +--------+----------------------------------------------------+
 | Output | C 												   |
 +--------+----------------------------------------------------+
*/

public class _08_LoopDetection {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	LinkedListNode loopStartPoint(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}

		if (fast == null || fast.next == null)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;

	}
}
