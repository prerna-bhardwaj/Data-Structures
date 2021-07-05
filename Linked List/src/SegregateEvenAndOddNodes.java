/*
 * Given a link list of size N, modify the list such that all the even numbers appear 
 * before all the odd numbers in the modified list. The order of appearance of numbers 
 * within each segregation should be same as that in the original list.
 * TC - O(n)
 * SC - O(n)
 */
import java.util.*;

public class SegregateEvenAndOddNodes {
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
        printList(head);
        Node temp = segregateList(head);
        printList(temp);
	}

	private static Node segregateList(Node head) {
		Node head1 = new Node(-1);
        Node head2 = new Node(-1);
        Node temp1 = head1, temp2 = head2;
    
        Node temp = head;
        while(temp != null) {
            if(temp.data%2 == 0) {
                temp1.next = new Node(temp.data);
                temp1 = temp1.next;
            }
            else {
                temp2.next = new Node(temp.data);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }    
        head1 = head1.next;
        head2 = head2.next;
        if(head1 == null)   return head2;
        temp1.next = head2;
        return head1;
	}
}
/*
 * …1) Get pointer to the last node. 
…2) Move all the odd nodes to the end. 
……..a) Consider all odd nodes before the first even node and move them to end. 
……..b) Change the head pointer to point to the first even node. 
……..b) Consider all odd nodes after the first even node and move them to the end. 
 */
