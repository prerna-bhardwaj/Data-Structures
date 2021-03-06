# Data Structures


A pangram is a sentence where every letter of the English alphabet appears at least once.

Java provides a method for comparing two Array List. The ArrayList. equals() is the method used for comparing two Array List. It compares the Array lists as, both Array lists should have the same size, and all corresponding pairs of elements in the two Array lists are equal.

There are built-in intersection facilities, which provide O(n+m) time complexity in the average case and O(n×m) time complexity in the worst case.
- In Python it's intersection operator, in Java - retainAll() function.
set1.retainAll(set2) => equivalent to intersection(set1, set2) 


- Array of Strings are sorted in lexicographic order. Create custom comparator for sorting by length.

- Add custom comparator in priority queue for ordering elements in descending/anything other than the default ordering i.e. increasing order.

- To check is a number is perfect square or not -
	double root = Math.sqrt(num);
	if(Math.floor(root) - root == 0)  -> is perfect square
	else 							  -> not a perfect square 

- Bijection - mapping has to be one to one onto. 
- Either use 2 hashmaps for saving values from a->b and b->a.
- OR use 1 hashmap and 1 set. hashmap contains a->b mapping. Whereas set will hold all values from b that have been mapped to some value in a.

### Ternary Search Algorithm
In Binary Search, we choose the middle element as the pivot in splitting. 
In Ternary Search, we choose two pivots (say m1 and m2) such that the given range is divided into three equal parts. If the required number num is less than m1 then we apply ternary search on the left segment of m1. If num lies between m1 and m2, we apply ternary search between m1 and m2. Otherwise we will search in the segment right to m2.

public int ternarySearch(int n) {
    int low = 1;
    int high = n;
    while (low <= high) {
        int mid1 = low + (high - low) / 3;
        int mid2 = high - (high - low) / 3;
        int res1 = guess(mid1);
        int res2 = guess(mid2);
        if (res1 == 0)
            return mid1;
        if (res2 == 0)
            return mid2;
        else if (res1 < 0)
            high = mid1 - 1;
        else if (res2 > 0)
            low = mid2 + 1;
        else {
            low = mid1 + 1;
            high = mid2 - 1;
        }
    }
    return -1;
} 

- Next.previous smaller element - increasing stack
next smaller element - L To R
prev smaller element - R to L


- Next.previous larger element - decreasing stack
next larger element - L To R
prev larger element - R to L

-- To create clone of array of arraylist - use .clone() method

- For "shortest path" problem, BFS can make our life easier.


- NOTE : To get the rightmost set bit : 
int rightMostSignificantBit = xor & -xor;       // here xor & -xor == xor & (~xor+1)
e.g. : 6 & -6 = 2 (0000..0010) where 6 = 000000..00110 

- To split a string over '.' - split(".") doesn't work. Do split("\\.") instead.

 - If elements of grid/matrix/array/string are not to be used several times, then alter the position of the element in the grid 
    itself. Helps in reducing the space complexity.

### MINIMUM INCREMENT DECREMENT OPERATIONS TO MAKE ARRAY ELEMENT EQUAL
 - Concept
For calculating minimum number of operations to equalize an array, we need to make sure that all the elements are incremented to a value, so that they become equal in the least number of increment/decrement operations.For this, we should select a number which is, basically, nearest to all the elements in the array.

This element will be the middle element of a sorted array.All the elements to the left of this element, will be incremented to its value and all the elements to its right will be decremented to its value.

- Algorithm
Step 1:Sort the array.
Step 2:Find the median of the array.If the array is of odd length, only one median is obtained.If the array is of even length, we obtain 2 medians.
Step 3:Now, start traversing the array, and add the absolute difference of the median and arr[i] to the sum.For even length arrays, repeat this step for both the medians.
Step 4:After reaching the end of the array,we return the minimum sum.


Validate Binary Tree : https://leetcode.com/problems/validate-binary-tree-nodes/discuss/1420058/JAVA-Solution-using-Topological-Sorting