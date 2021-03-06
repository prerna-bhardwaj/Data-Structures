import java.util.Arrays;

public class Find2OddAppearingNumbers {
	public static void main(String[] args) {
		int arr[] = {3, 3, 5, 4, 6, 7, 4, 7, 4, 4};
		System.out.println(Arrays.toString(getNumbersNaive(arr)));
		System.out.println(Arrays.toString(getNumbersEfficient(arr)));
	}

	private static int[] getNumbersEfficient(int[] arr) {
		int xor = 0;
		for(int i = 0;i < arr.length; i++)
			xor = xor ^ arr[i];
		int num1 = 0, num2 = 0;
		// gets the rightmost set bit
		int set = xor & ~(xor-1);
		for(int i = 0; i < arr.length; i++) {
			if((arr[i]&set) == 0)
				num1 ^= arr[i];
			else
				num2 ^= arr[i];
		}
		return new int[] {num1, num2};
	}

	private static int[] getNumbersNaive(int[] arr) {
		int ans[] = new int[2];
		int index = 0;
		for(int i = 0;i < arr.length; i++) {
			int cnt = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] == arr[i])
					cnt++;
			}
			if(cnt%2 != 0)
				ans[index++] = arr[i];
		}
		return ans;
	}
}
