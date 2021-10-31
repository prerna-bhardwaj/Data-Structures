/*
You are given a 0-indexed integer array nums containing distinct numbers, an integer start, and an integer goal. 
There is an integer x that is initially set to start, and you want to perform operations on x such that it is converted to goal. 
You can perform the following operation repeatedly on the number x:

If 0 <= x <= 1000, then for any index i in the array (0 <= i < nums.length), you can set x to any of the following:

x + nums[i]
x - nums[i]
x ^ nums[i] (bitwise-XOR)
Note that you can use each nums[i] any number of times in any order. 
Operations that set x to be out of the range 0 <= x <= 1000 are valid, but no more operations can be done afterward.

Return the minimum number of operations needed to convert x = start into goal, and -1 if it is not possible.
*/

import java.util.*;

class MinOperationsToConvertNumber {

	public static int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer>queue = new LinkedList();
        boolean visit[] = new boolean[1005];
        queue.add(start);
        int cnt = 0;

        // Using BFS to find minimum number of operations
        while(!queue.isEmpty()) {
            // For every level
            for(int j = queue.size(); j > 0; j--) {
                // Fetch the curr element and process neighbouring elements
                int curr = queue.poll();
                if(curr == goal)
                    return cnt;
                // If the element lies within the range and is not visited
                if(curr >= 0 && curr <= 1000 && !visit[curr]) {
                	// Mark it as visited
                    visit[curr] = true;
                    // Process adjacent elements
                    for(int num : nums) {
                        queue.add(curr + num);
                        queue.add(curr - num);
                        queue.add(curr ^ num);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
    	int nums[] = {1, 3};
    	int start = 6;
    	int goal = 4;
    	/*
    		We can go from 6 → 7 → 4 with the following 2 operations.
			- 6 ^ 1 = 7
			- 7 ^ 3 = 4
		*/
    	System.out.println(minimumOperations(nums, start, goal));
    }
}