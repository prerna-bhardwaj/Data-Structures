/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Time : O(N * (2^N))
Space : O(N)
*/

import java.util.*;

public class AllSubsets {
	
	static List<List<Integer>>res;
    static int n, k;
    
    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        n = nums.length;
        // Add all subsets of length i to result list.
        for(int i = 0; i <= n; i++) {
            k = i;
            solve(nums, new ArrayList<Integer>(), 0);
        }
        return res;
    }
    
    public static void solve(int[] nums, ArrayList<Integer>ar, int index) {
        if(ar.size() == k) {
            res.add(new ArrayList<Integer>(ar));
            return;        
        }
        
        for(int i = index; i < nums.length; i++) {
            ar.add(nums[i]);
            solve(nums, ar, i + 1);
            ar.remove(ar.size()-1);
        }
    }

    public static void main(String[] args) {
    	int nums[] = {10, 20, 30};
    	subsets(nums);
    	System.out.println(res);
    }
}