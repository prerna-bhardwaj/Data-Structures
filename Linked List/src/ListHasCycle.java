
import java.util.*;

public class ListHasCycle {
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
        // Comment this line for no cycle case
        tail.next = head;
        System.out.println("List has cycle : " + hasCycle(head));
	}

	private static boolean hasCycle(Node head) {
		if(head == null)
			return false;
		/*
		 *  fast ptr is initialized to second node so that if condition in while loop is
		 *  not satisfied for the head node.
		 */
		Node fast = head.next, slow = head;
		while(fast != null && fast.next != null && slow != null) {
			if(fast == slow)
				return true;
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}
}
