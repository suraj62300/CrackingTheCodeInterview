package com.suraj.code.interview;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ShiftTheSpecialCharacters {
//				0123456789AB
	//Input ->  12346@3#4!3*
	//Output -> 12346343@#!*
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		char[] charArray = input.toCharArray();
		Queue<Character> queue = new ArrayDeque<Character>();
		int j=0;
		for(int i=0;i<charArray.length && j<charArray.length;) {
			if(charArray[i] >= '0' && charArray[i] <= '9') {
				charArray[j++] = charArray[i]; 
			} else {
				queue.add(input.charAt(i));
			}
			i++;
		}
		while(!queue.isEmpty()) {
			charArray[j++] = queue.poll();
		}
		System.out.println(charArray);
		sc.close();
	}

}
