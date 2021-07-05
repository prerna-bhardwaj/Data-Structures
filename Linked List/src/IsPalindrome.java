/*
 * Given a singly linked list of size N of integers. 
 * The task is to check if the given linked list is palindrome or not.
 * 
 * TC - O(n)
 * SC - O(1)
 * 
 * APPROACH : 
 * 	Get the middle of the linked list. 
 * 	Reverse the second half of the linked list. 
 * 	Check if the first half and second half are identical. 
 * 	Return 1 if list is palindrome else 0.
 * 
 * If list is to be returned, then reverse the second half and return head ptr.
 */

import java.util.*;

public class IsPalindrome {
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
        boolean val = isPalindrome(head);
        System.out.println(val);
	}

    //Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) 
    {
    	// find middle element to reverse 2nd half
        Node mid = findMid(head);
        // reverse second half
        mid.next = reverse(mid.next);
        // iterate thru first and second half to see if they are identical
        Node temp = head;
        Node temp2 = mid.next;
        while(temp != mid.next && temp2!=null) {
            if(temp.data != temp2.data)
                return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }    
    
    // Utility function to find middle element of list
    static Node findMid(Node head) {
        if(head == null || head.next == null) 
            return head;
        Node fast = head, slow = head;
        // Note conditions in while
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    // Utility function to iteratively reverse a list
    static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;
        Node prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
