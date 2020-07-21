package com.suraj.code.interviewbit;


/*You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.*/

//Input:[3 1 2 5 3] 
//Output:[3, 4]

public class RepeatAndMissingNumberArray {
	
	public static int[] repeatedNumber(final int[] A) {
        long sum = 0, sumSquares = 0;
        for (int i = 1; i <= A.length; i++) {
            sum += A[i-1] - i;
            sumSquares += A[i-1]*(long)A[i-1] - i*(long)i;
        }
        long AminusB = sum, AplusB = sumSquares / sum;
        return new int[] {(int)((AplusB+AminusB)/2), (int)((AplusB-AminusB)/2)};
    }

	public static void main(String[] args) {

		int input[] = {1, 2, 3, 5, 6, 7, 6};
		int output[] = RepeatAndMissingNumberArray.repeatedNumber(input);
		System.out.println(output[0] +" "+output[1]);
	}

}
