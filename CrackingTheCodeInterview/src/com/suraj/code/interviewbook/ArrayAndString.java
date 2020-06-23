package com.suraj.code.interviewbook;

import java.util.HashMap;
import java.util.Map;

public class ArrayAndString {

	// Is Unique: Implement an algorithm to determine if a string has all unique characters
	boolean isUniqueChars(String str) {
		if (str.length() > 128) return false;
		
		boolean[] char_set=  new boolean[128];
		for (int i= 0; i < str.length(); i++) {
			int val= str.charAt(i);
			if (char_set[val]) {//Already found this char in string 
				return false; 
				} 
			char_set[val] = true; 
			}
		return true;  
	}
	
	// Check Permutation: Given two strings, write a method to decide if one is a permutation of the other. 
	boolean permutation(String s, String t) {
		if (s.length() != t.length()) {
			return false; 
		}  
		int[] letters = new int[128]; // Assumption 
		char[] s_array = s.toCharArray(); 
		for (char c : s_array) { // count number of each char in s. 
			letters[c]++; 
		} 
		
		for (int i= 0; i < t.length(); i++) { 
			int c = (int) t.charAt(i); 
			letters[c]--; 
			
			if (letters[c] < 0) {
				return false; 
			} 
		} 
		return true; 
	}
	
	// Check Permutation: Given two strings, write a method to decide if one is a permutation of the other by using Map.
	boolean permutationByUsingMap(String s, String t) {
		if (s.length() != t.length()) {
			return false; 
		}  
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] s_array = s.toCharArray(); 
		for (char c : s_array) { // count number of each char in s. 
			if(map.containsKey(c)) {
				map.put(c, (int)map.get(c)+1);
			} else {
				map.put(c, 1);
			} 
		}
		
