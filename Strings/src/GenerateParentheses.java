import java.util.*;
/*
22. Generate Parentheses

Keep track of the number of opening and closing brackets we have placed so far.

We can start an opening bracket if we still have one (of n) left to place. 
And we can start a closing bracket if it would not exceed the number of opening brackets.

Time and space complexity : https://leetcode.com/problems/generate-parentheses/solution/
*/

public class GenerateParentheses {
	static List<String>res;
    public static List<String> generateParentheses(int n) {
        res = new ArrayList<String>();
        solve(new StringBuilder(), n, 0, 0);
        return res;
    }
    
    public static void solve(StringBuilder sb, int n, int open, int close) {
        if(sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            solve(sb, n, open+1, close);
            sb.setLength(sb.length()-1);
        }
        // Don't close a bracket before opening. Only valid parentheses are processed here onwards
        if(close < open) {
            sb.append(")");
            solve(sb, n, open, close + 1);
            sb.setLength(sb.length()-1);            
        }
    }

    public static void main(String[] args) {
    	generateParentheses(4);
    	System.out.println(res);
    }
}