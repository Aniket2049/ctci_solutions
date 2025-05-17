package _01_ArraysAndStrings;

/*
 Implement a method to perform basic string compression using the counts of 
 repeated characters. For example, the string aabcccccaaa would become a2blc5a3.
 If the "compressed" string would not become smaller than the original string, 
 your method should return the original string. You can assume the string has 
 only uppercase and lowercase letters (a - z). 
 
 EXAMPLE
 +--------+-------------+
 | Input  | aabcccccaaa	|
 +--------+-------------+
 | Output | a2b1c5a3	|
 +--------+-------------+
 
*/
public class _06_StringCompression {

	String compress(String str) {
		StringBuilder newString = new StringBuilder();
		StringBuilder tempString = new StringBuilder();
		int i = 0;
		while (i < str.length()) {
			int length = 1;
			Character c = str.charAt(i);
			while ((i + length) < str.length() && str.charAt(i + length) == c) {
				length++;
			}
			i = i + length;
			newString.append(c + String.valueOf(length));
			tempString.delete(0, tempString.length());
		}

		return newString.length() < str.length() ? newString.toString() : str;
	}

	public static void main(String[] args) {
		System.out.println(new _06_StringCompression().compress("aabcccccaaa"));

	}

}
