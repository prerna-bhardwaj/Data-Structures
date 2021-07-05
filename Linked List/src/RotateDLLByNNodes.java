
import java.util.Scanner;

class DLLDLLNode {
	int data;
	DLLDLLNode prev, next;
	DLLDLLNode(int data) {
		this.data = data;
		this.prev = this.next = null;
	}
}

public class RotateDLLByNNodes {
	
	static void printList(DLLNode head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter list : ");
		int n = sc.nextInt();

	    DLLNode head = new DLLNode(sc.nextInt());
	    DLLNode tail = head;

	    for(int i=0; i<n-1; i++)
	    {
	        tail.next = new DLLNode(sc.nextInt());
	        tail.next.prev = tail;
	        tail = tail.next;
	    }
	    System.out.print("Enter # of rotations (anti-clockwise) : ");
	    int k = sc.nextInt();
	    DLLNode temp = rotateDLL(head, k);
	    printList(temp);
	}

	private static DLLNode rotateDLL(DLLNode head, int k) {
		if(head == null)
			return head;
		DLLNode curr = head;
		int cnt = 1;
		while(cnt < k && curr != null) {
			curr = curr.next;
			cnt++;
		}
		// If K > size of list
		if(curr == null)
			return head;
		DLLNode nthNode = curr;
		// Get last Node of list
		while(curr.next != null)
			curr = curr.next;
		
		// Link last Node to head Node
		curr.next = head;
		head.prev = curr;
		
		// update head ptr
		head = nthNode.next;
		head.prev = null;
		nthNode.next = null;
		return head;
	}
	
}


