package com.suraj.code.interviewbit;

public class SpiralOrderMatrixI {
	
	/* input
	 * [
	   T [ 1, 2, 3 ],
	     [ 4, 5, 6 ],
	   B [ 7, 8, 9 ]
	   ]   L     R
	   
	   output : [1, 2, 3, 6, 9, 8, 7, 4, 5]
	*/
	
	public static int[] spiralOrder(final int[][] A) {
       int m = A.length;
       int n = A[0].length;
       int i = 0, j=0; 
       int result[] = new int[m*n];
       int T = 0, B = m-1, L = 0, R = n-1;
       int dir = 0;
       while(T <= B && L <=R) {
    	   if(dir == 0) {
    		   for(i=L;i<=R;i++) {
    			   result[j++] = A[T][i];
    			  // System.out.print(A[T][i]);
    		   }
    		   T++;
    	   } else if(dir == 1) {
    		   for(i=T;i<=B;i++) {
    			   result[j++] = A[i][R];
    			  // System.out.print(A[i][R]);
    		   }
    		   R--;
    	   } else if(dir == 2) {
    		   for(i=R;i>=L;i--) {
    			   result[j++] = A[B][i];
    			  // System.out.print(A[B][i]);
    		   }
    		   B--;
    	   } else if(dir == 3) {
    		   for(i=B;i>=T;i--) {
    			   result[j++] = A[i][L];
    			   //System.out.print(A[i][L]);
    		   }
    		   L++;
    	   }
    	   dir = (dir+1)%4;
       }
       return result;
    }

	public static void main(String[] args) {
		int input[][] = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int output[] = SpiralOrderMatrixI.spiralOrder(input);
		for(int i=0;i<output.length;i++) {
			System.out.print(output[i]);
		}
	}

}
