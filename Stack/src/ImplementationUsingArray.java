
public class ImplementationUsingArray {
	static final int MAX = 100;
	int top;
	int[] arr = new int[MAX];
	
	ImplementationUsingArray() {
		top = -1;
	}
	
	boolean isEmpty() {
		return top == -1;
		// or return top < 0;
	}

	boolean push(int x) {
		if(top == MAX-1) {
			System.out.println("Stack Overflow");
			return false;
		}
		arr[++top] = x;
		System.out.println(x + " is pushed into the stack.");		
		return true;
	}
	
	int pop() {
		if(top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		int val =  arr[top--];
		System.out.println(val + " has been popped from stack.");
		return val;
	}
	
	/*
	 *  Overflow ka condition is not mentioned here. since in case of overflow 
	 *  the element will not be added
	 */
	int peek() {
		if(top == -1) {
			System.out.println("Stack underflow");
			return -1;
		}
		return arr[top];
	}
	
	public static void main(String[] args) {
		ImplementationUsingArray s = new ImplementationUsingArray();
        s.push(10);
        s.push(20);
        s.push(30);
        s.pop();
        System.out.println(" Is Empty : " + s.isEmpty());
        System.out.println(" Top element : " + s.peek());
        s.pop();
        s.pop();
        s.peek();
        System.out.println(" Is Empty : " + s.isEmpty());
	}
}
