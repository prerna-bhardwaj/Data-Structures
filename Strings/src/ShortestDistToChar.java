/*
Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and 
answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
*/
import java.util.*;

public class ShortestDistToChar {

	// O(n) time | O(n) space - for ans array
	public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int ans[] = new int[n];
        // NOTE : /2 ki to avoid integer overflow
        int prev = Integer.MIN_VALUE / 2;
        
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == c)    prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(s.charAt(i) == c)    prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }
        
        return ans;
    }

    public static void main(String[] args) {
    	int res[] = shortestToChar("loveleetcode", 'e');
    	System.out.println(Arrays.toString(res));
    }
}

/*
Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]

Input: s = "aaab", c = "b"
Output: [3,2,1,0]
*/