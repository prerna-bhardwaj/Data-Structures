import java.util.*;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number 
sorted in non-decreasing order.

Trivial Solution :  Squaring each element and sorting the new array.
Optimal Solution : 2-pointer approach
*/


public class SortedSqaures {

	// O(n) time | O(1) space
	public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int left = 0, right = nums.length - 1;
        
        for(int i = nums.length-1; i >= 0; i--) {
            int left_sq = square(nums[left]);
            int right_sq = square(nums[right]);

            if(left_sq < right_sq) {
                res[i] = right_sq;
                right--;        
            }
            else {
                res[i] = left_sq;
                left++;
            }
        }
        return res;
    }
    
    public static int square(int x) {
        return x*x;
    }

    public static void main(String[] args) {
    	int arr[] = {-4, -3, 1, 2, 10, 21};
    	System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}