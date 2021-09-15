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