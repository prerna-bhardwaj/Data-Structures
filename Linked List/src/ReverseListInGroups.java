import java.util.*;

public class ReverseListInGroups {
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
        System.out.print("Enter k : ");
        int k = sc.nextInt();
        Node res = reverseInGroups(head, k);
        printList(res);
        System.out.println();
	}

	private static Node reverseInGroups(Node head, int k) {
		int cnt = k;
		Node prev = null;
		Node curr = head;
		Node next = null;
		while(curr != null && cnt > 0) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt--;
		}
		if(curr != null)
			head.next = reverseInGroups(curr, k);
		return prev;
	}
	
}
