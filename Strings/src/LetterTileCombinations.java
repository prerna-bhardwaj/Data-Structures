import java.util.*;

public class LetterTileCombinations {
	static int N = 0;
	static int count = 0;

	static int findCount(String s) {
        HashMap<Character, Integer>hm = new HashMap<Character, Integer>();
        N = s.length();
        for(int i = 0 ; i < N; i++){
        	Character c = s.charAt(i);
        	if(!hm.containsKey(c)) 
        		hm.put(c, 0);
        	hm.put(c, hm.get(c) + 1);
        }
        System.out.println(hm);
        letterHelper(hm, new String());
        return count;
	}

	public static void letterHelper(HashMap<Character, Integer>hm, String curr) {
		if(!curr.equals("")) 	count++;
		System.out.println(curr);
		if(curr.length() == N)
			return;
		for(Map.Entry<Character, Integer>entry:hm.entrySet()) {
			int value = entry.getValue();
			if(value == 0)
				continue;
			Character c = entry.getKey();
			hm.put(c, value-1);
			letterHelper(hm, curr + c.toString());
			hm.put(c, value);
		}
	}

	public static void main(String[] args) {
		String s = "AAABBC";
		System.out.println(findCount(s));
	}
}