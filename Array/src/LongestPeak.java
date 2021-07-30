/*
 * Strictly and only increasing or decreasing or flat arrays have no peaks.
 * 
 * 1. Find and store all the peaks - O(n) time
 * 2. Iterate over all peaks and find compare their lengths - O(n) 
 * Step 2 takes O(n) time since we have /\/\_/\/\ formation.
 * Thus, other than a few duplicate nodes, we are going to visit all or some of the nodes
 * only once while calc the peak length. 
 */
public class LongestPeak {
	
	// O(n) time | O(1) space
	/*
	 * In this function the both side valleys are visited twice : 
	 * 		1. while finding peaks
	 * 		2. while calculating length of left side valley
	 * Whereas, the right side valley is visited once :
	 * 		1. when calculation length of right side valley
	 * 		2. while finding the next peak 
	 *  
	 *     //\\   //\\	  //\\
	 *  __//  \\_//  \\__//  \\___
	 */
		private static int longestPeak(int[] ar) {
		int maxLength = 0;
		if(ar.length <= 2)	return 0;
		for(int i = 1; i < ar.length-1; i++) {
			// Find strictly increasing value for peak. Plateaus are not to be considered.
			if(ar[i] > ar[i+1] && ar[i] > ar[i-1]) {
				int currLength = calculatePeakLength(ar, i);
				maxLength = currLength > maxLength ? currLength : maxLength;
			}
		}
		return maxLength;
	}
	
	private static int calculatePeakLength(int[] ar, int peak) {
		int left = peak;
		System.out.println("Calc peak len for : " + peak);
		while(left > 0 && ar[left] > ar[left-1]) 
			left--;

		System.out.println(ar[left] + " " + left);
		int right = peak;
		while(right < ar.length - 1 && ar[right] > ar[right + 1]) 
			right++;

		System.out.println(ar[right] + " " + right);
		int count = right - left + 1;
		System.out.println(count);
		
		return count;
	}
	
	// O(n) time | O(1) space
	/*
	 * In this function the left side valley is visited twice : 
	 * 		1. while finding peaks
	 * 		2. while calculating length of left side valley
	 * Whereas, the right side valley is visited once : 
	 * 		1. when calculation length of right side valley
	 *  Loop counter 'i' is then shifted to the left side bottom of the next peak/the start of the plateau region
	 *  
	 *     //\   //\	//\
	 *  __//  \_//  \__//  \___
	 */
	private static int longestPeakEfficient(int[] ar) {
		int maxLength = 0;
		if(ar.length <= 2)	return 0;
		for(int i = 1; i < ar.length-1; i++) {
			// Find strictly increasing value for peak. Plateaus are not to be considered.
			if(ar[i] > ar[i+1] && ar[i] > ar[i-1]) {
				int left = i, right = i;
				while(left > 0 && ar[left] > ar[left-1]) 
					left--;
				while(right < ar.length - 1 && ar[right] > ar[right + 1]) 
					right++;
				int currLength = right - left + 1;
				System.out.println(left + " " + right + " " + currLength);
				maxLength = currLength > maxLength ? currLength : maxLength;
				i = right;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int ar[] = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
		System.out.println(longestPeak(ar));
		System.out.println(longestPeakEfficient(ar));
	}
	
}
