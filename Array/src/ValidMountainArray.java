/*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

1) arr.length >= 3
2) There exists some i with 0 < i < arr.length - 1 such that:
	arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
	arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
*/


public class ValidMountainArray {
	
	// O(n) time | O(1) space
	public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        int i = 0, n = arr.length;
        // Hill
        while(i < n-1 && arr[i] < arr[i+1])
            i++;
        // Peak cant be the first or the last element
        if(i == 0 || i == n-1)
            return false;
        // Valley
        while(i < n-1 && arr[i] > arr[i+1])
            i++;
        return i == (n-1);
    }

    public static void main(String[] args) {
    	int arr[] = {0, 3, 2, 1};
    	System.out.println(validMountainArray(arr));
    }
}