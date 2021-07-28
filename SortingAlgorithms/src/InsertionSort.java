import java.util.Arrays;

public class InsertionSort {
	// O(n^2) time | O(1) space 
	private static void insertionSort(int[] ar) {
		for(int i = 1;i < ar.length; i++) {
			int temp = ar[i];
			int cntr = i-1;
			System.out.println(cntr +" " + i + " " + ar[i]);
			while(cntr >= 0 && ar[cntr] > temp) {
				ar[cntr+1] = ar[cntr];
				cntr--;
			}
			ar[cntr+1] = temp;
			System.out.println(Arrays.toString(ar));
		}
	}
	
	public static void main(String[] args) {

		int[] ar = {8, 3, 5, 6, 5, 9, 2, 1, 10, 0};
		insertionSort(ar);
		System.out.println(Arrays.toString(ar));
	}
}
