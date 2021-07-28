
/*
 * Array is monotonic if it is entirely non-increasing / entirely non-decreasing.
 */
public class MonotonicArray {
	
	// O(n) time | O(1) space
	private static boolean isMonotonic(int[] arr) {
		boolean increasing = true;
		if(arr.length <= 1)		return true;
		int i = 0;
		// Traverse all elements having same value
		while(i < arr.length - 1 && arr[i] == arr[i+1])
			i++;
		if(i == arr.length)		return true;
		// Check for monotonically decreasing
		if(arr[i] > arr[i+1])
			increasing = false;

		// Check for monotonically increasing array
		if(increasing) {
			while(i < arr.length-1 && arr[i] <= arr[i+1])
				i++;
			if(i == arr.length-1)
				return true;
		}
		// Check for monotonically decreasing array
		else {
			while(i < arr.length -1 && arr[i] >= arr[i+1])
				i++;
			if(i == arr.length-1)	return true;
		}
		return false;
	}

	// O(n) time | O(1) space
	public static boolean isMonotonicSimple(int[] arr) {
        int inc = 0, dec = 0, equal = 0;
        int i = 0;
        while(i < arr.length - 1) {
            if(arr[i] < arr[i+1])
                inc++;
            else if(arr[i] > arr[i+1])
                dec++;
            else 
            	equal++;
            if(inc > 0 && dec > 0)
            	return false;
            i++;
        }
        if(inc + equal == arr.length-1 || dec + equal == arr.length-1)
            return true;
        return false;
    }
	
	// O(n) time | O(1) space
	private static boolean isMonotonicEfficient(int[] arr) {
		boolean inc = true, dec = true;
        for(int i = 0 ; i < arr.length - 1; i++) {
            if(arr[i] > arr[i+1])
                inc = false;
            if(arr[i] < arr[i+1])
                dec = false;
        }
        // If both are True, then either all elements have same value or array is empty.
        return inc || dec;
	}
	
	public static void main(String args[]) {
		// Array may contain duplicate values
		int[] arr = {1, 2, 3, 41 ,4, 5, 6};
//		int[] arr = {1, 2, 2, 3};
		System.out.println(isMonotonic(arr));
		System.out.println(isMonotonicSimple(arr));
		System.out.println(isMonotonicEfficient(arr));
	}

}
