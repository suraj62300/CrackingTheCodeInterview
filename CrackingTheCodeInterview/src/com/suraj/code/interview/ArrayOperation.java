package com.suraj.code.interview;

import java.io.*;
import java.util.*;

public class ArrayOperation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine().trim());
		String[] arr_A = br.readLine().split(" ");
		int[] A = new int[N];
		for (int i_A = 0; i_A < arr_A.length; i_A++) {
			A[i_A] = Integer.parseInt(arr_A[i_A]);
		}
		String[] arr_B = br.readLine().split(" ");
		int[] B = new int[N];
		for (int i_B = 0; i_B < arr_B.length; i_B++) {
			B[i_B] = Integer.parseInt(arr_B[i_B]);
		}

		int out_ = winCount(A, B);
		System.out.println(out_);

		wr.close();
		br.close();
	}

	static int myXOR(int x, int y) {
		return (x | y) & (~x | ~y);
	}

	static int max(int x, ArrayList<Integer> arr) {
		int maxVal = x;
		for (Integer i : arr) {
			int temp = myXOR(x, i);
			// System.out.println(temp);
			if (maxVal < temp) {
				maxVal = temp;
			}
		}
		return maxVal;
	}

	static int winCount(int[] A, int[] B) {

		ArrayList<Integer> D1 = new ArrayList<Integer>();
		ArrayList<Integer> D2 = new ArrayList<Integer>();
		
		int len = A.length;
		int[][] xorArr1 = new int[len][len];
		int[][] xorArr2 = new int[len][len];
		
		int temp1 = 0, temp2 = 0;

		for (int i = 0; i < A.length; i++) {
			if (D1.size() == 0) {
				temp1 = A[i];
			} else {
				for (Integer i1 : D1) {
					if(xorArr1[i][i1] != 0) {
						temp1 = xorArr1[A[i]][i1];
					} else {
						int maxVal = A[i];
						int temp = myXOR(A[i], i1);
						// System.out.println(temp);
						if (maxVal < temp) {
							maxVal = temp;
						}
						xorArr1[A[i]][i1] = maxVal;
					}
					temp1 = xorArr1[A[i]][i1];
				}
				//temp1 = max(A[i], D1);
			}
			if (D2.size() == 0) {
				temp2 = B[i];
			} else {
				for (Integer i1 : D2) {
					if(xorArr2[B[i]][i1] != 0) {
						temp2 = xorArr2[B[i]][i1];
					} else {
						int maxVal = B[i];
						int temp = myXOR(B[i], i1);
						// System.out.println(temp);
						if (maxVal < temp) {
							maxVal = temp;
						}
						xorArr1[A[i]][i1] = temp;
					}
					temp2 = xorArr1[A[i]][i1];
				}
				//temp2 = max(B[i], D2);
			}

			if (temp1 > temp2) {
				D2.add(B[i]);
			} else if (temp1 < temp2) {
				D1.add(A[i]);
			} else {
				// continue;
			}
			// System.out.println(D1);
			// System.out.println(D2);
		}
		// System.out.println(D2);
		return D2.size();
	}
}