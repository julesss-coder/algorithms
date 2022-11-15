/*
=======================================================
Selection Sort
-------------------------------------------------------
Repeat until you reach the second-to-last number in the array:
    // (Once you are at the second-to-last position, the last number === the leftmost number in the unsorted part of the array => you don't need to do anything
    1. Find the smallest number in the unsorted part of the array
      |--sorted--|--unsorted--|
                [| 3, 0, 2, 1]
                      * <-- smallest number
    2. Swap it with the leftmost number of the unsorted part of the array
         |--sorted--|--unsorted--|
                [0, | 3, 2, 1]
       If the smallest number === the leftmost number in the unsorted part of the array, do nothing
        The first number is now sorted.
        |3021
          *
         0|321
             *
         012|3
             *
Return array
=======================================================
*/

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {6, 3, 0, -8, 2, 45, 2};

        if (array.length == 0 || array.length == 1) {
            System.out.println("Array: " + Arrays.toString(array));
            return;
        }

        // Check if array is sorted already
        boolean arrayIsSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                arrayIsSorted = false;
                break;
            }
        }
        if (arrayIsSorted) {
            System.out.println("Sorted array: " + Arrays.toString(array));
            return;
        }

        int unsortedStartIndex = 0;
        // Repeat until you reach the second-to-last number in the array:
        for (int i = 0; i < array.length - 1; i++) {
            //  Find the smallest number in the unsorted part of the array
            int currentSmallestNumber = array[unsortedStartIndex];
            int indexCurrentSmallestNumber = unsortedStartIndex;

            // (Iterating only over unsorted part of array:)
            for (int j = unsortedStartIndex + 1; j < array.length; j++) {
                if (array[j] < currentSmallestNumber) {
                    currentSmallestNumber = array[j];
                    indexCurrentSmallestNumber = j;
                }
            }

            // If the smallest number !== the leftmost number in the unsorted part of the array (in which case you don't have to do anything):
            if (indexCurrentSmallestNumber != unsortedStartIndex) {
                // Swap smallest number with the leftmost number of the unsorted part of the array
                int temp = array[unsortedStartIndex];
                array[indexCurrentSmallestNumber] = temp;
                array[unsortedStartIndex] = currentSmallestNumber;
            }
            // The sorted part of the array now includes one element more:
            unsortedStartIndex++;
        }

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

// ===================================================

/*
 * array = [6, 1, 7, 8, 9, 3, 5, 4, 2]
 *
 * sortedNumbers = 0
 *
 * array.length times:
 *   // Get smallest number in unsorted part of array:
 *   currentSmallest = array[0]
 *   For each number in array, starting from the one at index `sortedNumbers` + 1:
 *       If number < currentSmallest:
 *           currentSmallest = number
 *
 *   // Put smallest number at the end of sorted part of array:
 *   If currentSmallest !== number at index `sortedNumbers`:
 *       Swap currentSmallest with number at index `sortedNumbers`:
 *           Copy number at index `sortedNumbers` to index of currentSmallest
 *           Insert currentSmallest at index `sortedNumbers`
 *
 *   sortedNumbers++
 *
 * Return sorted array
 *
 *
 * ========
 *
 * TESTS
 * Edge cases:
 * sorted array OK
 * with duplicates OK
 * empty array OK
 *
 * */

/*
//import java.util.Arrays;
//
//public class SelectionSort {
//    public static void main(String[] args) {
//        int[] array = {3, 2, 1};
//        int sortedNumbers = 0;
//        int currentSmallest;
//        int indexCurrentSmallest;
//
//        if (array.length == 0 || array.length == 1) {
//            System.out.println("Array: " + Arrays.toString(array));
//            return;
//        }
//
//        // Check if array is sorted already
//        boolean arrayIsSorted = true;
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                arrayIsSorted = false;
//                break;
//            }
//        }
//
//        if (arrayIsSorted == true) {
//            System.out.println("Sorted array: " + Arrays.toString(array));
//            return;
//        }
//
//        // Find the smallest number in the unsorted part of the array, and add it to end of sorted part of array:
//        for (int j = 0; j < array.length; j++) {
//            currentSmallest = array[sortedNumbers];
//            indexCurrentSmallest = sortedNumbers;
//            for (int k = sortedNumbers + 1; k < array.length; k++) {
//                if (array[k] < currentSmallest) {
//                    currentSmallest = array[k];
//                    indexCurrentSmallest = k;
//                }
//            }
//
//            // If current smallest is not already in first position, swap current smallest with first number in array:
//            if (currentSmallest != array[sortedNumbers]) {
//                array[indexCurrentSmallest] = array[sortedNumbers];
//                array[sortedNumbers] = currentSmallest;
//            }
//
//            sortedNumbers++;
//        }
//
//        System.out.println("Sorted array: " + Arrays.toString(array));
//    }
//}
*/
