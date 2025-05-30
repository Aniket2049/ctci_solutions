package _01_ArraysAndStrings;

/*
 There are three types of edits that can be performed on strings: insert a 
 character, remove a character, or replace a character. Given two strings, write
 a function to check if they are one edit (or zero edits) away. 

 EXAMPLES
 +------------------+----------------+
 | Input  		    | Output		 |
 +------------------+----------------+
 | "pale", "ple"    | true			 |
 +------------------+----------------+
 | "pales", "pale"  | true			 |
 +------------------+----------------+
 | "pale", "bale"   | true			 |
 +------------------+----------------+
 | "pale", "bae"    | false			 |
 +------------------+----------------+

*/
public class _05_OneAway {

	boolean isOneEditAway(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}

	private boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference)
					return false;

				foundDifference = true;
			}
		}
		return true;
	}

	private boolean oneEditInsert(String s1, String s2) {	// s1.length() < s2.length()
		int index1 = 0;
		int index2 = 0;

		while (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2)
					return false;

				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new _05_OneAway().isOneEditAway("pale", "ple"));
		System.out.println(new _05_OneAway().isOneEditAway("pales", "pale"));
		System.out.println(new _05_OneAway().isOneEditAway("pale", "bale"));
		System.out.println(new _05_OneAway().isOneEditAway("pale", "bae"));

	}

}
