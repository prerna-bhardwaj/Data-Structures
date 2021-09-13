/*

Given a string s. You should re-order the string using the following algorithm:

Pick the smallest character from s and append it to the result.
Pick the smallest character from s which is greater than the last appended character to the result and append it.
Repeat step 2 until you cannot pick more characters.
Pick the largest character from s and append it to the result.
Pick the largest character from s which is smaller than the last appended character to the result and append it.
Repeat step 5 until you cannot pick more characters.
Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

*/

/*

Solution : 

1. Count the frequency of each character.
2. Loop over all character from 'a' to 'z' and append the character if it exists and decrease frequency by 1. 
	Do the same from 'z' to 'a'.
3. Keep repeating until the frequency of all characters is zero.

*/
public class IncreasingDecreasingString {
	
	public static String sortString(String s) {
        int freq[] = new int[26];
        for(Character c : s.toCharArray()) {
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()) {
            for(int i = 0; i < 26; i++) {
                if(freq[i] > 0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }
            }
            for(int i = 25; i >= 0; i--) {
                if(freq[i] > 0) {
                    sb.append((char)(i+'a'));
                    freq[i]--;
                }               
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(sortString("aaaabbbbcccc"));
    	// O/p : abccbaabccba
    }
}