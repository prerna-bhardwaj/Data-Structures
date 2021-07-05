/**
 * Given an expression string x. Examine whether the pairs and the 
 * orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 
 * 											'false' for exp = “[(])”.
 */
import java.util.*;

public class BalancedParanthesis {
	
	public static void main(String[] args) {
		String s = "(()]])";
		System.out.println(s + " : " + isBalanced(s));
		
	}

	private static boolean isBalanced(String s) {
		Stack<Character>st = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') 
				st.push(c);
			else if(c == ')' || c == '}' || c == ']') {
				if(st.isEmpty())	
					return false;
				if(!matchingBracket(st.peek(), c))
					return false;
				st.pop();
			}
		}
		return st.isEmpty();
	}

	private static boolean matchingBracket(Character opening, char closing) {
		switch(opening) {
		case '(':	if(closing == ')')	return true;
					break;
		case '[':	if(closing == ']')	return true;
					break;
		case '{':	if(closing == '}')	return true;
					break;
		default: 	return false;
		}
		return false;
	}
}
