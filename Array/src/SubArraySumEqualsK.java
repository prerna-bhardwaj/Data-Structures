/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
Solution:
Store frequencies in a hashmap. 
*/
import java.util.*;

public class SubArraySumEqualsK {
	// Using Hashing
	// O(n) time | O(n) space
	public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        // Note : 0 isiliye dala hai, kyunki agar 0 to index i tak ka sum = k, then sum-k = 0 should exist in the map.
        map.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)) 
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

	public static void main(String[] args) {
		// int arr[] = {1,2,3}, k = 3;
		int arr[] = {-1, 1, 0}, k = 0;
		System.out.println(subarraySum(arr, k));
	}
}