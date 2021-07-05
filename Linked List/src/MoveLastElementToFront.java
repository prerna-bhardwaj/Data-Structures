/**
 * 
 */
import java.util.*;

public class MoveLastElementToFront {
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
        Node res = moveLastElementToFirst(head);
        printList(res);
        System.out.println();
	}

	private static Node moveLastElementToFirst(Node head) {
		if(head == null || head.next == null)
			return head;
		Node last = head, sec = head;
		while(last.next != null) {
			sec = last;
			last = last.next;
		}
		sec.next = null;
		last.next = head;
		head = last;
		return head;
	}
}
