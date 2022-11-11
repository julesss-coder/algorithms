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
* */

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {6, 1, 7, 8, 9, 3, 5, 4, 2};
        int sortedNumbers = 0;
        int currentSmallest;
        int indexCurrentSmallest;

        for (int i = 0; i < array.length; i++) {
            currentSmallest = array[sortedNumbers];
            indexCurrentSmallest = sortedNumbers;
            for (int j = sortedNumbers + 1; j < array.length; j++) {
                if (array[j] < currentSmallest) {
                    currentSmallest = array[j];
                    indexCurrentSmallest = j;
                }
            }

            if (currentSmallest != array[sortedNumbers]) {
                array[indexCurrentSmallest] = array[sortedNumbers];
                array[sortedNumbers] = currentSmallest;
            }

            sortedNumbers++;
        }

        System.out.println(array);
    }
}
