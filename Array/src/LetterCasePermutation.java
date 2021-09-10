import java.util.*;

public class LetterCasePermutation {
	static List<String> res;
    public static List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        solve(s, 0, new StringBuilder());
        return res;
    }
    
    public static void solve(String s, int index, StringBuilder sb) {
        if(sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        Character curr = s.charAt(index);
        if(isNumber(curr)) {
            sb.append(curr);
            solve(s, index+1, sb);
            sb.setLength(sb.length() - 1);
        }
        else {
            sb.append(Character.toLowerCase(curr));
            solve(s, index + 1, sb);
            sb.setLength(sb.length() - 1);

            sb.append(Character.toUpperCase(curr));
            solve(s, index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public static boolean isNumber(Character c) {
        return (c >= '0' && c <= '9') ? true : false;
    }

    public static void main(String[] args) {
    	System.out.println(letterCasePermutation("a1b2"));
    }
}