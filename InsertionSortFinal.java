/*
* ================================================================================
* To do:
* - In each iteration over array, check if array is sorted. If true, return array.
* ================================================================================
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSortV3 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(5, -5, 0, 5, 222, -63)
        );

        // As first number is considered sorted, start iterating from the second:
        for (int indexOfNumToBeSorted = 1; indexOfNumToBeSorted < nums.size(); indexOfNumToBeSorted++) {
            int numToBeSorted = nums.get(indexOfNumToBeSorted);

            // Find out where to insert numToBeSorted by comparing numToBeSorted with left neighbour.
            // As long as numToBeSorted < current number, copy current number to the right.
            // After all numbers >= numToBeSorted have been pushed one position to the right, insert numToBeSorted at insertionIndex.
            int i = indexOfNumToBeSorted - 1;
            if (numToBeSorted < nums.get(i)) {
                // Checking if numToBeSorted < nums[i] is necessary despite previous line, because `i` is changed.
                while (i >= 0 && numToBeSorted < nums.get(i)) {
                    // Copy current number:
                    int temp = nums.get(i);
                    // Insert current number to the right
                    nums.set(i + 1, temp);
                    //
                    i--;
                }
                int insertionIndex = i + 1;
                nums.set(insertionIndex, numToBeSorted);
            }
        }

        System.out.println("Sorted array `nums`: " + nums);
    }
}
