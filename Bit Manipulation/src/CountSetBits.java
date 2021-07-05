// Lookup table soln is also possible with TC - O(1)

public class CountSetBits {
	public static void main(String[] args) {
		int x = 1;
		for(int i = 1; i<= 32; i++)
			System.out.println(1<<i);
		
		System.out.println("100 : " + countSetBitsNaive(100));
		System.out.println("1000 : " + countSetBits2(1000));
		System.out.println("10 : " + brianKernighanAlgo(10));
	}

	// TC - O(No of Set Bits in n)
	private static int brianKernighanAlgo(int n) {
		int cnt = 0;
		while(n > 0) {
			// Removes the rightmost set bit of n
			n = n & (n-1);
			cnt++;
		}
		return cnt;
	}

	// TC - O(Total No Of Bits in n)
	private static int countSetBits2(int n) {
		int cnt = 0;
		while(n != 0) {
			if((n & 1) != 0)	
				cnt++;
			// OR
//			cnt += (n&1);
			n = n >> 1;
		}
		return cnt;
	}

	// TC - O(Total No Of Bits in n)
	private static int countSetBitsNaive(int n) {
		int cnt = 0;
		while(n != 0) {
			cnt += n%2;
			n /= 2;
		}
		return cnt;
	}
}
