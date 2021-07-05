
public class ImplementationUsingLinkedList {
	
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;

	boolean isEmpty() {
		return head == null;
	}
	
	void push(int x) {
		Node temp = new Node(x);
		if(head == null) {
			head = temp;
		}
		else {
			temp.next = head;
			head = temp;			
		}
		System.out.println(x + " has been pushed onto the stack.");
	}
	
	int pop() {
		if(head == null) {
			System.out.println("Stack underflow");
			return -1;
		}
		int val = head.data;
		head = head.next;
		System.out.println(val + " has been popped from stack.");
		return val;
	}
	
	int top() {
		if(head == null)  {
			System.out.println("Stack underflow");
			return -1;
		}
		int val = head.data;
		return val;
	}
	
	public static void main(String[] args) {
		ImplementationUsingLinkedList s = new ImplementationUsingLinkedList();
        s.push(10);
        s.push(20);
        s.push(30);
        s.pop();
        System.out.println(" Is Empty : " + s.isEmpty());
        System.out.println(" Top element : " + s.top());
        s.pop();
        s.pop();
        s.top();
        System.out.println(" Is Empty : " + s.isEmpty());       
	}
}

