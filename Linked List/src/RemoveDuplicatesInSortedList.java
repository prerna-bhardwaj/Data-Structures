import java.util.*;


public class RemoveDuplicatesInSortedList {
	static Scanner sc = new Scanner(System.in);
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.print("Enter size of list : ");
		int n = sc.nextInt();

	    Node head = new Node(sc.nextInt());
	    Node tail = head;

	    for(int i=0; i<n-1; i++){
	        tail.next = new Node(sc.nextInt());
	        tail = tail.next;
	    }

	    Node temp = removeDuplicates(head);
	    printList(temp);
	}

	private static Node removeDuplicates(Node head) {
		if(head == null || head.next == null)
			return head;
		Node curr = head;
		while(curr != null && curr.next != null) {
			if(curr.data == curr.next.data)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return head;
	}
}
