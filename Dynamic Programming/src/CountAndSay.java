/*
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.


The following are the terms from n=1 to n=10 of the count-and-say sequence:
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221 
 6.     312211
 7.     13112221
 8.     1113213211
 9.     31131211131221
10.     13211311123113112211

To generate the nth term, just count and say the n-1th term.

*/

class CountAndSay {

	// O(n) time | O(n) space (req for recursive calls)
	public static String countAndSay(int n) {
        if(n == 1)  return "1";
        String ans = countAndSay(n-1);
        int len = ans.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len;) {
            int cnt = 0;
            char c = ans.charAt(i);
            while(i < len && ans.charAt(i) == c) {
                cnt++;
                i++;
            }
            sb.append(cnt + "" + c);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.print(countAndSay(5));
	}
}