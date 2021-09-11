public class AddBinary {
	// O(max(n1, n2)) time | O(n) space
	public static String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        while(i>=0 || j >= 0) {
            int first = (i >= 0) ? a.charAt(i) - '0' : 0;
            int second = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = first + second + carry;
            sb.insert(0, Integer.toString(sum % 2));
            carry = sum / 2;
            i--;
            j--;
        }
        if(carry > 0)
            sb.insert(0, Integer.toString(carry));
        return sb.toString();
    }

    public static void main(String[] args) {
    	System.out.println(addBinary("1010", "111111"));
    }
}