
public class Solution {

    public int getIndex(ArrayReader reader) {
        int length = reader.length();

        int firstLeft = 0;
        int firstRight = (length - 1) / 2;

        int secondLeft = firstRight + balanceIndexForRangeWithOddLength(length);
        int secondRight = length - 1;

        int compare = reader.compareSub(firstLeft, firstRight, secondLeft, secondRight);

        while (compare != 0) {

            if (compare < 0) {
                length = secondRight - secondLeft + 1;
                firstLeft = secondLeft;
                firstRight = secondLeft + (secondRight - secondLeft) / 2;
                secondLeft = firstRight + balanceIndexForRangeWithOddLength(length);
            } else {
                length = firstRight - firstLeft + 1;
                secondRight = firstRight;
                firstRight = firstLeft + (firstRight - firstLeft) / 2;
                secondLeft = firstRight + balanceIndexForRangeWithOddLength(length);
            }
            compare = reader.compareSub(firstLeft, firstRight, secondLeft, secondRight);
        }

        return firstRight;
    }

    /*
    When the range that is divided between the two subranges has an odd length, 
    then the end of the first range has to overlap with the start of the second range.
    That is to say, if we have subrange(firstLeft, firstRight) and subrange(secondLeft, secondRight), 
    then 'firstRight' ==  'secondLeft'.
     */
    private int balanceIndexForRangeWithOddLength(int length) {
        return (length % 2) ^ 1;
    }
}

/*
Interface 'ArrayReader' is implemented internally at leetcode.com.
When running the code on the website, do not include this interface.
The comments below are from leetcode.com.
 */
// This is ArrayReader's API interface.
// You should not implement it, or speculate about its implementation
interface ArrayReader {
    // Compares the sum of arr[l..r] with the sum of arr[x..y] 
    // return 1 if sum(arr[l..r]) > sum(arr[x..y])
    // return 0 if sum(arr[l..r]) == sum(arr[x..y])
    // return -1 if sum(arr[l..r]) < sum(arr[x..y])

    public int compareSub(int l, int r, int x, int y);
    // Returns the length of the array

    public int length();
}
