/*
599. Minimum Index Sum of Two Lists

Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented 
by strings.

You need to help them find out their common interest with the least list index sum. 
If there is a choice tie between answers, output all of them with no order requirement. 
You could assume there always exists an answer.
*/
import java.util.*;

public class FindRestaurant {

	// O(l1 + l2) time | O(l1 * x) space
	// NOTE : here x = avg length of the strings
	public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer>map = new HashMap<String, Integer>();
        
        for(int i = 0; i < list1.length; i++)
            map.put(list1[i], i);
        
        List<String>res = new ArrayList<String>();
        int sum = list1.length + list2.length;
        for(int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])) {
                sum = Math.min(sum, i + map.get(list2[i]));
            }
        }
        for(int i = 0; i < list2.length; i++) {
            int temp = map.getOrDefault(list2[i], 0);
            if(map.containsKey(list2[i]) && temp + i == sum) 
                res.add(list2[i]);
        }
        return res.toArray(new String[res.size()]);
    }

	public static void main(String[] args) {
		String[] arr1 = {};
		String[] arr2 = {};

		System.out.println(Arrays.toString(findRestaurant(arr1, arr2)));
	}
}
