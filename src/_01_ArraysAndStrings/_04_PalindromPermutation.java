package _01_ArraysAndStrings;

/*
 Given a string, write a function to check if it is a permutation of a 
 palindrome. A palindrome is a word or phrase that is the same forwards and 
 backwards. A permutation is a rearrangement of letters. The palindrome does 
 not need to be limited to just dictionary words. 

 EXAMPLE
 +--------+--------------------------------------------------+
 | Input  | Tact Coa										 |
 +--------+--------------------------------------------------+
 | Output | True (permutations:"taco cat", "atco cta", etc.) |
 +--------+--------------------------------------------------+
*/
public class _04_PalindromPermutation {

	boolean isPermutationOfPalindrome(String phrase) {
		int[] freqTable = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				freqTable[c - 'a']++;
			}
		}

		boolean isOddFound = false;
		for (int freq : freqTable) {
			if (freq % 2 == 1) {
				if (isOddFound)
					return false;
				isOddFound = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new _04_PalindromPermutation().isPermutationOfPalindrome("taco cat"));

	}

}
