package _02_LinkedLists;

/*
 Write code to partition a linked list around a value x, such that all nodes 
 less than x come before all nodes greater than or equal to x. If x is 
 contained within the list, the values of x only need to be after the elements 
 less than x (see below). The partition element x can appear anywhere in the 
 "right partition"; it does not need to appear between the left and right 
 partitions. 

 EXAMPLE
 +--------+-------------------------------------------------+
 | Input  | 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5]|
 +--------+-------------------------------------------------+
 | Output | 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 				|
 +--------+-------------------------------------------------+
*/
public class _04_Partition {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;

			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) {
			return afterStart;
		}

		beforeEnd.next = afterStart;
		return beforeStart;

	}
}
