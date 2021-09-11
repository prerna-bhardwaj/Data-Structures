import java.util.*;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

*/

public class PhoneNumberLetterCombos {
	
	static HashMap<Character, String>map;
    static List<String>res;

    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        solve(digits, new StringBuilder(), 0);
        return res;   
    }
    
    public static void solve(String org, StringBuilder curr, int index) {
        if(curr.length() == org.length()) {
            res.add(curr.toString());
            return;
        }
        String temp = map.get(org.charAt(index));
        for(int i = 0; i < temp.length() ; i++) {
            curr.append(temp.charAt(i));
            solve(org, curr, index + 1);
            curr.setLength(curr.length() - 1);
        }
    }

    public static void main(String[] args) {
    	// Input must consist of values from 2 to 9 only.
    	String s = "235";
    	letterCombinations(s);
    	System.out.println(res);
    }
}