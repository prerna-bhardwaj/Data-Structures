/*
 * a-z  =  97-122
 * A-Z  =  65-90
 */
// U can store all alphabets in an array - and get (index + key) % 25 
public class CeaserCipherEncryption {
	
	public static void main(String[] args) {
		String s = "abcxyz-DEFXYZ120 !";
		System.out.println(ceaserCipher(s, 4));
	}

	// O(n) time | O(n) space - required for sb
	private static String ceaserCipher(String s, int key) {
		StringBuilder sb = new StringBuilder();
        key %= 26;
		for(int i = 0; i < s.length(); i++)
           sb.append(getNewChar3(s.charAt(i), key));        	
        
        return sb.toString();
	}
        
    private static char getNewChar(char letter, int key) {
    	int a = letter;
    	char c = letter;
    	// Small letter
    	if(a >= 65 && a <= 90) {
    		a -= 65;
    		a = (a+key) % 26;
    		c = (char)(a + 'A');
    	}
    	// Capital letter
    	else if(a >= 97 && a <= 122) {
    		a -= 97;
            a = (a+key) % 26;
            c = (char) (a + 'a');
    	}
    	return c;
    }
    
    private static char getNewChar2(char letter, int key) {
    	int a = letter;
    	int next = a + key;
    	if(a >= 65 && a <= 90) 
    		return next <= 90 ? (char)next : (char)(next % 90 + 'A');		// or next%90 + 65
    	
    	else if(a >= 97 && a <= 122) 
    		return next <= 122 ? (char)next : (char)(next % 122 + 'a');	// or next%90 + 97
    	
    	// If letter isn't in a-z or A-Z, it is returned as it is, thus code works for all kinds of chars.
    	return letter;
    }
    
    private static char getNewChar3(char letter, int key) {
    	int a = letter;
    	if(a >= 65 && a <= 90) {
    		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        	int index = s.indexOf(letter) + key;
        	return index <= 25 ? s.charAt(index) : s.charAt(index%25);
    	}
    	else if(a >= 97 && a <= 122) {
    		String s = "abcdefghijklmnopqrstuvwxyz";
    		int index = s.indexOf(letter) + key;
    		return index <= 25 ? s.charAt(index) : s.charAt(index%25-1);
    	}
    	return letter;
    }
}
	
