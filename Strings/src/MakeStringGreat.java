/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. 
You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.
*/

class MakeStringGreat {

	public static String makeGood(String st) {
        StringBuilder s = new StringBuilder(st);
    
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) != s.charAt(i+1)) {
                if(Character.toUpperCase(s.charAt(i)) == s.charAt(i+1)) {
                    s.delete(i, i+2);
                    i = -1;
                }
                else if(Character.toUpperCase(s.charAt(i+1)) == s.charAt(i)) {
                    s.delete(i, i+2);
                    i = -1;
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
    	String s = "abBAcCd";
    	/*
			Input: s = "abBAcC"
			Output: ""
			Explanation: We have many possible scenarios, and all lead to the same answer. For example:
			"abBAcC" --> "aAcC" --> "cC" --> ""
			"abBAcC" --> "abBA" --> "aA" --> ""
    	*/
		System.out.println(makeGood(s));
    }

}