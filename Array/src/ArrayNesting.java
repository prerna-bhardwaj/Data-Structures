/*
You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].

You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:

The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].
*/
import java.util.*;

public class ArrayNesting {

	// O(n^2) time | O(1) space
	public static int arrayNestingNaive(int nums[]) {
		int maxLength = 0;
		for(int i = 0; i < nums.length; i++) {
			int start = nums[i], curr = 0;
			do {
				start = nums[start];
				curr++;	
			}while(start != nums[i]);
			maxLength = Math.max(maxLength, curr);
		}
		return maxLength;
	}

	// O(n) time | O(n) space - for visited array
	public static int arrayNestingUsingVisited(int nums[]) {
		boolean visited[] = new boolean[nums.length];
		int maxLen = 0;

		for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
	            int curr = nums[i];
	            Set<Integer> set = new HashSet<Integer>();
	            while(!set.contains(curr)) {
	                visited[curr] = true;
	                set.add(curr);
	                curr = nums[curr];
	            }
	            // System.out.println(i + " - " + set);
	            maxLen = Math.max(maxLen, set.size());
            }
        }
        return maxLen;
	}


	/*
	 We can mark the visited elements in the original array numsnums itself. We can put a very large integer value 
	 Integer.MAX_VALUE at the position which has been visited.
	*/
	// O(n) time | O(1) space
	public static int arrayNestingEfficient(int nums[]) {
		int maxLength = 0;
		for(int i = 0; i < nums.length; i++) {
			int start = nums[i], curr = 0;
			while(start != Integer.MAX_VALUE) {
				int temp = start;
				start = nums[start];
				nums[temp] = Integer.MAX_VALUE;
				curr++;
			}
			maxLength = Math.max(maxLength, curr-1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int nums[] = {5,4,0,3,1,6,2};
		// System.out.println(arrayNestingNaive(nums));
		// System.out.println(arrayNestingUsingVisited(nums));
		System.out.println(arrayNestingEfficient(nums));
	}
}