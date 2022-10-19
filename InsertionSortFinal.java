/*
* TEST CASES
* === TESTED ===
* positive and neg numbers
    * numbers including 0 OK
    * no 0 OK
    * duplicates OK
    * no duplicates OK

* negative numbers
    * duplicates OK
    * no duplicates OK
    *
* positive numbers
    * duplicates OK
    * no duplicates OK

* * one number only OK
* * empty array OK
* */

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSortV2 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(34, -394, 0, 45, 0, 23)
        );

        // As first number is considered sorted, start iterating from the second:
        for (int indexOfNumToBeSorted = 1; indexOfNumToBeSorted < nums.size(); indexOfNumToBeSorted++) {
            int numToBeSorted = nums.get(indexOfNumToBeSorted);

            // Find out where to insert numToBeSorted by comparing numToBeSorted with left neighbour:
            int i = indexOfNumToBeSorted - 1;
            if (numToBeSorted < nums.get(i)) {
                // Checking if numToBeSorted < nums[i] is necessary despite previous line, because `i` is changed.
                while (i >= 0 && numToBeSorted < nums.get(i)) {
                    i--;
                }
                int insertionIndex = i + 1;

                // Insert numToBeSorted at insertionIndex:
                    // Starting with numToBeSorted, swap each number with its left neighbour until before insertionIndex.
                for (int j = indexOfNumToBeSorted; j > insertionIndex ; j--) {
                    int temp = nums.get(j - 1);
                    nums.set(j, temp);
                }

                nums.set(insertionIndex, numToBeSorted);
            }
        }

        System.out.println("Sorted array `nums`: " + nums);
    }
}
