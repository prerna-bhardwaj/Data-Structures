import java.util.*;

/*
1365. How Many Numbers Are Smaller Than the Current Number

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.

*/

public class SmallerNumbersThanCurrent {

	public static int[] smallerNumbersThanCurrent(int[] nums) {
        int temp[] = nums.clone();
        Arrays.sort(temp);
        int n = nums.length;
        
        HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(temp[i])) 
                map.put(temp[i], Math.min(i, map.get(temp[i])));
            else 
                map.put(temp[i], i);
        }
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
    	int arr[] = {8,1,2,2,3};
    	System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }
}

/*

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

*/