package com.suraj.code.interview;

public class SecloreTest {

	public static String reverseString(String input) {
		
		char[] ch = input.toCharArray();
		int len = ch.length;
		int i=len-1, j=0;
		while(i != j && i > j) {
			char current = ch[i];
			char temp = ch[j];
			while(current == '@' || current == '#' || current == '$' || current == '&') {
				current = ch[i];
				i--;
			}
			while(temp == '@' || temp == '#' || temp == '$' || temp == '&') {
				temp = ch[j];
				j++;
			}
			if(i != j && i > j) {
				char temp1 = ch[i];
				ch[i] = ch[j];
				ch[j] = temp1;
			}
			i--;
			j++;
		}
		
		return new String(ch);
	}
	public static void main(String[] args) {
		
		System.out.println(reverseString("Hello@#$suraj&5WellDone"));
		System.out.println(reverseString("enoDl@#$sleW5&jaruolleH"));

	}
}
