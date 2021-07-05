import java.util.*;

public class SecondLargestElement {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter size of array : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n ;i++)
			arr[i] = sc.nextInt();
		
		int index = findSecondLargestElement(arr);
		if(index == -1)
		System.out.println("Second largest element not present. ");
		else
			System.out.println("Second largest element : " + arr[index]);

	}

	private static int findSecondLargestElement(int[] arr) {
		int largest = 0, res = -1;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[largest]) {
				res = largest;
				largest = i;			
			}
			else if(arr[i] != arr[largest]) {
				if(res == -1 || arr[i] > arr[res])
					res = i;
			}
		}
		return res;
	}
	
	
}
