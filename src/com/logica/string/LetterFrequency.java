package com.logica.string;


/**
 * Problem: Expand the encoding - "a3f2d1b3f12" --> "aaaffdbbbffffffffffff"
 * 
 * @author gopalj
 *
 */
public class LetterFrequency {
	
	private String encodedStr;

	public LetterFrequency(String encodedStr) {
		this.encodedStr = encodedStr;
	}

	private String decrypt() {
		char[] encodedStrArr = encodedStr.toCharArray();
		StringBuilder ret = new StringBuilder();
		char lastChar = encodedStrArr[0];
		int lastCharIndex = 1;
		for (int i = 1, len = encodedStrArr.length; i < len; i++) {
			if(Character.isLetter(encodedStrArr[i])){
				ret.append(
							appendCharacter(
									lastChar, calculateFrequency(lastCharIndex, i))
							);
				lastCharIndex = i + 1;
				lastChar = encodedStrArr[i];
			}
		}
		ret.append(
				appendCharacter(
							lastChar, calculateFrequency(lastCharIndex, encodedStrArr.length))
				);
		return ret.toString();
	}

	private String appendCharacter(char lastChar, int frequency) {
		StringBuilder ret = new StringBuilder(frequency);
		while(frequency-- > 0)
			ret.append(lastChar);
		return ret.toString();
	}

	private int calculateFrequency(int lastCharIndex, int i) {
		return Integer.parseInt(encodedStr.substring(lastCharIndex, i));
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String testStr = "a3f2d1b3f12";
		LetterFrequency lf = new LetterFrequency(testStr);
		System.out.println(lf.decrypt());
	}
}
