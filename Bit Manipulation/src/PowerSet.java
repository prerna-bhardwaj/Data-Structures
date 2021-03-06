import java.util.*;

public class PowerSet {
	public static void main(String[] args) {
		System.out.println(" : " + AllPossibleStrings(""));
		System.out.println("a : " + AllPossibleStrings("a"));
		System.out.println("aa : " + AllPossibleStrings("aa"));
		System.out.println("abc : " + AllPossibleStrings("abc"));
	}
	
	/*
	 * Returns all possible strings in the power set of given string
	 * List is returned in lexicographical order, thus sorted before returning
	 * TC - O(n*(2^n))
	 * Only non-empty strings are returned.
	 */
	public static List<String> AllPossibleStrings(String s)
    {
        List<String>l = new ArrayList<>();
        int n = s.length();
        int pow = (int)Math.pow(2, n);
        // Ignores empty string, thus i starts from 1 and not 0
        for(int i = 1 ;i < pow; i++) {
            StringBuilder st = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if((i & (1<<j)) != 0)
                    st.append(s.charAt(j));
            }   
            l.add(st.toString());
        }
        Collections.sort(l);
        return l;
    }
}
