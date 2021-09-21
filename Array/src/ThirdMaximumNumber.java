/*
Given an integer array nums, return the third distinct maximum number in this array. 
If the third maximum does not exist, return the maximum number.

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

*/

public class ThirdMaximumNumber {
	public static int thirdMax(int[] nums) {
        Integer max1=null, max2=null, max3=null;
        for(int num : nums) {
            if(max1 == null || num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num != max1) {
                if(max2 == null || num > max2) {
                    max3 = max2;
                    max2 = num;
                }
                else if(num != max2) {
                    if(max3 == null || num > max3)
                        max3 = num;
                }
            } 
        }
        return (max3 == null) ? max1 : max3;
    }

    public static void main(String[] args) {
    	int arr[] = {1,2,2,5,3,5};
    	System.out.println(thirdMax(arr));
    }
}