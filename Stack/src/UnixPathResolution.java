import java.util.ArrayDeque;
import java.util.Deque;

public class UnixPathResolution {

	public static void main(String args[]) {
		String[] str =  {"bin", "..", ".."};
		String[] result = solve(str);
		printArray(str);
		printArray(result);
		// Note : way of initializing array var second time (with new Keyword)
		str = new String[]{"usr", "..", "usr", ".", "local", "bin", "docker"};
		result = solve(str);
		printArray(str);
		printArray(result);
	}
	
	
    private static void printArray(String[] result) {
		for(String temp : result)
			System.out.print("/" + temp);
		System.out.println();
	}


	public static String[] solve(String[] path) {
    	// can use in built stack also, but deque is faster
        Deque<String> st = new ArrayDeque<>();
        for(String temp : path) {
            if(temp.equals("..")) {
                if(!st.isEmpty())
                    st.pop();
            }
            else if(!temp.equals("."))
                st.push(temp);
        }
        String[] result = new String[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()) {
            result[i] = st.pop();
            i--;
        }
        return result;
    }
}
