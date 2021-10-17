import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromUnsortedList {
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
            // addToTheLast(new Node(a));
            tail.next = new Node(a);
            tail =tail.next;
        }
        Node res = removeDuplicatesNaive(head);
//        Node res = removeDuplicatesEfficient(head);
        printList(res);
        System.out.println();
	}

	/*
	 * Time Complexity: O(n^2)
	 * SC = O(1)
	 */
	private static Node removeDuplicatesNaive(Node head) {
		if(head == null || head.next == null)
			return head;
		Node ptr1 = head, ptr2 = null;
		
		/*
		 * Ptr1 != null has to be checked because we are deleting some nodes in the
		 * inner while loop, so ptr1 may hv null value after some iteration
		 */
		while(ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;
			/*
			 *  ptr2 always has some value mainly bcz :
			 *  1. ptr1 has value - checked above
			 *  2. we always only update next ptr of ptr2 when match is found
			 */
			while(ptr2.next != null) {
				if(ptr1.data == ptr2.next.data) {
					Node temp = ptr2.next;
					ptr2.next = ptr2.next.next;
					System.gc();
				}
				else
					ptr2 = ptr2.next;
			}
			ptr1 = ptr1.next;
		}
		return head;
	}

	/*
	 * Time Complexity: O(n) on average 
	 * (assuming that hash table access time is O(1) on average).  
	 * SC = O(n)
	 */
	private static Node removeDuplicatesEfficient(Node head) {
		if(head == null || head.next == null)
			return head;
		HashSet<Integer> hs = new HashSet<>();
		Node curr = head;
		hs.add(curr.data);
		while(curr.next != null) {
			int val = curr.next.data;
			if(hs.contains(val)) {
				Node temp = curr.next;
				curr.next = temp.next;
				temp = null;
			}
			else {
				hs.add(val);
				curr = curr.next;
			}
		}
		return head;
	}

}
