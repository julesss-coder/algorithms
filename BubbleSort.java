/*
* Strategy 1
* ===============================================================================================
* Summary: Move greatest number to the right, consider it sorted. Repeat until array is sorted.
* ===============================================================================================
* Top-down outline:
*
* sortedElements = 0
*
* array.length - 1 times:
*   For each number in array, until index < array.length - 1 - sortedElements:
*       if number > right number:
*           Swap numbers:
*               temp = right number
*               Insert current number to the right
*               Insert temp at current position
*
*   // Greatest number has been moved to the right
*   sortedElements++
*
* Return sorted array
*
* ==============================================================================================
* Questions
* - Why not use an array instead of an ArrayList?
* ==============================================================================================
* Tests
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

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {5, 9, 3, 1};
        int sortedElements = 0;

        // On each iteration (i), transport the largest number to the end of the array
        int i = 0;
        while (i < numbers.length - 1) {
            for (int j = 0; j < numbers.length - 1 - sortedElements; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
            sortedElements++;
            i++;
        }

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
