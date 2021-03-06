/*
 * You are given a list of integers heights representing building heights. 
 * A building heights[i] can see the ocean if every building on its right has 
 * shorter height. Return the building indices where you can see the ocean, in 
 * ascending order.
 * 
 * NOTE : You have to return the indices and not the actual ht of the building.
 * Though that can also be printed
 */

import java.util.ArrayList;

public class UnobstructedBuildings {

	public static void main(String[] args) {
		int ht[] = new int[] {5,4,3,2,1};
		int res[] = solve(ht);
		for(int ele : res) {
			System.out.print(ele + " ");
		}
		System.out.println();

		ht = new int[] {1,1,1,1,1};
		res = solve(ht);
		for(int ele : res) {
			System.out.print(ele + " ");
		}
		System.out.println();

		ht = new int[] {1,5,5,2,3};
		res = solve(ht);
		for(int ele : res) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}
	
	public static int[] solve(int[] ht) {
        if(ht.length == 0)  return new int[0];
        ArrayList<Integer>ar = new ArrayList<>();
        int curr_max = ht[ht.length-1];
        ar.add(ht.length-1);

        for(int i = ht.length-2; i >= 0; i--) {
            if(ht[i] > curr_max) {
            	// add i since index of the building is required, and not its actual ht.
                ar.add(i);
                curr_max = ht[i];
            }
        }
        // Reverse the list since we processed it in reverse order.
        int arr[] = new int[ar.size()];
        int index = ar.size()-1;
        for(int ele:ar) {
            arr[index] = ele;
            index--;
        }
        return arr;
    }
}
