/*

You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, 
which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own,
 and so on, to produce a multilevel data structure, as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first 
level of the list.

*/

class FlattenMultiLevelDLL {
	static class Node{
		public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	
	    Node() {}
	    Node(int val) {
	    	this.val = val;
	    	prev = next = child = null;
	    }
	}

	public static Node flatten(Node head) {
        if(head == null)
            return head; 
        Node curr = head;
        System.out.println(curr.val);
        // If current node doesn't have a child, then flatten the next nodes
        if(curr.child == null)
            curr.next = flatten(curr.next);
        
        // Else if it has children, then flatten them first
        else {
            // Save pointer to the next node
            Node next = curr.next;
            flatten(next);

            // Flatten the children of the current node
            curr.next = curr.child;
            curr.child = null;
            curr.next.prev = curr;
            flatten(curr.next);
            
            // If curr wasn't the last node, then update pointers.
            // i.e. curr.last_ele_of_child.next = next and vice-versa 
            if(next != null) {
                Node temp = curr;
                // Go to the last element in the child of current node
                while(temp.next != null)
                    temp = temp.next;
                temp.next = next;
                next.prev = temp;
            }
        }
        return curr;
    }

    // head is passed by value here, and not reference
    public static void printList(Node head) {
    	while(head != null) {
    		System.out.print(head.val + " ");
    		head = head.next;
    	}
    	System.out.println();
    }


    public static void main(String[] args) {
    	Node head1 = new Node(1);
    	head1.next = new Node(2);
    	head1.next.next = new Node(3);
    	head1.next.next.next = new Node(4);
    	head1.next.next.next.next = new Node(5);
    	head1.next.next.next.next.next = new Node(6);

		Node head2 = new Node(7);
    	head2.next = new Node(8);
    	head2.next.next = new Node(9);
    	head2.next.next.next = new Node(10);

		Node head3 = new Node(11);
    	head3.next = new Node(12);

    	head1.next.next.child = head2;
    	head2.next.child = head3;

    	Node newHead = flatten(head1);
    	
    	// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
    	printList(newHead);
    }

}

/*
We use the multilevel linked list from Example 1 above:

 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
The serialization of each level is as follows:

[1,2,3,4,5,6,null]
[7,8,9,10,null]
[11,12,null]

*/