import java.util.Arrays;

public class SelectionSort {
	
	// O(n^2) time | O(1) space 
	private static void selectionSort(int[] ar) {
		int minIndex = 0;
		int n = ar.length;
		for(int i = 0; i < n; i++) {
			minIndex = i;
			for(int j = i+1; j < n; j++) {
				if(ar[j] < ar[minIndex]) {
					minIndex = j;
				}
			}
			System.out.println(i + " " + minIndex);
			// Reduces TC of best case to O(n)
			if(i == minIndex)
				break;
			swap(ar, i, minIndex);
		}
	}
	
	private static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;		
	}

	public static void main(String[] args) {
		int[]ar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};				// best case
//			int[] ar = {8, 3, 5, 6, 4, 9, 2, 1, 10};				// average case
//			int[] ar = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};			// worst case
		selectionSort(ar);
		System.out.println(Arrays.toString(ar));
	}
}
