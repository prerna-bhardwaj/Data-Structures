/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates 
where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

*/
import java.util.*;

class CombinationSum2 {
	static LinkedList<Integer>curr;
    static List<List<Integer>>ans;
    
    // Backtracking with Counters
    // O(2^n) time | O(n) space
    public static List<List<Integer>> combinationSum2(int[] cand, int target) {
        curr = new LinkedList<Integer>();
        ans = new ArrayList<List<Integer>>();
        Map<Integer, Integer>map = new HashMap();
        for(int num : cand) 
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<int[]>list = new ArrayList<>();
        map.forEach((key, value) -> {
            list.add(new int[]{key, value});
        });
        solve(target, list, 0);
        return ans;
    }
    
    public static void solve(int target, List<int[]>list, int currIndex) {
        if(target <= 0) {
            if(target == 0)
                ans.add(new ArrayList(curr));
            return;
        }

        for(int index = currIndex; index < list.size(); index++) {
            int[] pair = list.get(index);
            if(pair[1] <= 0)
                continue;
            curr.addLast(pair[0]);
            list.set(index, new int[] {pair[0], pair[1]-1});

            solve(target-pair[0], list, index);
            
            list.set(index, pair);
            curr.removeLast();
        }
    }

    // Backtracking with Index
    // O(2^n) time | O(n) space
    public static List<List<Integer>> combinationSum2Index(int[] cand, int target) {
        curr = new LinkedList<Integer>();
        ans = new ArrayList<List<Integer>>();
        Arrays.sort(cand);
        solveIndex(target, cand, 0);
        return ans;
    }
    
    public static void solveIndex(int target, int[] cand,  int currIndex) {
        if(target <= 0) {
            if(target == 0)
                ans.add(new ArrayList(curr));
            return;
        }

        for(int index = currIndex; index < cand.length; index++) {
        	// Note : helps in ignoring duplicate values
            if(index > currIndex && cand[index] == cand[index-1])
                continue;
            curr.addLast(cand[index]);
            solveIndex(target-cand[index], cand, index+1);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
    	int arr[] = {2,5,2,1,2};
    	int target = 5;
    	System.out.println(combinationSum2(arr, target));
    	System.out.println(combinationSum2Index(arr, target));
    }
}

/*
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[[1,2,2],[5]]
*/