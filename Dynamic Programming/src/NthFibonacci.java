import java.util.HashMap;

// 0 1 1 2 3 5 8 13 21 34 ...

public class NthFibonacci {
	
	/*
	 * Contains many duplicate calls for the same number
	 * O(2^n) time | O(n) space   - for call stack
	 */
	private static int fibonacciRecursive(int n) {
		if(n == 1)			return 0;
		else if(n == 2)		return 1;
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}
	
	/*
	 * Second call to same number is a constant time operation.
	 * O(n) time | O(n) space
	 */
	private static int fibonacciMemoization(int n) {
		HashMap<Integer, Integer>hm = new HashMap<>();
		hm.put(1, 0);
		hm.put(2, 1);
		return fibonacciMemoizationHelper(n, hm);
	}
	
	private static int fibonacciMemoizationHelper(int n, HashMap<Integer, Integer> hm) {
		if(hm.containsKey(n))
			return hm.get(n);
		else 
			hm.put(n, fibonacciMemoizationHelper(n-1, hm) + fibonacciMemoizationHelper(n-2, hm));
		return hm.get(n);
	}

	// O(n) time | O(1) space
	private static int fibonacciEfficient(int n) {
		int lastTwo[] = new int[] {0, 1};
		int count = 3;
		while(count <= n) {
			int temp = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = temp;
			count++;
		}
		return n > 1 ? lastTwo[1] : 0;
 	}
	
	public static void main(String args[]) {
		System.out.println("Recursive : " + fibonacciRecursive(10));
		System.out.println("Memoization : " + fibonacciMemoization(10));
		System.out.println("Efficient : " + fibonacciEfficient(10));
	}
}
