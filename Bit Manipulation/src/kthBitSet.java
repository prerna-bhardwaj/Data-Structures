
public class kthBitSet {
	public static void main(String[] args) {
		System.out.println(kthBitSetNaive(7, 3));
		System.out.println(usingLeftShift(7, 3));
		System.out.println(usingRightShift(7, 3));
	}

	private static boolean usingRightShift(int n, int k) {
		n = n >> (k-1);
		return (n & 1) == 1;
	}

	private static boolean usingLeftShift(int n, int k) {
		int temp = 1 << (k-1);
		return (n&temp) != 0;
	}

	private static boolean kthBitSetNaive(int n, int k) {
		int cnt = 1;
		while(cnt < k) {
			n /= 2;
			cnt++;
		}
		return n%2 == 1;
	}
}
