import java.util.*;
/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, 
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. 
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, 
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/

public class MergeSortedArray {
	// O(n1 + n2) time | O(1) space
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        int a = m-1, b = n-1, c = m+n-1;

        while(a >= 0 && b >= 0) {
            if(nums1[a] > nums2[b]) {
                nums1[c--] = nums1[a--];
            }
            else {
                nums1[c--] = nums2[b--];
            }
        }
        while(b >= 0) {
            nums1[c--] = nums2[b--];
        }
    }

    public static void main(String[] args) {
    	int a1[] = {1,2, 3, 0, 0, 0, 0}, a2[] = {2, 3, 5, 7};
    	int m = 3, n = 4;
    	merge(a1, m, a2, n);
    	System.out.println(Arrays.toString(a1));
    }
}