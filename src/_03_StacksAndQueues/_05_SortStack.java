package _03_StacksAndQueues;

import java.util.Stack;

/*
Sort Stack: Write a program to sort a stack such that the smallest items are on
the top. You can use an additional temporary stack, but you may not copy the 
elements into any other data structure (such as an array). The stack supports 
the following operations: push, pop, peek, and isEmpty. 
*/

// https://www.youtube.com/watch?v=tcAlVMrGAfQ

public class _05_SortStack {

	Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while (!r.isEmpty() && r.peek() > temp)
				s.push(r.pop());
			r.push(temp);
		}
		return r;
	}

}
