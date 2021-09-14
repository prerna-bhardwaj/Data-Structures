/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

*/
import java.util.*;

public class ReverseLettersOnly {
	/*
		Write the characters of S one by one. When we encounter a letter, we want to write the next letter that occurs if we 
		iterated through the string backwards.

		So we do just that: keep track of a pointer j that iterates through the string backwards. When we need to write a letter, we use it.
		O(n) time | O(n) space
	*/
	public static String reverseOnlyLetters(String s) {
        StringBuffer sb = new StringBuffer();
        int j = s.length()-1;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                while(!Character.isLetter(s.charAt(j)))
                    j--;
                sb.append(s.charAt(j--));
            }   
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*
	    Collect the letters of S separately into a stack, so that popping the stack reverses the letters. 
	    (Alternatively, we could have collected the letters into an array and reversed the array.)

		Then, when writing the characters of S, any time we need a letter, we use the one we have prepared instead.
		O(n) time | O(n) space
	*/
    public static String reverseOnlyLettersUsingStack(String s) {
        Stack<Character>st = new Stack();
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c))
                st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) 
                sb.append(st.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    	System.out.println(reverseOnlyLettersUsingStack("Test1ng-C=odingQ!"));
    }
}