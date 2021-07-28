import java.util.Arrays;

public class MoveNumberToEnd {
	public static void main(String[] args) {
		int ar[] = {2, 1, 2, 2, 2, 3, 4, 2};
		
		System.out.println(Arrays.toString(moveElementToEnd(ar, 2)));
	}

	// O(n) time | O(1) space
	private static int[] moveElementToEnd(int[] ar, int element) {
		int start = 0;
		int end = ar.length - 1;
		while(start < end) {
			// remove start < end condition and observe the result
			while(start < end && ar[end] == element)
				end--;
			if(ar[start] == element) {
				ar[start] = ar[end];
				ar[end] = element;
			}
			start++;
		}
		return ar;
	}
}
