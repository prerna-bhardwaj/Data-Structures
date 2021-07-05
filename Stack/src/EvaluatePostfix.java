import java.util.*;

public class EvaluatePostfix {

	public static void main(String args[]) {
		EvaluatePostfix obj = new EvaluatePostfix();
		String exp = "123+*8-";
		System.out.println(exp + " = " + obj.evaluatePostFix(exp));
		exp = "231*+9-";
		System.out.println(exp + " = " + obj.evaluatePostFix(exp));
		String[] arr = {"2", "3", "1", "*", "+", "9", "-"};
		System.out.println(exp + " = " + obj.evaluatePostFixUsingArray(arr));
		
	}
	
	private int evaluatePostFixUsingArray(String[] arr) {
		// Use Long for integer overflow
		Stack<Long>st = new Stack<>();
		for(int i = 0;i < arr.length; i++) {
			String temp = arr[i];
			// How to check if 2 strings are equal
			if(temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) {
				long sec = st.pop();
				long first = st.pop();
				st.push(calculateExp(first, sec, temp));
			}
			else
				// Converting string to long - Long.valueOf(str)
				// Converting string to int - Integer.valueOf(str)
				st.push(Long.valueOf(temp));
		}
		// Converting long to int - longVar.intValue()
		return st.pop().intValue();
	}

	private Long calculateExp(long first, long sec, String temp) {
		switch(temp) {
			case "+": return first+sec;
			case "-": return first-sec;
			case "*": return first*sec;
			case "/": return first/sec;
		}
		return (long) -1;
	}

	public int evaluatePostFix(String s)
    {
        Stack<Integer>st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                int sec = st.pop();
                int first = st.pop();
                st.push(calculate(first, sec, c));
            }
            else
                st.push(c  - '0');
        }
        return st.peek();
    }
    
    public int calculate(int a, int b, char op) {
        switch(op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return -1;
    }
}
