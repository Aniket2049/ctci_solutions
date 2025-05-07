package _01_ArraysAndStrings;

/*
 Implement an algorithm to determine if a string has all unique characters. 
 What if you cannot use additional data structures?
*/
public class _01_IsUnique {
	private boolean isUnique(String str) {
		boolean[] charSet = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val])
				return false;
			charSet[val] = true;
		}
		return true;
	}
}
