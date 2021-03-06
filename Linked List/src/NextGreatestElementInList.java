/*
 * Given a singly linked list node, replace every node's value with the first 
 * greater node's value to its right. If a node doesn't have a next greater node, 
 * set its value to -1.
 */

import java.util.Scanner;
import java.util.Stack;

public class NextGreatestElementInList {
	static Scanner sc = new Scanner(System.in);
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	/*
	 * I/P : 3 2 4 5 
	 * O/P : 4 4 5 -1 
	 */
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

        printList(head);
        Node res = nestGreaterElement(head);
        printList(res);
	}

9 1 6 2 11 4
-1 9 9 6
9 6

	private static Node nestGreaterElement(Node head) {
		if(head == null)	return head;
		
		Stack<Integer>st = new Stack<>();
		head = reverse(head);
		Node res = new Node(-1);
		Node temp = res;
		
		while(head != null) {
			if(st.isEmpty())	temp.next = new Node(-1);
			else if(st.peek() > head.data)
				temp.next = new Node(st.peek());
			else if(st.peek() <= head.data) {
				while(!st.isEmpty() && st.peek() <= head.data)
					st.pop();
				if(st.isEmpty())	temp.next = new Node(-1);
				else				temp.next = new Node(st.peek());
			}
			st.push(head.data);
			head = head.next;
			temp = temp.next;
		}
		res = res.next;
		return reverse(res);
	}

	private static Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;
		Node rest = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return rest;
	}
	
	
}
