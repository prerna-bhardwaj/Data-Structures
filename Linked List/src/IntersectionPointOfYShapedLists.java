import java.util.HashSet;
import java.util.Scanner;

public class IntersectionPointOfYShapedLists {
	static Scanner sc = new Scanner(System.in);
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	static Node inputList(int size) {
		Node head, tail;
		int val = sc.nextInt();
		head = tail = new Node(val);
		
		for(int i = 0; i < size-1; i++) {
			val = sc.nextInt();
			tail.next = new Node(val);
			tail = tail.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		int n , m, l;
        
        System.out.print("Enter size of all 3 lists : ");
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        
        Node head1 = inputList(n);
        Node head2 = inputList(m);
        Node head3 = inputList(l);
        
        Node temp = head1;
        while(temp.next != null)
        	temp = temp.next;
        temp.next = head3;
        
        temp = head2;
        while(temp.next != null)
        	temp = temp.next;
        temp.next = head3;
        
        System.out.print("List 1 : ");
        printList(head1);
        System.out.print("List 2 : ");
        printList(head2);
        
        // function returns value of intersection point
	    int val = intersectionPointUsingHashSet(head1, head2);
	    System.out.println(val);
	    int val2 = intersectionPointUsingDiffOfNodeCount(head1, head2);
	    System.out.println(val2);
	}

	/*
	 * TC - O(m + n)
	 * SC - min(O(m), O(n))
	 */
	private static int intersectionPointUsingHashSet(Node head1, Node head2) {
		HashSet<Node>hs = new HashSet<>();
        Node temp = head1;
        while(temp != null) {
            hs.add(temp);
            temp = temp.next;
        }
        
        temp = head2;
        while(temp != null) {
            if(hs.contains(temp))
                return temp.data;
            temp = temp.next;
        }
        return -1;
	}
	
	private static int intersectionPointUsingDiffOfNodeCount(Node head1, Node head2) {
        int n1 = 0, n2 = 0;
        Node temp = head1;
        // Get count of nodes in list1
        while(temp.next != null) {
        	temp = temp.next;
            n1++;            
        }

        // Get count of nodes in list2
        temp = head2;
        while(temp.next != null) {
        	temp = temp.next;
            n2++;            
        }
        int diff = Math.abs(n1-n2);
        temp = n1>n2 ? head1 : head2;
        Node temp2 = n1 > n2 ? head2 : head1;
        
        // Iterate d nodes in bigger list
        int i = 0;
        while(i < diff) {
            i++;
            temp = temp.next;
        }
        
        // Traverse both lists simultaneously to find intersection point
        while(temp != null && temp2 != null) {
            if(temp == temp2)
                return temp.data;
            temp = temp.next;
            temp2 = temp2.next;
        }
        // No intersection point present
        return -1;
	}
}

/*
 * 1. Two loops - O(mn)
 * 2. Mark visited nodes - O(m+n) - requires extra space in  node structure 
 * 3. Use of difference of node counts - O(m+n)
 * 		a. Get count of nodes in list1 = c1
 * 		b. Get count of nodes in list2 = c2
 * 		c. Get diff d = abs(c1-c2)
 * 		d. Traverse d nodes in bigger list
 * 		e. Now both lists have common no of nodes, so traverse both lists together
 * 		f. Compare the nodes at each step to find intersection point
 * 4. Use hashing - O(m+n) - done above
 * 5. Traverse both lists and compare addresses of last nodes
 * 		- used only to find if there is intersection of lists or not
 * 		- TC - O(m+n)
 * 		- Aux SC - O(1)
 */