/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Solution1 : using hashset
Solution2 : LL cycle detection algo

Refer : https://leetcode.com/problems/happy-number/solution/

*/

public class HappyNumber {
	public static int getSum(int n) {
        int sum = 0;
        while(n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }
    
    // Used the Floyd's cycle detection algo
    // O(logn) time | O(1) space
    public static boolean isHappy(int n) {
        int slow = n, fast = getSum(n);
        while(fast != 1 && fast != slow){
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        }
        return fast == 1; 
    }

    public static void main(String[] args) {
    	System.out.println(isHappy(100));
    }
}

/*
The chain we get by repeatedly calling getNext(n) is an implicit LinkedList. Implicit means we don't have actual LinkedNode's 
and pointers, but the data does still form a LinkedList structure. The starting number is the head "node" of the list, and 
all the other numbers in the chain are nodes. The next pointer is obtained with our getNext(n) function above.

This algorithm is based on 2 runners running around a circular race track, a fast runner and a slow runner. In reference to a 
famous fable, many people call the slow runner the "tortoise" and the fast runner the "hare".

Regardless of where the tortoise and hare start in the cycle, they are guaranteed to eventually meet. This is because the hare 
moves one node closer to the tortoise (in their direction of movement) each step.
*/