import java.util.*;

class BasicOperationsOnSLL {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    private Node head;
    private int size;
    
    /** Initialize your data structure here. */
    public BasicOperationsOnSLL() {
        head = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size)  return -1;
        int i = 0;
        Node temp = head;
        while(temp != null && i < index) {
            temp = temp.next;
            i++;
        }
        if(temp != null)    return temp.val;
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head == null)
            head = temp;
        else {
            Node temp1 = head;
            while(temp1.next != null)
                temp1 = temp1.next;
            temp1.next = temp;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int i = 0;
        size++;
        Node node = new Node(val);
        if(index == 0) {
            node.next = head;
            head = node;
            return;
        }
        Node temp = head;
        while(i < index-1) {
            i++;
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)  return;
        size--;
        if(index == 0) {
            head = head.next;
            return;
        }
        int i = 0;
        Node temp = head;
        while(i < index-1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
    }
    
    public void printList() {
    	Node temp = head;
    	while(temp != null) {
    		System.out.print(temp.val + " ");
    		temp = temp.next;
    	}
    	System.out.println();
    }
    
    // 0-based indexing is followed for all operations
    public static void main(String[] args) {
    	BasicOperationsOnSLL obj = new BasicOperationsOnSLL();
    	obj.addAtHead(1);
    	obj.printList();
    	obj.addAtTail(2);
    	obj.printList();
    	obj.addAtIndex(1,3);
    	obj.printList();
    	obj.deleteAtIndex(1);    	
    	obj.printList();
    	int param_1 = obj.get(1);
    	System.out.println("Element at index 1 : " + param_1);
    }
}
