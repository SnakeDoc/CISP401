package com.snakedoc.cisp401.march142013;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeTextBlocks {
	
	// current file
	File file;
	
	// file names
	private final static String[] texts = {"text1.txt", "text2.txt", "text3.txt"};
	
	// constructor
	// pass in String representation of the filename
	ThreeTextBlocks(String input) {
		this.file = new File(input);
	}
	
	// main() method
	public static void main(String[] args) {
		
		// main logic loop
		for (int i = 0; i < texts.length; i++) {
			
		}
	}
	
	/**
	 * Gets the number of words in given text.
	 * 
	 * @param file Input file (text).
	 * @return Integer representation of number of words in given text.
	 */
	protected int getWordCount(File file) {
		return (file.toString().split(" ").length + 1); // return number of "spaces" + 1
	}                                                   // +1 because spaces are in-between words.
	
	protected void getCharOccurance(File file) {
		
		CharOccuranceObj charObj = new CharOccuranceObj();
		
		char[] chars = file.toString().toLowerCase().toCharArray();
		
		// add first array character, it will always be unique (being first)
		charObj.charList.add(chars[0]);
		
		for (int i = 1; i < chars.length; i++) {
			for (int j = 0; j < map.size(); j++) {
				if (chars[i] == map.get(j)) {
					int val = map.g
				}
			}
		}
	}
	
	protected void getAvgWordLength(File file) {
		String text = file.toString();
	
	}
}

class CharOccuranceObj {
	List<Character> charList = new ArrayList<Character>();
	List<Integer> intList = new ArrayList<Integer>();
}