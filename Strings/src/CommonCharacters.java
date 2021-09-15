/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). 
You may return the answer in any order.
*/
import java.util.*;

public class CommonCharacters {
	
	public static List<String> commonChars(String[] words) {
        List<String>res = new ArrayList();
        
        int freq[] = new int[26];
        Arrays.fill(freq, 200);
        for(String s : words) {
            int temp[] = new int[26];
            for(Character c : s.toCharArray()) {
                temp[c-'a']++;
            }
            
            for(int i = 0;i < 26; i++) 
                freq[i] = Math.min(temp[i], freq[i]);
        }
        
        for(int i = 0; i < 26; i++) {
            int count = freq[i];
            while(count > 0) {
                res.add((char)(i+'a') +"");
                count--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	String ar[] = {"bella","label","roller"};
    	System.out.println(commonChars(ar));
    }
}