/*
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, 
and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some 
characters (possibly none) being long pressed.
*/

class LongPressedName {

	// O(max(m,n)) time | O(1) space
	public static boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0) != typed.charAt(0))
            return false;
        int i = 0, j = 0;
        int len1 = name.length(), len2 = typed.length();
        while(i < len1 && j < len2) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            }
            else {
                if(name.charAt(i-1) == typed.charAt(j))
                    j++;
                else
                    return false;
            }
        }
        while(j < len2 && typed.charAt(j) == name.charAt(i-1)) {
            j++;
        }
        return i == len1 && j == len2;
    }

    public static void main(String[] args) {
    	String name = "alex";
    	String typed = "aalleeeexxxx";
    	System.out.println(isLongPressedName(name, typed));
    }
}