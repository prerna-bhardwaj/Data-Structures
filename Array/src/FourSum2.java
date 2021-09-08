/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

 	0 <= i, j, k, l < n
 	nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
*/
public class FourSum2 {

	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        if(nums1.length == 0 || nums2.length == 0 || nums3.length == 0 || nums4.length == 0)
            return 0;
        int count = 0;
        HashMap<Integer, Integer>hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i = 0; i < nums3.length; i++) {
            for(int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                count += hm.getOrDefault(0 - sum, 0);
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int a[] = {};
		int b[] = {};
		int c[] = {};
		int d[] = {};

		System.out.println(fourSumCount(a, b, c, d));
	}
}