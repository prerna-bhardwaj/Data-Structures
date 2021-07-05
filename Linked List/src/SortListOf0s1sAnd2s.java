import java.util.*;

public class SortListOf0s1sAnd2s {
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
        Node res = sortList(head);
        printList(res);
        System.out.println();
        res = sortListByChangingLinks(head);
        printList(res);
        System.out.println();	}

	
	/*
	 * 2 iterations required
	 * TC - O(n)
	 * SC - O(1)
	 * The solution does not work when these values have associated data with them. 
	 * For example, these three represent three colours and different types of objects
	 * associated with the colours and sort the objects (connected with a linked list)
	 *  based on colours. 
	 */
	private static Node sortList(Node head) {
		if(head == null || head.next == null)   
			return head;
        int arr[] = {0, 0, 0};
        
        Node temp = head;
        while(temp != null) {
            arr[temp.data]++;
            temp = temp.next;
        }
        
        temp = head;
        int i = 0;
        while(temp != null) {
            if(arr[i] == 0) 
                i++;
            else {
                temp.data = i;
                temp = temp.next;
                arr[i]--;
            }
        }
        return head;
	}
	
	// 1 iteration required
	// TC - O(n)
	// SC - O(1)
	// More efficient than above solution
	private static Node sortListByChangingLinks(Node head) {
		if(head == null || head.next == null)
			return head;
		// Dummy head nodes for all lists. 
		// They are used to avoid null checks
		Node beg0 = new Node(-1);
        Node beg1 = new Node(-1);
        Node beg2 = new Node(-1);
        
        // These nodes point to the current node of all 3 lists
        Node zero = beg0, one = beg1, two = beg2;
        
        Node curr = head;
        while(curr != null) {
            if(curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1) {
                one.next = curr;
                one = one.next;
            }
            else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = (beg1.next != null) ? beg1.next : beg2.next;
        one.next = beg2.next;
        two.next = null;
        head = beg0.next;
        return head;
	}	
}
