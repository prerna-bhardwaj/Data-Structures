/*
 * 2 for loops can also be used to solve in O(n^2) time
 * Current TC - O(n)
 * Current SC - O(1)
 * Given a singly linked list, remove all the nodes which have a greater value 
 * on its following nodes i.e. nodes on its right
 */
import java.util.*;

public class DeleteNodeWithGreaterValue {
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
        Node temp = deleteNodes(head);
        printList(temp);
        System.out.println();
	}

	private static Node deleteNodes(Node head) {
		if(head == null || head.next == null)
			return head;
		// Find the next node to point recursively
		Node nextNode = deleteNodes(head.next);
		// If value of next node is greater than curr i.e. head node, then delete current node
		// Thus we directly return current node, so head automatically gets eliminated form list
		if(nextNode.data > head.data)
			return nextNode;
		
		// Else nextNode has value <= head node, thus we have to attach it and return both nodes
		head.next = nextNode;
		return head;
	}
}
