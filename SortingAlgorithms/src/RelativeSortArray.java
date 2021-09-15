/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. 
Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

*/

import java.util.*;

public class RelativeSortArray {
	
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		// Use a hashmap to map the values of arr2 to their position in arr2.
        HashMap<Integer, Integer>map = new HashMap();
        for(int i = 0; i< arr2.length; i++)
            map.put(arr2[i], i);
        List<Integer>list = new ArrayList<>(arr1.length);
        for(int num : arr1)
            list.add(num);
        
        // Execute a custom sorting function.
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int index1 = map.getOrDefault(a, -1);
                int index2 = map.getOrDefault(b, -1);
                if(index1 == index2)
                    return a - b;
                if(index1 == -1)
                    return 1;
                if(index2 == -1)
                    return -1;
                return index1 - index2;
            }
        });
        for(int i = 0; i < arr1.length; i++)
            arr1[i] = list.get(i);
        return arr1;
    }

    public static void main(String[] args) {
    	int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
    	int arr2[] = {2,1,4,3,9,6};
    	System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}