/*

The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).

For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs 
(nums[w], nums[x]) and (nums[y], nums[z]) is maximized.

Return the maximum such product difference.

Solution : Basically find the 2 largest and 2 smallest numbers. And return max1*max2 - min1*min2.

*/

import java.util.*;

public class MaxProductDiffBtwPairs {

	// O(nlogn) time | O(1) space
	public static int maxProductDifferenceSort(int[] nums) {
		Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1] * nums[n-2]) - (nums[0] * nums[1]); 
	}

	// O(n) time | O(1) space
	public static int maxProductDifference(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, minIndex = 0;
        int max1 = 0, max2 = 0, maxIndex = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min1) {
                min1 = nums[i];
                minIndex = i;
            }
            if(nums[i] > max1) {
                max1 = nums[i];
                maxIndex = i;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min2 && minIndex != i) {
                min2 = nums[i];
            }
            if(nums[i] > max2 && i != maxIndex) {
                max2 = nums[i];
            }
        }
        return (max1 * max2) - (min1 * min2);
    }

    public static void main(String[] args) {
    	int arr[] = {1,6,7,5,2,4,10,6,4};
    	System.out.println(maxProductDifference(arr));
    	System.out.println(maxProductDifferenceSort(arr));
    }
}

/*
[5,6,2,7,4] = 34
[4,2,5,9,7,4,8] = 64
[1,6,7,5,2,4,10,6,4] = 68
*/