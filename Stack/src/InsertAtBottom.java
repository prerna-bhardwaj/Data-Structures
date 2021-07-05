import java.util.*;

public class InsertAtBottom {
	Stack<Integer> st;
	
	InsertAtBottom() {
		st = new Stack<>();
	}
	
	public static void main(String args[]) {
		InsertAtBottom obj = new InsertAtBottom();
		
		obj.insertAtBottom(10);
		obj.printStack();
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		obj.add(5);
		obj.printStack();
		obj.insertAtBottom(0);
		obj.printStack();
	}
	
	private void insertAtBottom(int i) {
		if(st.isEmpty()) {
			st.push(i);
			return;
		}
		int val = st.pop();
		insertAtBottom(i);
		st.push(val);
	}

	private void printStack() {
		Iterator<Integer> it = st.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
	}

	private void add(int i) {
		st.push(i);
	}
}
