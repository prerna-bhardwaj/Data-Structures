/*
Given a string s, sort it in decreasing order based on the frequency of the characters. 
The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

*/
import java.util.*;

class FrequencySort {

	// O(nlogn) time | O(n) space
	public static String frequencySort(String s) {
        Map<Character, Integer>map = new HashMap();
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer>sortedMap = sortMap(map);
        
        StringBuilder ans = new StringBuilder();
        for(Map.Entry e : sortedMap.entrySet()) {
            char curr = (char)e.getKey();
            int cnt = (int)e.getValue();

            StringBuilder temp = new StringBuilder();
            while(cnt-- > 0)
                temp.append(curr);
            ans.append(temp);
        }
        return ans.toString();
    }
    
    public static Map<Character, Integer> sortMap(Map<Character, Integer> map) {
        LinkedList<Map.Entry<Character, Integer>>list = new LinkedList(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (int)o2.getValue() - (int)o1.getValue();
            }
        });
        
        Map<Character, Integer>sorted = new LinkedHashMap();
        for(Map.Entry<Character, Integer>entry : list) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    public static void main(String[] args) {
    	String s = "aabbbcccc";
    	System.out.println(frequencySort(s));
    }
}