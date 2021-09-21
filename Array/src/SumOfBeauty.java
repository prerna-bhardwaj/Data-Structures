/*
You are given a 0-indexed integer array nums. For each index i (1 <= i <= nums.length - 2) the beauty of nums[i] equals:

2, if nums[j] < nums[i] < nums[k], for all 0 <= j < i and for all i < k <= nums.length - 1.
1, if nums[i - 1] < nums[i] < nums[i + 1], and the previous condition is not satisfied.
0, if none of the previous conditions holds.
Return the sum of beauty of all nums[i] where 1 <= i <= nums.length - 2.

Input: nums = [2,4,6,4]
Output: 1
Explanation: For each index i in the range 1 <= i <= 2:
- The beauty of nums[1] equals 1.
- The beauty of nums[2] equals 0.

*/

public class SumOfBeauty {
	
	// O(n) time | O(n) space
	public static int sumOfBeauties(int[] nums) {
        int res = 0;
        // Max - prefix array - max[i] stores max(nums[i-1], max[i-1])       
        // Min - suffix array - min[i] stores min(nums[i+1], min[i+1])
        int min[] = new int[nums.length], max[] = new int[nums.length];
        max[0] = nums[0];
        min[nums.length-1] = nums[nums.length-1];
        for(int i = 1 ;i < nums.length; i++) {
        	max[i] = Math.max(max[i-1], nums[i-1]);
        }
        for(int i = nums.length-2; i >= 0; i--) {
        	min[i] = Math.min(min[i+1], nums[i+1]);
        }
        for(int i = 1; i < nums.length-1; i++) {
            int con = 0;
            if(max[i] < nums[i] && nums[i] < min[i]) {
                con = 2;
            }
            else if(nums[i-1] < nums[i] && nums[i] < nums[i+1]) 
            	con = 1;
            res += con;
        }
        return res;
    }


	public static void main(String[] args) {
		int arr[] = {2, 4, 6, 4};
		System.out.println(sumOfBeauties(arr));	
	}
}