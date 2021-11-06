/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such
that nums[i] == nums[j] and abs(i - j) <= k.

*/

import java.util.*;

class ContainsDuplicate {

	// Solved using Sliding Window protocol
	public static boolean containsDuplicateSlidingWindow(int[] nums, int k) {
        final Set<Integer> currentNumbers = new HashSet<Integer>(k);
        
        for (int index = 0; index < nums.length; index++) {
            if (currentNumbers.contains(nums[index])) {
                return true;
            } else {
                currentNumbers.add(nums[index]);
            }
            if (index >= k) {
                currentNumbers.remove(nums[index - k]);
            }
        }
        return false;
    }

    // Solved using hashmap
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int diff = Math.abs(i - map.get(nums[i]));
                if(diff <= k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
    	int nums[] = {1,2,3,1,2,3};
    	int k = 2;
    	System.out.println(containsDuplicateSlidingWindow(nums, k));
    	System.out.println(containsNearbyDuplicate(nums, k));
    }
}