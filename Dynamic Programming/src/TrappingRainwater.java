/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it 
can trap after raining.

Solutions : https://leetcode.com/problems/trapping-rain-water/solution/

1. Brute force : For each element iterate left and right parts
 - O(n^2) time | O(1) space

2. DP - O(n) time | O(n) space
3. Stack - O(n) time | O(n) space
4. 2 ptr approach - O(n) time | O(1) space
*/
class TrappingRainwater {
	
	// DP = O(n) time | O(n) space
	public static int trap(int[] ht) {
        int leftMax = 0, rightMax = 0, n=ht.length;
        int ans[] = new int[ht.length];

        for(int i = 0; i < n; i++) {
            leftMax = Math.max(ht[i], leftMax);
            ans[i] = leftMax;
        }
        
        for(int i = n-1; i >=0; i--) {
            rightMax = Math.max(ht[i], rightMax);
            ans[i] = Math.min(ans[i], rightMax);
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(ans[i] > ht[i])
                sum += ans[i] - ht[i];
        }
        return sum;
    }

	public static void main(String[] args) {
		// Answer = 6
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));		
	}
}