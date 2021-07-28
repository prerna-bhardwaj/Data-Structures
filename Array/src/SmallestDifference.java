import java.util.Arrays;
/*
 * 1. Use 2 for loops					- O(n^2) time | O(1) space
 * 2. Sort and use 2-ptr approac		- O(nlog(n) + mlog(m)) time - req for sorting | O(1) space - if sorting is done in place, 
 * 																					else it is the amt of space req for the sorting algo used.
 */
public class SmallestDifference {

	private static int[] smallestDifference(int[] ar1, int[] ar2) {
		int ptr1 = 0, ptr2 = 0;
		int diff = Integer.MAX_VALUE;
		int[] smallestPair = new int[2];
		
		Arrays.sort(ar1);
		Arrays.sort(ar2);
		
		while(ptr1 < ar1.length && ptr2 < ar2.length) {
			System.out.println(ar1[ptr1] + " " + ar2[ptr2]);
			int temp = Math.abs(ar1[ptr1] - ar2[ptr2]);
			if(temp < diff) {
				diff = temp;
				smallestPair = new int[]{ar1[ptr1], ar2[ptr2]};
			}
			if(ar1[ptr1] < ar2[ptr2])
				ptr1++;
			else if(ar2[ptr2] < ar1[ptr1])
				ptr2++;
			else	// both numbers are equal to each other, thus smallest diff of 0 is obtained.
				return new int[] {ar1[ptr1], ar2[ptr2]};
		}	
		
		return smallestPair;
	}
	
	public static void main(String args[]) {
		int ar1[] = {-1, 5, 10, 28, 20, 3};
		int ar2[] = {26, 134, 15, 135, 17};
		
		// 28 and 26 -> Answer = 2
		int[] result = smallestDifference(ar1, ar2);
		System.out.println(Arrays.toString(result) + " = " + Math.abs(result[0] - result[1]));
	}
}
