
import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElement {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int arr[] = new int[] { 1, 7, 9, 2, 3, 5, 4, 0, 3, 2, 1};
		int res[] = findSmallerElementToRight(arr);
		for(int ele : arr)	
			System.out.print(ele + " ");
		System.out.println();
		for(int ele : res)	
			System.out.print(ele + " ");
	}	

	private static int[] findSmallerElementToRight(int[] arr) {
		Stack<Integer>st = new Stack<>();
		int[] res = new int[arr.length];
		int index = res.length - 1;
		for(int i = arr.length - 1; i>=0; i--) {
			if(st.isEmpty())	res[index--] = -1;
			else if(st.peek() < arr[i])	
				res[index--] = st.peek();
			else if(st.peek() >= arr[i]) {
				// First check for empty stack case then check for top element of stack
				// Else it gives EmptyStackException
				while(!st.isEmpty() && st.peek() >= arr[i])
					st.pop();
				if(st.isEmpty())	res[index--] = -1;
				else				res[index--] = st.peek();
			}
			st.push(arr[i]);
		}
		return res;
	}
	
	
}
