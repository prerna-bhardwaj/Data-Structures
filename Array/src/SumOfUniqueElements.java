import java.util.*;

public class SumOfUniqueElements {

	// O(n) time | O(1) space
	public static int sumOfUniqueOptimal(int[] nums) {
        int arr[] = new int[105];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(arr[nums[i]] == 1)
                sum -= nums[i];
            arr[nums[i]]++;
            if(arr[nums[i]] == 1)
                sum += nums[i];
        }
        return sum;
    }

	// O(n) time | O(n) space
	public static int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); 
        }
        int sum = 0;
        for(Map.Entry e : map.entrySet()) {
            if((int)e.getValue() == 1)
               sum += (int) e.getKey(); 
        }
        return sum;
    }

    public static void main(String[] args) {
    	int arr[] = {1,2,3,2};
    	System.out.println(sumOfUnique(arr));
    	System.out.println(sumOfUniqueOptimal(arr));
    }
}