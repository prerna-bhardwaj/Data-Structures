import java.util.*;

public class RemoveElements {
	
	// NOTE : Recursive approach to delete all nodes having given value
	public static Node removeElementsRecursive(Node head, int val) {
	    if (head != null) {
         if (head.val == val) head = removeElements(head.next, val);
         else head.next = removeElements(head.next, val);
    	}
	   	return head;
	}

	public static Node removeElements(Node head, int val) {
        Node start = new Node();
        start.next = head;
        Node temp = start;
        while(temp.next != null) {
            if(temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return start.next;
    }

    static Node inputList(int size) {
		Node head, tail;
		int val = sc.nextInt();
		head = tail = new Node(val);
		System.out.println("Enter " + size + " elements :" );
		for(int i = 0; i < size-1; i++) {
			val = sc.nextInt();
			tail.next = new Node(val);
			tail = tail.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
        Node head = inputList(8);
        System.out.print("List 1 : ");
        printList(head);
		removeElements(head);        
        printList(result);
	}
}