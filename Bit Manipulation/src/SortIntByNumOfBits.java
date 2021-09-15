/*

Given an integer array arr. You have to sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the sorted array.

*/
import java.util.*;

public class SortIntByNumOfBits {

	public static int[] sortByBits(int[] arr) {
        Map<Integer, List<Integer>>map = new HashMap();
        List<Integer>temp;
        for(int i = 0; i <= 15; i++) {
            List<Integer>list = new ArrayList();
            map.put(i, list);
        }
        for(int i = 0; i < arr.length; i++) {
            int count = getCount(arr[i]);            
            temp = map.get(count);
            temp.add(arr[i]);
            map.put(count, temp);
        }
        int index = 0;
        for(int i = 0; i<= 15; i++) {
            temp = map.get(i);
            Collections.sort(temp);
            for(int num : temp)
                arr[index++] = num;
        }
        return arr;
    }
    
    public static int getCount(int num) {
        int count = 0;
        while(num != 0) {
            num = num & (num-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
    	int arr[] = {0,1,2,3,4,5,6,7,8};
    	int ans[] = sortByBits(arr);
    	System.out.println(Arrays.toString(ans));
    }
}

/*

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]

Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

*/