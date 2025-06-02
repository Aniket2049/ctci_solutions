package _02_LinkedLists;

/*
 You have two numbers represented by a linked list, where each node contains a
 single digit. The digits are stored in reverse order, such that the 1 's digit
 is at the head of the list. Write a function that adds the two numbers and 
 returns the sum as a linked list. 

 EXAMPLE
 +--------+--------------------------------------+
 | Input  | 7 -> 1 -> 6, 5 -> 9 -> 2 [617 + 295] |
 +--------+--------------------------------------+
 | Output | 2 -> 1 -> 9 				  [912]	 |
 +--------+--------------------------------------+

 FOLLOW UP 
 Suppose the digits are stored in forward order. Repeat the above problem. 

 +--------+--------------------------------------+
 | Input  | 6 -> 1 -> 7, 2 -> 9 -> 5 [617 + 295] |
 +--------+--------------------------------------+
 | Output | 9 -> 1 -> 2 				  [912]	 |
 +--------+--------------------------------------+
*/

public class _05_SumLists {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2) {
		LinkedListNode resPointer = new LinkedListNode(-1, null);
		LinkedListNode res = resPointer;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = 0 + carry;

			if (l1 != null) {
				sum += l1.data;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.data;
				l2 = l2.next;
			}

			carry = sum / 10;
			sum = sum % 10;
			resPointer.next = new LinkedListNode(sum, null);
			resPointer = resPointer.next;
		}

		if (carry == 1)
			resPointer.next = new LinkedListNode(1, null);

		return res.next;

	}
}
