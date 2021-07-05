/*
Given string str consisting of multiple words, the task is to reverse the entire string word by word.
Examples:  

Input: str = “I Love To Code” 
Output: Code To Love I
Input: str = “data structures and algorithms” 
Output: algorithms and structures data 

 */

import java.util.*;

public class ReverseSentenceUsingStack {

	
	public static void main(String[] args)
	{
	  String s = "I Love To Code";
	  reverseSentence(s);
	  reverseSentence("data structures and algorithms");
	  reverseUsingSplit("here is a test string");
	}

	private static void reverseUsingSplit(String string) {
		/// Create an empty character array stack
        Stack<String> s = new Stack<>();
        String[] token = string.split(" ");
 
        // Push words into the stack
        for (int i = 0; i < token.length; i++) {
            s.push(token[i]);
        }
 
        while (!s.empty()) {
 
            // Get the words in reverse order
            System.out.print(s.peek() + " ");
            s.pop();
        }
	}

	private static void reverseSentence(String s) {
		Stack<String> st = new Stack<>();
		
		String temp = "";
		for(int i = 0;i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				st.push(temp);
				temp = "";
			}
			else {
				temp += s.charAt(i);
			}
		}
		st.push(temp);
		while(!st.isEmpty()) {
			System.out.print(st.peek() + " ");
			st.pop();
		}
		System.out.println();
	}
}
