/*Given two sorted arrays A and B, such that the arrays may have some common elements.

Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays.

We can switch from one array to another array only at common elements.

NOTE: The common elements do not have to be at the same indexes.

Problem Constraints
1 <= |A|, |B| <= 105

1 <= A[i], B[i] <= 103

Input Format
First argument is an integer array A.
Second argument is an integer array B.

Output Format
Return a single integer denoting the maximum sum path.

Example Input
Input 1:

 A = [2, 3, 7, 10, 12]
 B = [1, 5, 7, 8]
 
Input 2:

 A = [10, 12]
 B = [5, 7, 9]

Example Output
Output 1:

 35
Output 2:

 22


Example Explanation
Explanation 1:

 35 is sum of 1 + 5 + 7 + 10 + 12. We start from the first element of B which is 1, then we move to 5, then 7.
 From 7, we switch to A (as 7 is common) and traverse 10 and 12.
Explanation 2:

 22 is the sum of 10 and 12. Since there is no common element, we need to take all elements from the array with more sum.
*/


package com.suraj.code.interviewbit;

class Solution {
    public int solve(int[] A, int[] B) {
		int sum1 = 0, sum2 = 0, result = 0;
		for(int i = 0; i<A.length && i<B.length ; i++){
			if(A[i] < B[i]){
				sum1 = sum1 + A[i];
			} else if (A[i] > B[i]){
				sum2 = sum2 + B[i];
			} else {
				int max = sum1 > sum2 ? sum1:sum2;
				result = result + max + A[i];
			}
		}
		return result;
	}
    public static void main(String[] args) {
		
	}

}
