
public class CountSetBitsInARange {
	public static void main(String[] args) {
		System.out.println(" : 355 : " + countSetBits(355, 2, 8));
	}

	
	private static int countSetBits(int n, int a, int b) {
		printBinRep(n);
		int cnt = 0;
		for(int i = a; i <= b; i++) {
			if((n & (1<<(i-1))) != 0)
				cnt++;
		}
		return cnt;
	}


	private static void printBinRep(int n) {
		StringBuilder st = new StringBuilder();
		while(n != 0) {
			st.append(n%2);
			n /= 2;
		}
		System.out.print(st.reverse().toString() + " ");
	}
}
