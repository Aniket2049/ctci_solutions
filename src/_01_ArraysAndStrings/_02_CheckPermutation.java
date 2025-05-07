package _01_ArraysAndStrings;

// Given two strings, write a method to decide if one is a permutation of the 
// other
public class _02_CheckPermutation {
	boolean permutation(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] frequency = new int[128];	// assuming ASCII characters only
		for (int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i)]++;
		}

		for (int i = 0; i < t.length(); i++) {
			frequency[t.charAt(i)]--;
			if (frequency[t.charAt(i)] < 0)
				return false;
		}

		return true;
	}
}
