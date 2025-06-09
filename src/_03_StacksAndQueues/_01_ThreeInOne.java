package _03_StacksAndQueues;

/*
Three in One: Describe how you could use a single array to implement three stacks. 
*/
public class _01_ThreeInOne {

	class FixedMultiStack {
		private int numOfStacks = 3;
		private int stackCapacity;
		private int[] values;
		private int[] sizes;

		public FixedMultiStack(int stackCapacity) {
			this.stackCapacity = stackCapacity;
			values = new int[stackCapacity * numOfStacks];
			sizes = new int[numOfStacks];
		}

		public void push(int stackNum, int value) throws Exception {
			if (isFull(stackNum))
				throw new Exception("Full Stack");
			sizes[stackNum]++;
			values[indexOfTop(stackNum)] = value;
		}

		public int pop(int stackNum) throws Exception {
			if (isEmpty(stackNum))
				throw new Exception("Empty Stack");
			int topIndex = indexOfTop(stackNum);
			int value = values[topIndex];
			values[topIndex] = 0;
			sizes[stackNum]--;
			return value;
		}

		public boolean isEmpty(int stackNum) {
			return sizes[stackNum] == 0;
		}

		public boolean isFull(int stackNum) {
			return sizes[stackNum] == stackCapacity;
		}

		private int indexOfTop(int stackNum) {
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size - 1;
		}

	}
}
