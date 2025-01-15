# Find-the-Index-of-the-Large-Integer
Challenge at LeetCode.com. Tags: Binary Search, Interactive.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

There are two approaches for this problem in regard to how the ranges of elements are divided into two subranges.

1.  Always divide the entire range into two subranges and overlap the middle element in case that the range has an odd number of elements.

2.  Always divide the biggest even number of elements into two subranges, i.e. if the entire range has an odd number of elements, then the last element is not included in the current division into two subranges. 

The solution presented here selects the first approach. The benefit of choosing the first approach is that if the searched element is in the middle,and the range that is being divided is an odd number, then we immediately arrive at the solution. 

On the other hand, the second approach always iterates and narrows down the range, no matter what, until there is only one element in the range.

Examples for the first approach, when a range with an odd length is encountered and the searched element is in the middle.

Example 1:<br/>
At start, there are 100 001 elements.<br/>
100 000 elements to the left | searched element | 100 000 elements to the right<br/>
There are no iterations in the loop that divides the range.

Example 2:<br/>
At start, there are 100 002 elements.<br/>
100 001 elements to the left | 100 001 elements to the right<br/>
After one iteration, we have:<br/>
50 000 elements to the left | searched element | 50 000 to the right<br/> 
There is only one iteration in the loop that divides the range.
