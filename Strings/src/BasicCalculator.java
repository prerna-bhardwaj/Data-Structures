public class BasicCalculator {
	public static int calculate(String s) {
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace(" ", "");
        System.out.println(s);
        int ans = s.charAt(0) - '0';
        for(int i = 1; i < s.length(); i++) {
        	Character c = s.charAt(i);
        	switch(c) {
        		case '+': ans += s.charAt(i+1) - '0';
        				 break;
        		case '-': ans -= s.charAt(i+1) - '0';
        				break;
        	}
        	i++;
        }
        return ans;
    }

    public static void main(String[] args) {
    	System.out.println(calculate("(1+(4+5+2)-3)+(6+18) "));
    }
}