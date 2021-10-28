/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest 
to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.
*/

import java.util.*;

class Sum_Closest {
	
	// O(nlogn) time | O(1) space - unless any space is required for merge sort
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int j = i+1, k = nums.length-1;
            while(j < k) {
                int curr = nums[i] + nums[j] + nums[k];
                int currDiff = Math.abs(target - curr);
                if(currDiff < diff) {
                    diff = currDiff;
                    ans = curr;
                }
                if(curr < target)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
    	int arr[] = {-1, 2, 1, -4};
    	int target = 1;
    	// Output = 2
    	System.out.println(threeSumClosest(arr, target));
    }
}