/*
 * Please note that, we need to find and delete middle element. 
 * Deleting an element from middle is not O(1) for array. 
 * Also, we may need to move the middle pointer up when we push an element and 
 * move down when we pop(). In singly linked list, moving middle pointer in both 
 * directions is not possible. The idea is to use Doubly Linked List (DLL). 
 * We can delete middle element in O(1) time by maintaining mid pointer. 
 * We can move mid pointer in both directions using previous and next pointers. 
 */

public class FindMiddleElement {
	class DLLNode {
		int data;
		DLLNode next, prev;
		DLLNode(int x) {
			this.data = x;
			this.next = this.prev = null;
		}
	}
	
	DLLNode head, mid;
	int cnt;
	FindMiddleElement() {
		head = mid = null;
		cnt = 0;
	}
	
	void push(int x) {
		DLLNode temp = new DLLNode(x);
		if(head == null) {
			cnt = 1;
			head = mid = temp;
		}
		else {
			cnt++;
			temp.next = head;
			head.prev = temp;
			head = head.prev;
			
			if(cnt%2 == 0) {
				mid = mid.prev;
			}
		}
	}
	
	int pop() {
		if(cnt == 0) {
			System.out.println("Stack underflow.");
			return -1;
		}
		int item = head.data;
		head = head.next;
		cnt--;
		if(head != null)
			head.prev = null;
		if(cnt%2 != 0) {
			mid = mid.next;
		}
		return item;
	}
	
	int findMiddleElement() {
		if(mid == null)
			return -1;
		return mid.data;
	}
	
	int deleteMiddleElement() {
		if(mid == null) {
			return -1;
		}
		int val = mid.data;
		if(mid == head) {
			mid = head = null;
			cnt--;
			return val;
		}
		DLLNode temp = mid.next;
		temp.prev = mid.prev;
		if(mid.prev != null) {
			mid.prev.next = temp;
		}
		cnt--;
		if(cnt%2 != 0) 
			mid = temp;
		else 
			mid = temp.prev;
		return val;
	}
	
	public static void main(String args[]) {
		FindMiddleElement obj = new FindMiddleElement();
		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.push(50);
		obj.push(60);
		obj.push(70);
		System.out.println("Element popped : " + obj.pop());
		System.out.println("Element popped : " + obj.pop());
		System.out.println("Element popped : " + obj.pop());
		System.out.println("Middle element : " + obj.findMiddleElement());
		System.out.println("Element popped : " + obj.deleteMiddleElement());
		System.out.println("Middle element : " + obj.findMiddleElement());
	}
}
