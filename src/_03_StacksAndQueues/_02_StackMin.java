package _03_StacksAndQueues;

import java.util.Stack;

/*
Stack Min: How would you design a stack which, in addition to push and pop, 
has a function min which returns the minimum element? Push, pop and min should 
all operate in 0(1) time. 
*/

public class _02_StackMin {
	class MinStack {
		Stack<Integer> mainStack;
		Stack<Integer> minStack;

		public MinStack() {
			mainStack = new Stack<Integer>();
			minStack = new Stack<Integer>();
		}

		public void push(int data) {
			mainStack.push(data);
			if (minStack.isEmpty() || data < minStack.peek()) {
				minStack.push(data);
			}
		}

		public Integer pop() {
			if (mainStack.isEmpty())
				return null;

			int dataToReturn = mainStack.pop();
			if (dataToReturn == minStack.peek()) {
				minStack.pop();
			}

			return dataToReturn;
		}

		public Integer min() {
			if (minStack.isEmpty())
				return null;

			return minStack.peek();
		}
	}
}
