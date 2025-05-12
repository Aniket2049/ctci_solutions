package _01_ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
 Write a method to replace all spaces in a string with '%20: You may assume
 that the string has sufficient space at the end to hold the additional
 characters, and that you are given the "true" length of the string.
 (Note: if implementing in Java, please use a character array so that you 
 can perform this operation in place.) 
 
 EXAMPLE
 +--------+--------------------------+
 | Input  | "Mr John Smith JJ  ", 13 |
 +--------+--------------------------+
 | Output | "Mr%20John%20Smith%20JJ" |
 +--------+--------------------------+
*/
public class _03_URLify {
	void replaceSpaces(char[] str, int trueLength) {
		StringBuilder sb = new StringBuilder();
		List<String> words = new ArrayList<String>();
		for (int i = 0; i < str.length; i++) {
			if (str[i] != ' ') {
				sb.append(str[i]);
			} else {
				if(!sb.isEmpty())
					words.add(sb.toString());
				sb = new StringBuilder();
			}
		}

		String res = new String();
		for (int i = 0; i < words.size(); i++) {
			if (i == words.size() - 1) {
				res = res + words.get(i);
			} else {
				res = res + words.get(i) + "%20";
			}
		}

		System.out.println(res);
	}

	public static void main(String[] args) {
		_03_URLify obj = new _03_URLify();
		obj.replaceSpaces("Mr John Smith JJ  ".toCharArray(), 13);
	}
}
