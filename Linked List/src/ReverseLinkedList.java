import java.util.*;

class Node {
	int data;
	Node next;
	
	Node(int x) {
		data = x;
		next = null;
	}
}

public class ReverseLinkedList {
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	static Node iterativeReverseList(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static Node recursiveReverseList(Node head) {
		if(head == null || head.next == null)	
			return head;
		Node rest = recursiveReverseList(head.next);
		head.next.next = head;
		
		//	Note this step
		head.next = null;
		return rest;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

	    Node head = new Node(sc.nextInt());
	    Node tail = head;

	    for(int i=0; i<n-1; i++)
	    {
	        tail.next = new Node(sc.nextInt());
	        tail = tail.next;
	    }

//	    Node temp = iterativeReverseList(head);
//	    printList(temp); 
	    
	    Node temp = recursiveReverseList(head);
	    printList(temp);
	}
	
}


