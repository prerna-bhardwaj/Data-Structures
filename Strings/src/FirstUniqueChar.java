import java.util.*;

public class FirstUniqueChar {
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer>map = new HashMap();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < n; i++) {
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
    	// String s = "leetcode";
    	String s = "qwertyqwerty";
    	System.out.println(firstUniqChar(s));
    }
}