public class OddEvenLinkedList {
	
	class Node {
		int val;
		Node next;
		Node() {}
		Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public static Node oddEvenList(Node head) {
        if(head == null)
            return head;
        Node odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
    	Node head = new Node(1);
    	head.next = new Node(2);
    	head.next.next = new Node(3);
    	head.next.next.next = new Node(4);    	
    	head.next.next.next.next = new Node(5);
    	head.next.next.next.next.next = new Node(6);
    	oddEvenList(head);	
    }
}