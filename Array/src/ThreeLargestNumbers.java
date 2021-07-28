import java.util.Arrays;

public class ThreeLargestNumbers {
	
	private static Integer[] findThreeLargestNumbers(int[] ar) {
		Integer result[] = new Integer[3];
		for(int ele : ar) {
			if(result[2] == null) {
				result[2] = ele;
			}
			else if(ele > result[2]) {
				result[0] = result[1];
				result[1] = result[2];
				result[2] = ele;
			}
			else if(result[1] == null) {
				result[1] = ele;
			}
			else if(ele > result[1]) {
				result[0] = result[1];
				result[1] = ele;
			}
			else if(result[0] == null) {
				result[0] = ele;
			}
			else if(ele > result[0]) {
				result[0] = ele;
			}
		}
		return result;
	}
	
	private static Integer[] find3LargestNumbers(int[]ar) {
		Integer[] result = new Integer[3];
		for(int ele : ar) {
			if(result[2] == null || ele > result[2])
				shiftAndUpdate(result, ele, 2);
			else if(result[1] == null || ele > result[1])
				shiftAndUpdate(result, ele, 1);
			else if(result[0] == null || ele > result[0])
				shiftAndUpdate(result, ele, 0);
			
		}
		return result;
	}
	
	private static void shiftAndUpdate(Integer[] result, int ele, int index) {
		for(int i = 0; i <= index; i++) {
			if(i == index)
				result[index] = ele;
			else
				result[i] = result[i+1];
		}
	}

	public static void main(String[] args) {
//		int[] ar = {10, 10};
		int[] ar = {141, 1, 17, -4, -19, -64, 20, 234, 54, 78, 2, 8};
		Integer[] result = findThreeLargestNumbers(ar);
		System.out.println(Arrays.toString(result));
		result = find3LargestNumbers(ar);
		System.out.println(Arrays.toString(result));
	}
}
