/*
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.

*/

import java.util.*; 

class NumberCombinations {
	static List<Integer>curr;
    static List<List<Integer>>ans;

    public static List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<List<Integer>>();
        curr = new ArrayList<Integer>();
        solve(n, k, 1);
        return ans;
    }
    
    public static void solve(int n, int k, int num) {
        if(curr.size() == k) {
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i = num; i <= n; i++) {
            curr.add(i);
            solve(n, k, i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
    	System.out.println(combine(5, 3));
    }
}