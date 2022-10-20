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
        int[] numbers = {5, 9, 3, 1, 2, 8, 4, 7, 6};
        int sortedElements = 0;

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

/*
* Trace
* ============================================================================================
* sortedElements = 3
* numbers = {1, 3, 5, 9}
* i                *
* j          *
*
* i = 2
* j = 0
* numbers.length - 1 - sortedElements = 0
*
* temp = 1
*
*
* */
