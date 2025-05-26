package _02_LinkedLists;

import java.util.HashSet;

/*
Write code to remove duplicates from an unsorted linked list. 
FOLLOW UP : 
	How would you solve this problem if a temporary buffer is not allowed? 
*/

public class _01_RemoveDuplicates {

	class LinkedListNode {
		int data;
		LinkedListNode next;

		public LinkedListNode(int data, LinkedListNode node) {
			this.data = data;
			this.next = node;
		}
	}

	public static void main(String[] args) {

	}

	void deleteDuplicates(LinkedListNode head) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while (head != null) {
			if (set.contains(head.data)) {
				previous.next = head.next;
			} else {
				set.add(head.data);
				previous = head;
			}
			head = head.next;
		}
	}

	void deleteDuplicatesNoBuffer(LinkedListNode head) {
		while (head != null) {
			LinkedListNode current = head;
			while (current.next != null) {
				if (current.next.data == head.data) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}
			head = head.next;
		}
	}

}
