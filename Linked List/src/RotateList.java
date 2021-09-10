public class RotateList {
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        int len = getLength(head);
        k = k % len;
        if(k == 0)
            return head;
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        int index = 0;
        while(index++ < k) 
            fast = fast.next;
        ListNode slow = start;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
    
    public static int getLength(ListNode head) {
        int len = 0;
        ListNode start = new ListNode();
        start.next = head;
        ListNode temp = start;
        while(temp.next != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}