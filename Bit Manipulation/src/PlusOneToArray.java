import java.util.*;

public class PlusOneToArray {

	public static  int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n-1; i>= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int ans[] = new int[n+1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
    	int arr[] = {1, 9, 9};
    	System.out.println(Arrays.toString(plusOne(arr)));
    }
}