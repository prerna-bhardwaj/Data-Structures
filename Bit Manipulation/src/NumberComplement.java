/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.
*/

public class NumberComplement {

	public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < binary.length(); i++) {
            if(binary.charAt(i) == '0')
                sb.append('1');
            else
                sb.append('0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static int findComplementOptimized(int num) {
        int ans = 0, power = 1;
        while(num != 0) {
            ans += (num & 1 ^ 1) * power;
            power = power << 1;
            num = num >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
    	System.out.println(findComplement(10));
    	System.out.println(findComplementOptimized(16));
    }
}
// 10 -> 1010 -> 0101 -> 5