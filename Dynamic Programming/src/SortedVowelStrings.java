/*
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are 
lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
*/

class SortedVowelStrings {

	// O(n^2) time | O(n^2) space
	public static int countVowelStrings(int n) {
        int dp[][] = new int[6][n+1];
        for(int i = 1; i <=5 ;i++) {
            for(int j = 1; j <= n; j++) {
                if(j == 1)
                    dp[i][j] = dp[i-1][j] + 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];        
            }
        }
        return dp[5][n];
    }

    public static void main(String[] args) {
    	System.out.println(countVowelStrings(33));
    }
}

/*
Input: n = 2
Output: 15

Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Input: n = 33
Output: 66045
*/