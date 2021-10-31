/*

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".

Given a string word, return true if the usage of capitals in it is right.

*/

class DetectCapital{

	public static boolean detectCapitalUsingRegex(String word) {
        return word.matches("[A-Z]*") || word.matches("[a-z]*") || word.matches("[A-Z][a-z]*");
    }

	public static boolean detectCapitalUse(String word) {
        if(word.length() <= 1)
            return true;
        char one = word.charAt(0), two = word.charAt(1);
        if(one >= 'a' && one <= 'z')
            return smallCase(word);
        if(two >= 'a' && two <= 'z')
            return camelCase(word);
        return upperCase(word);
    }
    
    public static boolean smallCase(String s) {
        for(Character c : s.toCharArray()) {
            if(c < 'a' || c > 'z')
                return false;
        }
        return true;
    }
    
    public static boolean upperCase(String s) {
        for(Character c : s.toCharArray()) {
            if(c < 'A' || c > 'Z')
                return false;
        }
        return true;
    }
    
    public static boolean camelCase(String s) {
        int size = s.length();
        for(int i = 1; i < size; i++) {
            char c = s.charAt(i);
            if(c < 'a' || c > 'z')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    	String s = "Google";
    	System.out.println(s + " " + detectCapitalUsingRegex(s));
    	s = "AmaZon";
    	System.out.println(s + " " + detectCapitalUse(s));
    }
}