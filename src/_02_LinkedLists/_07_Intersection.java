package _02_LinkedLists;

/*
 Given two (singly) linked lists, determine if the two lists intersect. Return 
 the intersecting node. Note that the intersection is defined based on 
 reference, not value. That is, if the kth node of the first linked list is 
 the exact same node (by reference) as the jth node of the second linked list, 
 then they are intersecting. 
*/

public class _07_Intersection {
	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	class TailAndSize {
		LinkedListNode tail;
		int size;

		public TailAndSize(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	LinkedListNode findIntersection(LinkedListNode one, LinkedListNode two) {
		if (one == null || two == null)
			return null;

		TailAndSize tsONE = getTailAndSize(one);
		TailAndSize tsTWO = getTailAndSize(two);

		if (tsONE.tail != tsTWO.tail)
			return null;

		LinkedListNode shorter = tsONE.size > tsTWO.size ? two : one;
		LinkedListNode longer = tsONE.size > tsTWO.size ? one : two;

		int diff = Math.abs(tsONE.size - tsTWO.size);

		while (diff != 0) {
			longer = longer.next;
			diff--;
		}

		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}

		return longer;
	}

	private TailAndSize getTailAndSize(LinkedListNode node) {
		if (node == null)
			return null;

		int size = 1;
		LinkedListNode current = node;
		while (current.next != null) {
			current = current.next;
			size++;
		}
		return new TailAndSize(current, size);
	}
}
