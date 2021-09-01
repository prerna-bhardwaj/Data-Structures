import java.util.Arrays;

public class MergeSort {

	// O(nlogn) TC - O(n) space
	private static void mergeSort(int[] arr, int l, int r) {
		if(l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr, l, mid, r);
			System.out.println(Arrays.toString(arr) + " " + l +  " " + mid + " " + r);
		}		
	}
	
	
	private static void merge(int[] arr, int l, int mid, int r) {
		int len1 = mid - l + 1;			// i.e. mid - (l-1)
		int len2 = r - mid;
		int[] a = new int[len1];
		int[] b = new int[len2];
		
		for(int i = l; i <= mid; i++)
			a[i-l] = arr[i];
		for(int i = mid+1; i <= r; i++)
			b[i-mid-1] = arr[i];
		int i = 0, j = 0, k = l;
		while(i < len1 && j < len2) {
			if(a[i] < b[j]) {
				arr[k++] = a[i++];
			}
			else {
				arr[k++] = b[j++];
			}
		}
		while(i < len1) {
			arr[k++] = a[i++];
		}
		while(j < len2) {
			arr[k++] = b[j++];
		}
		
	}

	
	public static void main(String[] args) {
		int arr[] = {5,4,3,2,1};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
}
