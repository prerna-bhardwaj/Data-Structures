import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductSum {

	private static int productSum(List<Object> list) {
		return productSumHelper(list, 1);
	}
	
	// For main array, depth = 1
	// You need to add type casts since exact data-type of elements is unknown.
	// O(n) time | O(d) space
	// n = total # of elements in the array - including subarray
	// d = greatest depth of the array
	@SuppressWarnings("unchecked")
	private static int productSumHelper(List<Object> list, int depth) {
		int sum = 0;
		for(Object ele : list) {
			if(ele instanceof ArrayList) {
				ArrayList<Object> ar = (ArrayList<Object>)ele;
				sum += productSumHelper(ar, depth + 1);
			}
			else
				sum += (Integer)ele;
		}
		return sum * depth;
	}

	public static void main(String[] args) {
		ArrayList<Integer> ar1 = new ArrayList<>();
		ar1.add(7);
		ar1.add(-1);
		ArrayList<Integer> ar2 = new ArrayList<>();
		ar2.add(-13);
		ar2.add(8);
		ArrayList<Object> ar3 = new ArrayList<>();
		ar3.add(6);
		ar3.add(ar2);
		ar3.add(4);
		
		// [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
		List<Object>list = new LinkedList<>();
		list.add(5);
		list.add(2);
		list.add(ar1);
		list.add(3);
		list.add(ar3);
		System.out.println(list);
		System.out.println(productSum(list));
	}
}
