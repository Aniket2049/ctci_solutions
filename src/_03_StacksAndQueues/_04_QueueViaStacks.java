package _03_StacksAndQueues;

import java.util.Stack;

/*
Queue via Stacks: Implement a MyQueue class which implements a queue using 
two stacks.
*/

public class _04_QueueViaStacks {
	class QueueViaStacks {
		Stack<Integer> mainStack;
		Stack<Integer> auxiStack;

		public QueueViaStacks() {
			mainStack = new Stack<Integer>();
			auxiStack = new Stack<Integer>();
		}

		public void push(int data) {
			mainStack.push(data);
		}

		public int pop() {
			int dataToReturn = Integer.MIN_VALUE;
			while (mainStack.size() != 1) {
				auxiStack.push(mainStack.pop());
			}

			dataToReturn = mainStack.pop();

			while (!auxiStack.isEmpty()) {
				mainStack.push(auxiStack.pop());
			}

			return dataToReturn;
		}

	}
}
