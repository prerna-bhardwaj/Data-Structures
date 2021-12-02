
class RearrangeSpaceBtwWords {
	public static String reorderSpaces(String text) {
        String parts[] = text.split(" ");
        int total = 0;
        int len = 0;
        for(String s : parts) {
            if(s.length() > 0)
                len++;
        }
        for(char c : text.toCharArray()) {
            if(c == ' ')
                total++;
        }
        
        int between = 0;
        if(len > 1)
            between = total / (len-1);
        int end = total - (between * (len-1));
        String btw = "";
        for(int i = 1; i <= between; i++)
            btw = btw + " ";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parts.length; i++) {
            if(parts[i].length() == 0)
                continue;
            sb.append(parts[i]);
            if(i != parts.length-1)
                sb.append(btw);
        }
        for(int i = 0; i < end; i++)
            sb.append(" ");
        return sb.toString();
    }

    public static void main(String[] args) {
    	String s = "  this   is  a sentence ";
    	String ans = reorderSpaces(s);
    	/*
	    	Input: text = "  this   is  a sentence "
			Output: "this   is   a   sentence"
			Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
		*/
    	System.out.println("'" + ans + "'");
    }
}