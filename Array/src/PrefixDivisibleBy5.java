/*

You are given a binary array nums (0-indexed).

We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).

For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.

Return an array of booleans answer where answer[i] is true if xi is divisible by 5.

*/

import java.util.*;

class PrefixDivisibleBy5 {

	public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean>ans = new ArrayList();
        long curr = 0;
        for(int num : nums) {
            curr = curr * 2 + num;
            if(curr % 5 == 0)
                ans.add(true);
            else
                ans.add(false);
            // NOTE : this step avoids integer overflow (for arr size in range of [0, 10^5]).
            curr %= 5;
        }
        return ans;
    }

    public static void main(String[] args) {
    	int arr[] = {1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0};
    	System.out.println(prefixesDivBy5(arr));
    }
}