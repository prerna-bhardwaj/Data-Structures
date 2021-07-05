import java.util.Stack;

/*
 * Given a string s representing characters typed into an editor, with "<-" 
 * representing a backspace, return the current state of the editor.
 */
public class TextEditorBackspace {
	
	public static void main(String args[]) {
		String str = "abdef<-ghi<-";
		System.out.println(str + " : " + solve(str));
		str = "<";
		System.out.println(str + " : " + solve(str));
		str = "<-";
		System.out.println(str + " : " + solveWithoutStack(str));
		str = "abc<-d";
		System.out.println(str + " : " + solve(str));				
	}
	
	public static String solve(String s) {
        Stack<Character>st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(i+1 < s.length() && s.charAt(i) == '<' && s.charAt(i+1) == '-') {
                if(!st.isEmpty())
                    st.pop();
                i++;
            }
            else
                st.push(c);
        }
        // Use stringbuilder for manipulating strings
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()) {
            // Append data at end of stringbuilder
        	str.append(st.peek());
            st.pop();
        }
        // Convert stringbuilder to string
        return str.reverse().toString();
    }
	
	/*
	 * Instead of using stack for storing and then converting it to stringbuilder, 
	 * u can directly make use of string builder and just convert to string and return
	 */
	public static String solveWithoutStack(String s) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && s.charAt(i) == '<' && s.charAt(i + 1) == '-') {
                if (sb.length() != 0)
                    // Note : Method to delete a char at given position in string builder
                	sb.deleteCharAt(sb.length() - 1);
                i++;
            } else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

/*
 * String str = "";
 * while(!st.isEmpty())
 * 	str += st.pop();
 * 
 * Above code works. But to reverse a string you need to convert it to char/bytesarray.
 * Therefore stringbuilder was used
 */