import java.util.*;

public class DestinationCity {
	// O(n) time | O(nk) space
	// here k is length of string
	public static String destCity(List<List<String>> paths) {
        HashMap<String, Integer>map = new HashMap<String, Integer>();
        
        for(int i = 0; i < paths.size(); i++) {
            String src = paths.get(i).get(0);
            String dest = paths.get(i).get(1);
            map.put(src, map.getOrDefault(src, 0) + 1);
            if(!map.containsKey(dest))
                map.put(dest, 0);
        }
        for(Map.Entry entry : map.entrySet()) {
            if((int)entry.getValue() == 0)
                return (String)entry.getKey();
        }
        return "";
    }

    // Less space is required for hashset as compared to hashmap.
    public static String destCityUsingSet(List<List<String>> paths) {
        HashSet<String>set = new HashSet<String>();
        for(List<String>path : paths)
            set.add(path.get(0));
        for(List<String> path : paths) {
            if(set.contains(path.get(1)) == false)
                return path.get(1);
        }
        return "";
    }

    public static void main(String[] args) {
    	List<List<String>>cities = new ArrayList<List<String>>();
    	ArrayList<String>city1 = new ArrayList<>();
    	city1.add("London");
    	city1.add("Mumbai");

    	ArrayList<String>city2 = new ArrayList<>();
    	city2.add("Mumbai");
    	city2.add("Pune");

    	ArrayList<String>city3 = new ArrayList<>();
    	city3.add("Delhi");
    	city3.add("London");

    	cities.add(city1);
    	cities.add(city2);
    	cities.add(city3);

    	System.out.println(destCity(cities));
    	System.out.println(destCityUsingSet(cities));

    }
}