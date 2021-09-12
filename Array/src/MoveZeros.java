/*
283. Move Zeros

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.
*/
import java.util.*;

public class MoveZeros {
	/*
	A two-pointer approach could be helpful here. The idea would be to have one pointer for iterating the array and 
	another pointer that just works on the non-zero elements of the array.
	O(n) time | O(1) space
	*/
	public static void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, n = nums.length;
        if(n == 0 || n == 1)
            return;
        while(fast < n) {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while(slow < n) {
            nums[slow++] = 0;
        }
    }

    public static void main(String[] args) {
    	int arr[] = {0 ,1, 0, 3, 12};
    	moveZeroes(arr);
    	System.out.println(Arrays.toString(arr));
    }
}