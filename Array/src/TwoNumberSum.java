import java.util.Arrays;
import java.util.HashSet;

/*
 * 1. Use 2 for loops - TC - O(n^2) and SC - O(1)
 * 2. Use hashset - TC - O(n) and SC - O(n)
 * 3. Use 2 Pointer method - TC - O(n) and SC - O(1)
 * 
 * Method 1 and 2 - work for unsorted array
 * Method 3 - work for sorted array
 */
public class TwoNumberSum {
	
	// O(n^2) time | O(1) space
	private static int[] sumBy2ForLoopMethod(int[] arr, int sum) {
		for(int i = 0; i < arr.length; i++) {
			int first = arr[i];
			for(int j = i+1;j < arr.length; j++) {
				int second = arr[j];
				if(first + second == sum)
					return new int[] {first, second};
			}
		}
		return new int[0];
	}
	
	// O(n) time | O(n) space
	private static int[] sumByHashsetMethod(int[] arr, int sum) {
		HashSet<Integer>hs = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
			if(hs.contains(sum - arr[i]))
				return new int[] {arr[i], sum-arr[i]};
			hs.add(arr[i]);
		}
		return new int[0];
	}
	
	// O(n) time | O(1) space 				- for sorted array
	// O(nlogn) time | O(1) space			- for unsorted array
	private static int[] sumBy2PointerMethod(int[] arr, int sum) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int currSum = arr[left] + arr[right];
			if(currSum == sum)
				return new int[] {arr[left], arr[right]};
			else if(currSum > sum)
				right--;
			else
				left++;
		}
		return new int[0];
	}
	
	public static void main(String args[]) {
		// Array contains all unique values
		int[] arr = {4, 1, -2, 7, 8, 11};
		
		System.out.println(Arrays.toString(sumBy2ForLoopMethod(arr, 6)));
		System.out.println(Arrays.toString(sumByHashsetMethod(arr, 6)));
		System.out.println(Arrays.toString(sumBy2PointerMethod(arr, 6)));
	}
}
