package _01_ArraysAndStrings;

/*
String Rotation: Assume you have a method isSubstring which checks if one word 
is a substring of another. Given two strings, s1 and s2, write code to check 
if s2 is a rotation of s1 using only one call to isSubstring 
(e.g., "waterbottle" is a rotation of "erbottlewat"). 
*/

public class _09_StringRotation {

	boolean isRotation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		String s1s1 = s1 + s1;
		return findSubstring(s1s1, s2) != -1;
	}

	public static void main(String[] args) {
		System.out.println(new _09_StringRotation().isRotation("waterbottle", "erbottlewat"));

	}

	// Function to find if pat is a substring of txt
	private int findSubstring(String txt, String pat) {
		int n = txt.length();
		int m = pat.length();
		// Iterate through txt
		for (int i = 0; i <= n - m; i++) {
			// Check for substring match
			int j;
			for (j = 0; j < m; j++) {
				// Mismatch found
				if (txt.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			// If we completed the inner loop, we found a match
			if (j == m) {
				// Return starting index
				return i;
			}
		}
		// No match found
		return -1;
	}

}
