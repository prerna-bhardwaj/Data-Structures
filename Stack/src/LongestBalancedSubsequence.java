import java.util.Stack;

/*
 * Given a string s containing brackets "(" and ")", return the length of the 
 * longest subsequence of balanced brackets. 
 * NOTE : the characters in the subsequence do not have to be contiguous.
 */

public class LongestBalancedSubsequence {

	public static int solve(String s) {
        int cnt = 0;
        Stack<Character>st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == '(') 
                st.push(temp);
            else if(!st.isEmpty() && st.peek() == '(') {
                cnt += 2;
                st.pop();
            }
        }
        return cnt;
    }
	
	public static void main(String args[]) {
		String s = "(())";
		System.out.println(s + " : " + solve(s));
		s = "())(()";
		System.out.println(s + " : " + solve(s));
		s = "))((";
		System.out.println(s + " : " + solve(s));
		s = "))()))()";
		System.out.println(s + " : " + solve(s));
		s = "((((())";
		System.out.println(s + " : " + solve(s));


	}
}
