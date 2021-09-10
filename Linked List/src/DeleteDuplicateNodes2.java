/*
Problem : 82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from 
the original list. Return the linked list sorted as well.
*/

public class DeleteDuplicateNodes2 {

	// O(n) time | O(1) space
	/*
	Sentinel Head + Predecessor (the last node before the sublist of duplicates.)

	Sentinel nodes are widely used for trees and linked lists as pseudo-heads, pseudo-tails, etc. They are purely functional 
	and usually don't hold any data. Their primary purpose is to standardize the situation to avoid edge case handling.

	For example, let's use here pseudo-head with zero value to ensure that the situation "delete the list head" could never happen,
	and all nodes to delete are "inside" the list.
	*/
	public static Node deleteDuplicates(Node head) {
        Node start = new Node();
        start.next = head;
        Node temp = start;
        
        while(temp != null && temp.next != null) {
            int curr = temp.next.val;
            Node ptr = temp;
            int count = 0;
            while(ptr != null && ptr.next != null && ptr.next.val == curr) {
                count++;
                ptr = ptr.next;
            }
            // Having predecessor, we skip the entire duplicate sublist and make predecessor to point to the node after the sublist.
            if(count > 1) 
                temp.next = ptr.next;
            else 
                temp = temp.next;
        }
        return start.next;
    }

    public static void main(String[] args) {
    	Node head = new Node(1);
    	head.next = new Node(1);
    	head.next.next = new Node(2);
    	head.next.next.next = new Node(3);
    	head.next.next.next.next = new Node(3);

    	printList(head);
    	Node newHead = deleteDuplicates(head);
    	printList(newHead);
    }
}