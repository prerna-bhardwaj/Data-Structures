
public class PalindromeCheck {
	// O(n^2) time | O(n) space
	private static boolean isPalindrome1(String s) {
		String reversed = "";
		for(int i = s.length()-1; i >= 0; i--) {
//			reversed += s.substring(i, i+1);
//			OR
			reversed += s.charAt(i);
		}
		return reversed.equals(s);
	}
	
	// O(n) time | O(n) space
	private static boolean isPalindrome2(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return s.equals(sb.toString());
	}

	// O(n) time | O(n) space - space is required for call stack, actually O(n/2)space is req
	// End param need not be passed, it can be calculated by end = n-start-1;
	private static boolean isPalindrome3(String s, int start, int end) {
		// NOTE : True is returned
		if(start > end)
			return true;
		if(s.charAt(start) != s.charAt(end))
			return false;
		// Tail recursion
		return isPalindrome3(s, start+1, end-1);
	}
	
	// O(n) time | O(1) space
	private static boolean isPalindrome4(String s) {
		int start = 0, end = s.length()-1;
		while(start <= end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] ar = {"abc", "nayan", "a ", "qwertyytrewq"};
		
		for(String s : ar) {
			System.out.print(s + " - ");
			System.out.print(isPalindrome1(s) + " ");
			System.out.print(isPalindrome2(s) + " ");
			System.out.print(isPalindrome3(s, 0, s.length()-1) + " ");
			System.out.print(isPalindrome4(s) + "\n");
		}
	}
}
	