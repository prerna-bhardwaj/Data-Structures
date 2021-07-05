
import java.util.*;

public class GetNthNodeFromLast {
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
        System.out.print("Enter index of node from end : ");
        int val = sc.nextInt();
        int temp = getNthFromLast(head, val);
        System.out.println("Nth node from end : " + temp);
	}

	/*
	 * Use 2 pointers separated by n nodes and iterate both of them simultaneously.
	 */
	static int getNthFromLast(Node head, int n)
    {
        Node end = head;
        int cnt = 1;
        // Find nth node from first
        while(cnt < n && end != null) {
            cnt++;
            end = end.next;
        }
        // True when n > size of list
        if(end == null)     return -1;
        // Iterate both ptrs simultaneously till you reach the last node.
        Node start = head;
        while(end.next != null) {
            end = end.next;
            start = start.next;
        }
        return start.data;
    }
}