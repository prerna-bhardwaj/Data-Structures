/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of 
all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. 
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

NOTE : The element corr to the pivot index is not included in the left and right sum.

SOLUTIONS :
1. (1 prefix array + var) - O(n) time | O(n) space
2. (2 prefix arrays) - O(n) time | O(2n) space
3. 2 vars - O(n) time | O(1) space
*/

public class PivotIndex {
	// O(n) time | O(1) space
	public static int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for(int num : nums)     sum += num;
        for(int i = 0; i < nums.length; i++) {
        	// 0 <----left------> i <-----(sum - left-nums[i]) -----> n
        	// here sum = left + nums[i] + right
        	// thus, right = sum - left - nums[i]
        	// check if left == right
            if(left == sum - left - nums[i])
                return i;
            left += nums[i];
        }
        return -1;
    }
}