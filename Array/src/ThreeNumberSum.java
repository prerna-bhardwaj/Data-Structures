import java.util.ArrayList;
import java.util.Arrays;

/*
 * 1. Use 3 for loops					- O(n^3) time | O(1) space
 * 2. Use hashtable for lookup			- O(n^2) time | O(n) space - req for hashtable
 * 3. Sort and 2-ptr approach			- O(n^2) time | O(n) space - required to store result
 */
public class ThreeNumberSum {

	private static ArrayList<Integer[]> threeNumberSum(int[] arr, int target) {
		ArrayList<Integer[]> result = new ArrayList<Integer[]>();
		if(arr.length <= 2)		return result;
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length-2; i++) {
			int left = i+1, right = arr.length-1;
			while(left < right) {
				int sum = arr[i] + arr[left] + arr[right];
				if(sum == target) {
					Integer[] temp = {arr[i], arr[left], arr[right]};
					result.add(temp);
					left++;
					right--;
				}
				else if(sum < target)
					left++;
				else 
					right--;
			}
		}
		return result;
	}
	
	public static void main(String args[]) {
		// Array contains all unique values
		int[] arr = {12, 3, 1, 2, -6, 5, 6, -8};
		ArrayList<Integer[]> result = threeNumberSum(arr, 0);
		for(Integer[] ele : result)
			System.out.println(Arrays.toString(ele));
	}

}
