public class ReverseBetweenList {
	// Method 1
	public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode ptr1 = start;
        int index = 0;
        while(index < left-1) {
            ptr1 = ptr1.next;
            index++;            
        }
        ListNode ptr2 = ptr1;
        while(index < right) {
            ptr2 = ptr2.next;
            index++;            
        }
        ListNode part2 = ptr2.next;
        ptr2.next = null;
        ptr1.next = reverse(ptr1.next);
        while(ptr1.next != null)
            ptr1 = ptr1.next;
        ptr1.next = part2;
        return start.next;
    }    
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    // Method 2 - reverse in place ???
}