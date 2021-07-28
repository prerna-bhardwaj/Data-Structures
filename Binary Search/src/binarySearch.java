/*
 * I/p : a sorted array, a target
 * O/p : boolean - whether the array contains the target
 * 
 */
public class binarySearch {
	
	// O(logN) time | O(1) space
	private static int binarySearch(int ar[], int target) {
		int left = 0, right = ar.length - 1;
		while(left <= right) {
			int mid = left + (right - left)/2;
			System.out.println(mid + " " + left + " " + right);
			if(ar[mid] == target)
				return mid;
			else if(ar[mid] > target)
				right = mid-1;
			else
				left = mid + 1;
		}
		return -1;
	}
	
	private static int binarySearchRecursive(int[] ar, int target) {
		return binarySearchHelper(ar, target, 0, ar.length - 1);
	}
	
	// O(logN) time | O(logN) space
	private static int binarySearchHelper(int[] ar, int target, int left, int right) {
		if(left > right)
			return -1;
		int mid = left + (right-left)/2;
		if(ar[mid] == target)
			return mid;
		else if(ar[mid] > target)
			return binarySearchHelper(ar, target, left, mid-1);
		else
			return binarySearchHelper(ar, target, mid+1, right);
	}

	public static void main(String[] args) {
		int[] ar = {0, 1, 21, 33, 45, 45, 61, 71, 73};
		System.out.println(binarySearch(ar, 33));
		System.out.println(binarySearchRecursive(ar, 33));
	}
	
}
