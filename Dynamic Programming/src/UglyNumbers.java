import java.util.Arrays;

/*
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. 
 * Given a number n, the task is to find n’th Ugly number.
 */
public class UglyNumbers {
	
	static int getUglyNumber(int n) {
		int dp[] = new int[n];
		Arrays.fill(dp, 0);
		dp[0] = 1;
		
		int i2 = 0, i3 = 0, i5 = 0;
		int next_mul_2 = 2, next_mul_3 = 3, next_mul_5 = 5;
		for(int i = 1; i < n; i++) {
			int min_value = Math.min(Math.min(next_mul_2, next_mul_3), next_mul_5);
			dp[i] = min_value;
			
			if(dp[i] == next_mul_2) {
				i2++;
				next_mul_2 = dp[i2] * 2;
			}
			if(dp[i] == next_mul_3) {
				i3++;
				next_mul_3 = dp[i3] * 3;
			}
			if(dp[i] == next_mul_5) {
				i5++;
				next_mul_5 = dp[i5] * 5;
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n-1];
	}
	
	public static void main(String[] args) {
		System.out.println(getUglyNumber(100));
	}
}

/* 1, 2(2*1), 3(3*1), 4(2*2), 5(5*1), 6(2*3), 8(2*2*2), 9(3*3), 10(2*5), 12(2*2*3), 15(3*5), 16, 18, 20, 24, 25, 27, 30
 *  
 */