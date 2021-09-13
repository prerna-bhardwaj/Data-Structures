/*
Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of 
American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
*/

import java.util.*;

public class KeyBoardRow {
	
	static String a = "qwertyuiop", b = "asdfghjkl", c = "zxcvbnm";
    
    // O(n) time | O(n) space - for saving the answer
    // Space = O(2n) precisely
    public static String[] findWords(String[] words) {
        ArrayList<String>ar = new ArrayList<>();

        for(String st : words) {
            String s = st.toLowerCase();
            String row = getRow(s.charAt(0));
            Boolean add = true;
            for(Character c : s.toCharArray()) {
                if(row.indexOf(c) == -1) {
                    add = false;
                    break;
                }
            }
            if(add)
                ar.add(st);
        }
        String arr[] = new String[ar.size()];
        int index = 0;
        for(String s : ar)
            arr[index++] = s;
        return arr;
    }
    
    public static String getRow(Character ch) {
        if(a.indexOf(ch) != -1)
            return a;
        else if(b.indexOf(ch) != -1)
            return b;
        else 
            return c;
    }

    public static void main(String[] args) {
    	String ans[] = findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    	System.out.println(Arrays.toString(ans));
    }
}