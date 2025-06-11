package _03_StacksAndQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too 
high, it might topple. Therefore, in real life, we would likely start a new 
stack when the previous stack exceeds some  threshold. Implement a data 
structure SetOfStacks that mimics this. SetOfStacks should be composed of 
several stacks and should create a new stack once the previous one exceeds 
capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically 
to a single stack (that is, pop() should return the same values as it would 
if there were just a single stack).

FOLLOW UP 
Implement a function popAt(int index) which performs a pop operation on a 
specific substack. 
*/

public class _03_StackOfPlates {
	class StackOfPlates {
		List<Stack<Integer>> allStacks;
		Stack<Integer> ptrStack;
		int capacity;

		public StackOfPlates(int capacity) {
			this.capacity = capacity;
			init();
		}

		public void init() {
			ptrStack = new Stack<Integer>();
			allStacks = new ArrayList<Stack<Integer>>();
			allStacks.add(ptrStack);
		}

		public void push(int data) {
			if (ptrStack.size() == capacity) {
				Stack<Integer> newPtrStack = new Stack<Integer>();
				allStacks.add(newPtrStack);
				ptrStack = newPtrStack;
			}

			ptrStack.add(data);
		}

		public int pop() {
			int dataToReturn = ptrStack.pop();

			if (ptrStack.size() == 0) {
				if (allStacks.size() > 1)
					ptrStack = allStacks.get(allStacks.size() - 1);
				else
					init();
			}

			return dataToReturn;
		}
	}
}
