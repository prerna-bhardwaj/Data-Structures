import java.util.*;

public class IsomorphicStrings {

	// O(n) time | O(n) space
	public static boolean isIsomorphic(String s, String t) {
        // Add mapping from s to t in map
        Map<Character, Character>map = new HashMap();
        // Add all characters from t that have been mapped
        Set<Character>set = new HashSet();
        
        for(int i = 0; i < s.length(); i++) {
        	// If mapping exists, but to a diff char
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
                return false;
            // Mapping does not exist, the char in t has been previously mapped to something else
            else if(!map.containsKey(s.charAt(i)) && set.contains(t.charAt(i)))
                return false;
            // Add mapping from s to t, also add curr char from t to set
            else {
                map.put(s.charAt(i), t.charAt(i));
                set.add(t.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	// String s = "egg", t = "add";
    	String s = "baby", t = "daoe";
    	System.out.println(isIsomorphic(s, t));
    }
}