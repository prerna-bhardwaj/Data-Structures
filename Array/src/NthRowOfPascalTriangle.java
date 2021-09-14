/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
*/

import java.util.*;

public class NthRowOfPascalTriangle {

	// O(n) time | O(n) space - to save answer
	public static List<Integer> getRow(int row) {
        List<Integer>ans = new ArrayList();
        ans.add(1);
        if(row == 0)
            return ans;
        for(int i = 1; i < row; i++) {
            ans.add(getValue(row, i));
        }
        ans.add(1);
        return ans;
    }
    
    // Return nCk 
    public static int getValue(int n, int k) {
        long prod = 1;
        for(int i = 0; i < k; i++) {
            prod *= (long)(n-i);
            prod /= (long)(i+1);
        }
        return (int)prod;
    }

    public static void main(String[] args) {
    	System.out.println(getRow(0));
    	System.out.println(getRow(1));
    	System.out.println(getRow(10));
    	System.out.println(getRow(20));
    }
}