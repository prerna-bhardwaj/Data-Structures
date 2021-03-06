import java.util.Scanner;

public class DeleteNodeWithTargetValue {
	static Scanner sc = new Scanner(System.in);

	public static Node deleteNodes(Node node, int target) {
        if(node == null)    return node;
        while(node != null && node.data == target)
            node = node.next;
        if(node == null)    return node;
        Node curr = node;
        while(curr.next != null) {
            if(curr.next.data == target)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }    
        return node;
    }
	
	static void printList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		System.out.print("Enter size of List : ");
		int n = sc.nextInt();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        Node tail = head;
        for(int i = 1; i < n; i++)
        {
            int a = sc.nextInt();
            tail.next = new Node(a);
            tail =tail.next;
        }
		System.out.print("Enter target value : ");
        int target = sc.nextInt();
        head = deleteNodes(head, target);
        printList(head);
	}
}
