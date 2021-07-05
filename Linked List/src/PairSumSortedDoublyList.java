import java.util.Scanner;

// saving dll ka code check karo
class DLLNode {
	int data;
	DLLNode next;
	DLLNode prev;
	
	DLLNode(int data) {
		this.data = data;
		this.next = this.prev = null;
	}
}

public class PairSumSortedDoublyList {	
	static Scanner sc = new Scanner(System.in);
	
	static void printList(DLLNode head) {
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
        DLLNode head = new DLLNode(a1);
        DLLNode tail = head;
        for(int i = 1; i < n; i++)
        {
            int a = sc.nextInt();
            tail.next = new DLLNode(a);
            tail.next.prev = tail;
            tail =tail.next;
        }
        System.out.print("Enter sum : ");
        int sum = sc.nextInt();
        pairSum(head, sum);
	}

	private static void pairSum(DLLNode head, int sum) {
		DLLNode start = head;
		DLLNode end = head;
		while(end.next != null)
			end = end.next;
		
		boolean flag = false;
		while(start != end && end.next != start) {
			int temp = start.data + end.data;
			if(temp == sum) {
				 flag = true;
				 System.out.println( "Found : (" + start.data + ", "+ end.data + ")" );
				 start = start.next;
				 end = end.prev;
				 
			}
			else if(temp > sum)
				end = end.prev;
			else 
				start = start.next;
		}
		if(flag == false)
			System.out.println("No pairs found.");
	}
	
}
