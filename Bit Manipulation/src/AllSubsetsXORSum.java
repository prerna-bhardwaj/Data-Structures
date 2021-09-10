/*
1863. Sum of All Subset XOR Totals

The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
Given an array nums, return the sum of all XOR totals for every subset of nums. 

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.

Time : O(n*2^n)
Space : O(n)

*/

import java.util.*;

public class AllSubsetsXORSum {
	static int sum, k;
    public static int subsetXORSum(int[] nums) {
        sum = 0;
        for(int i = 0; i <= nums.length; i++) {
            k = i;
            solve(nums, new ArrayList<Integer>(), 0);
        }
        return sum;
    }
    
    public static void solve(int nums[], ArrayList<Integer> ar, int index) {
        if(ar.size() == k) {
            sum += getXor(ar);
            return;
        }
        for(int i = index; i < nums.length; i++) {
            ar.add(nums[i]);
            solve(nums, ar, i + 1);
            ar.remove(ar.size()-1);
        }
    }
    
    public static int getXor(ArrayList<Integer> a) {
        int xor = 0;
        for(int num : a) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
    	int nums[] = {5, 1, 6};
    	subsetXORSum(nums);
    	System.out.println(sum);
    }
}
/*

Input: nums = [5,1,6]
Output: 28
Explanation: The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28

*/