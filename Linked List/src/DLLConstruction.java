
public class DLLConstruction {
	static class Node {
		int value;
		Node prev, next;
		
		Node(int value) {
			this.value = value;
			this.next = this.prev = null;
		}
	}
	
	static class DoublyLinkedList {
		public Node head;
		public Node tail;
		
		// Same as insert at the first position
		// O(1) time | O(1) space
		public void setHead(Node node) {
			if(head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
		}
		
		// Same as insert at the last position
		// O(1) time | O(1) space
		public void setTail(Node node) {
			if(tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
		}
		
		// O(1) time | O(1) space
		public void insertBefore(Node node, Node nodeToInsert) {
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if(node.prev != null)
				node.prev.next = nodeToInsert;
			else
				head = nodeToInsert;		// Node is the head, so nodeToInsert becomes the new head
			node.prev = nodeToInsert;
		}
		
		// O(1) time | O(1) space
		public void insertAfter(Node node, Node nodeToInsert) {
			nodeToInsert.next = node.next;
			nodeToInsert.prev = node;
			if(node.next != null)
				node.next.prev = nodeToInsert;
			else
				tail = nodeToInsert;		// Node is the tail, so nodeToInsert becomes the new tail
			node.next = nodeToInsert;
		}
		
		// O(position) time | O(1) space
		public void insertAtPosition(int position, Node nodeToInsert) {
			if(position == 1)
				setHead(nodeToInsert);
			int temp = 1;
			Node curr = head;
			while(curr != null && temp < position) {
				curr = curr.next;
				temp++;
			}
			if(curr != null)
				insertBefore(curr, nodeToInsert);
			else
				setTail(nodeToInsert);
		}
		
		// Incomplete
		// O(n) time | O(1) space
		public void removeNodesWithValue(int value) {
			Node temp = head;
			while(temp != null) {
				// Always use temporary var(here curr) to store nodes which are to be swapped or deleted.
				Node curr = temp;
				temp = temp.next;		
				if(curr.value == value)
					remove(curr);
			}
		}
		
		// O(1) time | O(1) space
		public void remove(Node node) {
			// If current node is the head
			if(head == node) 	head = head.next;
			// If current node is the tail
			if(tail == node) 	tail = tail.prev;
			if(node.prev != null)
				node.prev.next = node.next;
			if(node.next != null)
				node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
		}
		
		// O(n) time | O(1) space
		public boolean containsNodeWithValue(int value) {
			Node temp = head;
			
//			while(temp != null) {
//				if(temp.value == value)
//					return true;
//			}
//			return false;
//			OR
			
			while(temp != null && temp.value != value)
				temp = temp.next;
			return temp != null;
		}
		
		public void printList() {
			Node temp = head;
			while(temp != null) {
				System.out.print(temp.value + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList obj = new DoublyLinkedList();
		obj.setHead(new Node(1));
		obj.insertAfter(obj.head, new Node(2));
		obj.insertAfter(obj.head, new Node(4));
		obj.insertAfter(obj.head, new Node(5));
		obj.insertAfter(obj.head, new Node(6));
		obj.insertAfter(obj.head, new Node(2));
		obj.insertAfter(obj.head, new Node(2));
		obj.printList();
		obj.removeNodesWithValue(2);
		obj.printList();
		obj.setTail(new Node(19));
		obj.printList();
		obj.insertAtPosition(3, new Node(20));
		obj.printList();
		obj.insertAfter(obj.head.next.next,	new Node(35));
		obj.printList();
		obj.insertBefore(obj.tail.prev.prev, new Node(60));
		obj.printList();
		System.out.println(obj.containsNodeWithValue(60));
	}
}
