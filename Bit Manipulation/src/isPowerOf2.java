
public class isPowerOf2 {
	public static void main(String[] args) {
		System.out.println("100 : " + isPowerNaive(100));
		System.out.println("2 : " + isPowerNaive(2));
		System.out.println("1 : " + isPowerEfficient(0));
		System.out.println("128 : " + isPowerEfficient(1));
		System.out.println("1280 : " + isPowerEfficient2(1280));
	}
	
	// Using Brian Kernighan's Algo - O(1)
	private static boolean isPowerEfficient2(int n) {
		return n!=0 && (n & (n-1)) == 0;
	}

	// Using Brian Kernighan's Algo - O(1)
	private static boolean isPowerEfficient(int n) {
		if(n == 0)	return false;
		return (n & (n-1)) == 0;
	}

	// Naive soln - O(No of bits)
	private static boolean isPowerNaive(int n) {
		if(n == 0)	return false;
		while(n != 1) {
			if(n%2 == 1)
				return false;
			n /= 2;
		}
		return true;
	}

}
