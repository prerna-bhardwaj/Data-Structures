
public class Guess_The_Root {
	public static int solve(int n) {
        if(n < 2)   return n;
       long start = 0, end = n;
       int ans = n;
       while(start <= end) {
           long mid = start + (end - start)/2;
           if(mid * mid == (long)n) 
                return (int)mid;
            else if(mid * mid < (long)n) {
                ans = (int)mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
       }
       return (int)ans;
    }

	public static void main(String[] args) {
		System.out.println(solve(100));
		System.out.println(solve(15));
	}
}

