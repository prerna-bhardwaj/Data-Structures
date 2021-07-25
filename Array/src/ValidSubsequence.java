
public class ValidSubsequence {

	public static void main(String[] args) {
		int arr[] = new int[] {5, 1, 22, 25, 6, -1, 8, 10};
		int[] sequence = new int[] {1, 6, -1, 10};
		System.out.println(isValidSubsequence(arr, sequence));
		System.out.println(isValidSubsequence2(arr, sequence));
	}

	// O(n) time | O(1) space
	private static boolean isValidSubsequence(int[] arr, int[] sequence) {
		int ptr1 = 0, ptr2 = 0;
		while(ptr1 < arr.length && ptr2 < sequence.length) {
			// Increment ptr2 only when a match is found
			if(arr[ptr1] == sequence[ptr2]) 
				ptr2++;
			ptr1++;
		}
		return ptr2 == sequence.length;
	}
	
	// O(n) time | O(1) space
	private static boolean isValidSubsequence2(int[] arr, int[] sequence) {
		int index = 0;
		for(int ele : arr) {
			// Helps in breaking early i.e. when the sequence has been validated
			// NOTE : Put this condition on top, bcz neeche we are ++ index, so we might get an ArrayIndexOutOfBounds error
			if(index == sequence.length)
				return true;		// OR break
			if(sequence[index] == ele)
				index++;
		}
		return index == sequence.length;
	}
}