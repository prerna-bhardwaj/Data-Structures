import java.util.Scanner;

public class IntersectionOfSortedLists {
	static Scanner sc = new Scanner(System.in);

	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	static Node iterativeIntersection(Node head1, Node head2) {
		Node head = null, curr = null;
		while(head1 != null && head2 != null) {
			if(head1.data == head2.data) {
				Node temp = new Node(head1.data);
				if(head == null) {
					head = temp;
					curr = temp;
				}
				else {
					curr.next = temp;
					curr = curr.next;
				}
				head1 = head1.next;
				head2 = head2.next;
			}
			else if(head1.data > head2.data) 
				head2 = head2.next;
			else
				head1 = head1.next;
		}
		return head;
	}
	
	static Node recursiveIntersection(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		if(head1.data > head2.data)
			return recursiveIntersection(head1, head2.next);
		else if(head1.data < head2.data)
			return recursiveIntersection(head1.next, head2);

		// Case when there is intersection
		Node curr = new Node(head1.data);
		// Perform recursion for the remaining part of both lists
		curr.next = recursiveIntersection(head1.next, head2.next);
		// Return current node
		return curr;
	}
	
	static Node inputList(int size) {
		Node head, tail;
		int val = sc.nextInt();
		head = tail = new Node(val);
		
		for(int i = 0; i < size-1; i++) {
			val = sc.nextInt();
			tail.next = new Node(val);
			tail = tail.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int n , m;
        
        System.out.print("Enter size of both lists : ");
        n = sc.nextInt();
        m = sc.nextInt();
        
        Node head1 = inputList(n);
        Node head2 = inputList(m);
        
        System.out.print("List 1 : ");
        printList(head1);
        System.out.print("List 2 : ");
        printList(head2);
        
        Node result = iterativeIntersection(head1, head2);
        System.out.print("Iterative : ");
        printList(result);
        System.out.println();
        
        result = recursiveIntersection(head1, head2);
        System.out.print("Recursive : ");
        printList(result);       
	}
}


