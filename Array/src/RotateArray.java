/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Extra Space solution : create new rotated array and copy it back into nums. O(n) time | O(k) space
Rotate by One (Naive) : O(nk) time | O(1) space
Reversing solution : O(n) time | O(1) space
Cyclic Dependency :  it builds on the idea of placing each element in its original position while keeping track of the element 
					originally in that position. Basically, at every step, we place an element in its rightful position and keep 
					track of the element already there or the one being overwritten in an additional variable. We can't do this 
					in one linear pass and the idea here is based on cyclic-dependencies between elements.
		O(n) time | O(1) space

*/

public class RotateArray {
	
	// O(nk) time | O(1) space
	public static void rotate(int[] nums, int k) {
        for(int i = 1; i <= k; i++)
            rotateOnce(nums);
    }
    

    public static void rotateOnce(int[] nums) {
        int n = nums.length;
        int last = nums[n-1];
        for(int i = n-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }

	// O(n) time | O(1) soace
	public static void rotateOptimized(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1-k);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    
    public static void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6,7};
		int k = 2;

	}
}