		for (int i= 0; i < t.length(); i++) { 
			char c = t.charAt(i); 
			if(map.containsKey(c)) {
				map.put(c, (int)map.get(c)-1);
				if((int)map.get(c) < 0) {
					return false;
				}
			} else {
				return false;
			} 
		}
		return true;
	}
	
	// URLify: Write a method to replace all spaces in a string with '%20'.
	void replaceSpaces(char[] str, int trueLength) { 
		int spaceCount = 0, index, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') { 
				spaceCount++; 
			}
		} 
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length) 
			str[trueLength] = '\0'; 
					
		for (i = trueLength - 1; i >= 0; i--) { 
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2'; 
				str[index - 3] = '%'; 
				index = index - 3;
			} else { 
				str[index - 1] = str[i]; 
				index--; 
			}
		} 
	} 
	
	/* Map each character to a number. a-> 0, b -> 1, c -> 2, etc.
	 * This is case insensitive. Non-letter characters map to -1. 
	 * */ 
	int getCharNumber(Character c) { 
		int a= Character.getNumericValue('a'); 
		int z = Character.getNumericValue('z'); 
		int val= Character.getNumericValue(c); 
		if (a<= val && val<= z) {
			System.out.println(val - a);
			return val - a; 
		} 
		return -1; 
	} 
	
	/* Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. 
	 * A palindrome is a word or phrase that is the same forwards and backwards. 
	 * A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
	 * */ 
	boolean isPermutationOfPalindrome(String phrase) {
		int countOdd = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for (char c : phrase.toCharArray()) {
			int x = getCharNumber(c); 
			if (x != -1) { 
				table[x]++; 
				if (table[x] % 2 == 1) {
					countOdd++; 
				} else { 
					countOdd--; 
				}
			}
		}
		return countOdd <= 1;
	}
	
	// One Away: There are three types of edits that can be performed on strings: insert a character, 
	// remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away
	
	boolean oneEditAway(String first, String second) {
		/* Length checks. */ 
		if (Math.abs(first.length() - second.length()) > 1) { 
			return false; 
		} 
		
		/* Get shorter and longer string.*/ 
		String s1 = first.length()< second.length() ? first : second; 
		String s2 = first.length()< second.length() ? second : first; 
		int indexl = 0; 
		int index2 = 0; 
		boolean foundDifference = false; 
		while (index2<  s2.length() && indexl <  s1.length()) {
			//System.out.println(" "+s1.charAt(indexl) +" "+ s2.charAt(index2));
			if (s1.charAt(indexl) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found.*/ 
				if (foundDifference) return false; 
					foundDifference = true;

				if (s1.length() == s2.length()) {
						//On replace, move shorter pointer 21 
							indexl++;  
				}
			} else {
				indexl++ ; // If matching, move shorter pointer 
				} 
			index2++; // Always move pointer for longer string 
		}
		return true; 
	}

	/* String Compression: Implement a method to perform basic string compression 
	 * using the counts of repeated characters. For example, the string aabcccccaaa 
	 * would become a2blc5a3. If the "compressed" string would not become smaller 
	 * than the original string, your method should return the original string. 
	 * You can assume the string has only uppercase and lowercase letters (a -z). */ 
	
	public String compress(String str) {
		StringBuilder compressed= new StringBuilder();
		int countConsecutive = 0;
		for (int i= 0; i < str.length(); i++) {
			countConsecutive++;
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	/* Rotate Matrix: Given an image represented by an NxN matrix, 
	 * where each pixel in the image is 4 bytes, write a method to 
	 * rotate the image by 90 degrees. Can you do this in place? */
	public boolean rotate(int[][] matrix) {
		if (matrix.length== 0 || matrix.length != matrix[0].length) 
			return false;
		int n = matrix.length; 
		System.out.println(n);
		for (int layer = 0; layer < n / 2; layer++) {
			int first= layer; 
			int last= n -1 - layer; 
			for(int i = first; i < last; i++) { 
				int offset = i - first;
				int top= matrix[first][i]; //save top 
				// left -> top 
				matrix[first][i] = matrix[last-offset][first]; 
				
				// bottom -> left 
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// right -> bottom 
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right<- saved top
			}
		}
		return true; 
	}
	
	public void printMatrix(int[][] matrix, int row, int col) {
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/*Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, 
	 * its entire row and column are set to 0. */
	
	public void setzeros(int[][] matrix) {
		boolean rowHasZero = false; 
		boolean colHasZero = false; 
		
		// Check if first row has a zero 
		for (int j=  0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) { 
				rowHasZero = true; 
				break;
			}
		} 
		// Check if first column has a zero 
		for (int i=  0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break; 
			}
		}
		// Check for zeros in the rest of the array 
		for (int i= 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0; 
					matrix[0][j] = 0; 
				}
			} 
		}
		
		// Nullify rows based on values in first column 
		for (int i= 1; i < matrix.length; i++) { 
			if (matrix[i][0] == 0) { 
				nullifyRow(matrix, i); 
			} 
		} 
		
		// Nullify columns based on values in first row 
		for (int j = 1; j < matrix[0].length; j++) { 
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j); 
			}
		} 
		// Nullify first row 
		if (rowHasZero) {
			nullifyRow(matrix, 0); 
		} 
		// Nullify first column 
		if (colHasZero) {
			nullifyColumn(matrix, 0); 
		}
	}
	
	public void nullifyRow(int[][] matrix, int row) { 
		for (int j=  0; j < matrix[0].length; j++) { 
			matrix[row][j] = 0; 
		} 
	} 
	
	public void nullifyColumn(int[][] matrix, int col) {
		for (int i= 0; i < matrix.length; i++) { 
			matrix[i][col] = 0; 
		}
	}
	
	public boolean isRotation(String sl, String s2) { 
		int len = sl.length(); 
		/* Check that sl and s2 are equal length and not empty*/ 
		if (len == s2.length() && len > 0) {
			/* Concatenate sl and sl within new buffer */ 
			String slsl = sl + sl;
				return slsl.contains(s2); 
			} 
		return false; 
	}
	
	public static void main(String[] args) {
		ArrayAndString arr = new ArrayAndString();
	/*	System.out.println(arr.isUniqueChars("asdfghjklqwertyuiope"));
		System.out.println(arr.permutation("surajt", "jaruss"));
		System.out.println(arr.permutationByUsingMap("surajt", "jaruss"));
		char[] tempChar = "Mr John Smith    ".toCharArray();
		arr.replaceSpaces(tempChar , 13);
		System.out.println(tempChar);
		System.out.println(arr.isPermutationOfPalindrome("Tact Coap"));
		System.out.println(arr.oneEditAway("TactCoap","TacCoap"));
		System.out.println(arr.compress("aabcccccaaadfsghajksd"));
		int matrix[][] = {{1,2 ,3, 4},{5, 0, 7, 8},{9, 10, 11, 12},{13, 14, 15, 16}};
		//System.out.println(arr.rotate(matrix));
		arr.printMatrix(matrix, 4, 4);
		arr.setzeros(matrix);
		arr.printMatrix(matrix, 4, 4); */
		System.out.println(arr.isRotation("waterbottle", "bottlewater"));
	}
}
