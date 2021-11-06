/*
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), 
or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
*/

import java.util.*;

class EquivDominoPairs {

	// O(n) time | O(n) space
	public static int numEquivDominoPairs(int[][] domi) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int[] arr : domi) {
            int num = Math.min(arr[0]*10 + arr[1], arr[1]*10 + arr[0]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int ans = 0;
        for(Map.Entry e : map.entrySet()) {
            int val = (int) e.getValue();
            ans += (val-1) * val / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
    	int arr[][] = {{1,2},{1,2},{1,2},{1,1},{2,2}, {1,1}};
    	// Output = 4
    	System.out.println(numEquivDominoPairs(arr));
    }

}