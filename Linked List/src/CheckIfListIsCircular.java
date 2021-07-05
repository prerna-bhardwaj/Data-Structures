/*
 * Given a singly linked list, find if the linked list is circular or not. 
 * A linked list is called circular if it not NULL terminated and all nodes 
 * are connected in the form of a cycle. 
 * NOTE : An empty linked list is considered as circular.
 */
import java.util.*;

public class CheckIfListIsCircular {
	static Scanner sc = new Scanner(System.in);
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.print("Enter size of List : ");
		int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        Node tail = head;
        for(int i = 1; i < n; i++)
        {
            int a = sc.nextInt();
            tail.next = new Node(a);
            tail =tail.next;
        }
        tail.next = head;
        System.out.println("List is circular : " + isCircular(head));
	}

	private static boolean isCircular(Node head) {	
		if(head == null)    return true;
	    Node temp = head;
	    while(temp.next != null) {
	        if(temp.next == head)    return true;
	        temp = temp.next;
	    }   
	    return false;
	}
}
