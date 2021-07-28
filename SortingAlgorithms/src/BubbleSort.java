import java.util.Arrays;

public class BubbleSort {
	// O(n^2) time | O(1) space 
	// isSorted is used to reduce TC of best case to O(n) which otherwise would be O(n^2)
	private static void bubbleSort(int[] ar) {
		boolean isSorted = true;
		int n = ar.length;
		for(int i = 0;i < n; i++) {
			isSorted = true;
			for(int j = 0; j < n-i-1; j++) {
				if(ar[j] > ar[j+1]) {
					swap(ar, j, j+1);
					isSorted = false;
				}
			}
			if(isSorted)
				break;
			System.out.println(i + " " + Arrays.toString(ar));
		}
	}
	
	
	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;	
	}


	public static void main(String[] args) {
		int[]ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};				// best case
//		int[] ar = {8, 3, 5, 6, 4, 9, 2, 1, 10};				// average case
//		int[] ar = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};			// worst case
		bubbleSort(ar);
		System.out.println(Arrays.toString(ar));
	}
}
