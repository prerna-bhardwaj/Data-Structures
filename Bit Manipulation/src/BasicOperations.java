
public class BasicOperations {
	public static void main(String args[]) {
		System.out.println(getBit(5, 2));
		System.out.println(setBit(5, 1));
		System.out.println(clearBit(5, 2));
		System.out.println(updateBit(5, 0, 0));
	}
	
	private static int updateBit(int n, int k, int val) {
		// Clear the k'th bit
		n = n & ~(1<<k);
		// Set the k'th bit with value
		int mask = val<<k;
		return n | mask;
	}
	
	private static int clearBit(int n, int k) {
		return n&~(1<<k);
	}

	private static int setBit(int n, int k) {
		return n|(1<<k);
	}
	
	private static boolean getBit(int n, int k) {
		return (n&(1<<k)) != 0;
	}
}
