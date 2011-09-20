package com.logica.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Anagram tester.
 * 
 * @author Jithu Gopal
 */
public class Anagram {

	private String word;

	public Anagram(String word) {
		this.word = word;
	}

	/**
	 * Test if the provided string is an anagram.
	 * @param test
	 * 			String to be tested
	 */
	public boolean isAnagram(String test) {
		if(word.length() != test.length())
			return false;
		List<Character> mainCharList = new ArrayList<Character>();
		List<Character> testCharList = new ArrayList<Character>();
		char[] mainCharArr = word.toCharArray();
		char[] testCharArr = test.toCharArray();
		for (int i = 0; i < mainCharArr.length; i++) {
			mainCharList.add(Character.valueOf(mainCharArr[i]));
			testCharList.add(Character.valueOf(testCharArr[i]));
		}
		for (Character character : testCharList) {
			if (mainCharList.contains(character)) {
				mainCharList.remove(character);
			} else {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Tests if test is anagram in O(n) time and constant space.
	 * 
	 * @param test
	 * @return
	 * 		<tt>true</tt> if anagram
	 * @author Vishal John
	 */
	private boolean isAnagram1(String test) {
		boolean result = true;
		int ref[] = new int[26]; // holds the count for the 26 alphabets
		word = word.toLowerCase();
		test = test.toLowerCase();
		char wordCharArr[] = word.toCharArray();
		char testCharArr[] = test.toCharArray();
		int idx;
		for(int i = 0; i < wordCharArr.length; i++) {
			idx = wordCharArr[i] - 'a';
			ref[idx] = ref[idx] + 1;
		}
		for(int i = 0; i < testCharArr.length; i++) {
			idx = wordCharArr[i] - 'a';
			ref[idx] = ref[idx] - 1;
		}
		for(int i=0; i < ref.length; i++) {
			if(ref[i] != 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String word = "jithu";
		final String test = "tijuh";
		Anagram anagram = new Anagram(word);
		System.out.println(anagram.isAnagram1(test));
	}

}
