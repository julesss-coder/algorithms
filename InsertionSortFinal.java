/*
* BUGS
*
* [3, 2, 1, 0, -1] is sorted as [-1, 0, 1, 2, 1] - Why?
* */

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSortV2 {
    public static void main(String[] args) {
        // array = 3 2 6 4 1
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(3, 2, 1, 0, -1)
        );
        // Includes the given index
        int sortedUntilIndex = 0;
        // For each number in nums, starting from the first:
        for (int indexOfNumToBeSorted = 1; indexOfNumToBeSorted < nums.size(); indexOfNumToBeSorted++) {
            int numToBeSorted = nums.get(indexOfNumToBeSorted);
            int index = indexOfNumToBeSorted - 1;

            if (numToBeSorted < nums.get(index)) {
                // Checking if numToBeSorted < nums[index] is necessary despite previous line, because index is changed.
                while (index >= 0 && numToBeSorted < nums.get(index)) {
                    index--;
                }

                int insertionIndex = index + 1;
                int temp1 = nums.get(insertionIndex);
                nums.set(insertionIndex, numToBeSorted);
                insertionIndex++;

                while (insertionIndex < indexOfNumToBeSorted) {
                    int temp2 = nums.get(insertionIndex);
                    nums.set(insertionIndex, temp1);
                    insertionIndex++;
                    temp1 = nums.get(insertionIndex);
                    nums.set(insertionIndex, temp2);
                    insertionIndex++;
                }
                // Once insertionindex === 5, the array is sorted correctly, but the next line reinserts `temp1` at last
                // position.
                // Fix: Can this line be put into while loop?
                // Current fix: Set if condition:
                if (insertionIndex < nums.size()) {
                    nums.set(indexOfNumToBeSorted, temp1);
                }
                sortedUntilIndex++;
            } else {
                sortedUntilIndex++;
                continue;
            }
        }

        System.out.println("Sorted array `nums`: " + nums);

    }
}
