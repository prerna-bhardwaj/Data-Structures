/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.

Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].
*/

public class SelfDividingNumbers {
	
	/*
	Time Complexity: O(D), where D is the number of integers in the range [L, R], and assuming log(R) is bounded. 
					(In general, the complexity would be O(Dlog R).)

	Space Complexity: O(D), the length of the answer.
	*/
	public List<Integer> selfDividingNumbersOptimized(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
    public boolean selfDividing(int n) {
    	// NOTE : convert to string for ease in computation
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

    // O(DlogR) time | O(D) space
	public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = left; i <= right; i++) {
            if(isValid(i))
                res.add(i);
        }
        return res;
    }
    
    public static boolean isValid(int num) {
        int temp = num;
        while(temp != 0) {
            int val = temp % 10;
            if(val == 0)
                return false;
            if(num % val != 0)
                return false;
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
    	System.out.println(selfDividingNumbers(4, 24));
    }
}