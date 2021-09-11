import java.util.*;

public class AddToArrayForm {
	
	public static List<Integer> addToArrayForm(int[] nums, int k) {
        ArrayList<Integer>res = new ArrayList<>();
        int carry = k;
        int i = nums.length;
        
        while(--i >= 0 || carry > 0) {
            carry += (i >= 0) ? nums[i] : 0;
            res.add(carry % 10);
            carry /= 10;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
    	int arr[] = {2,5,1};
    	int k = 841;
    	System.out.println(addToArrayForm(arr, k));
    }
}