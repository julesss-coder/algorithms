// ### Insertion Sort - FIRST SHITTY DRAFT

// #### Knobs:


// #### Strategy 1

// Summary:

// Top-down outline:
// arr	9|235728691
//         * *
// temp1 = 2
// temp2 = 3
// temp =  4
// i	01|2345678
//          x
	 
// sorted    | unsorted

// x = leftmost number in unsorted array


// Let arr be an array of numbers.

// For each number in arr, starting from the second:
// 	If number >= left number OR if number is first in array:
// 		x = index of number
// 		Mark arr sorted until including current position
// 		Continue

// 	Else if number < left number:
// 		x = index of left number
// 		Until number >= left number OR left number is first in array:
// 			x--;
// 			Compare number to number at position x
		
		

// 		Once number >= the number you are comparing to || there are no more numbers to compare to:
// 			// Swap numbers (recursion)

// 			// While x < first position of sorted part of array:
// 			temp1 = number
// 			temp2 = number at position x
// 			insert temp1 at position x
// 			x++

// 			For each number in sorted part of arr, starting from index x:
// 				// How to abstract this even more?
// 				temp1 = number at index x
// 				Insert temp2at index x
// 				x++
// 				temp2 = number at index x
// 				insert temp1 at index x
// 				x++

// 			// Stopping condition: x === (first position of unsorted part of array) + 1
// end of sorted part of arr
// 				Insert the most recent temp variable in the original place of number (first position in unsorted part of array)
// 				Mark arr sorted until including current position

		
// Return sorted array


// =================

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(4, 2, 6, 3, 1, 5)
        );

        // 4, 2, | 6, 3, 1, 5
        //    *
        // temp1 = 2
        // tem2 = 4
        int sortedUntilIndex;
        int indexToCompareTo;

        // How to iterate through ArrayList?
        for (int i = 1; i < nums.size(); i++) {
            indexToCompareTo = i - 1;
            // Find correct place to insert current number:
            // Check indexToCompareTo first, otherwise if it is negative, an error is thrown as there is no element at this position:
            while (indexToCompareTo >= 0 && nums.get(i) < nums.get(indexToCompareTo)) {
                System.out.println("i: " + i);
                System.out.println("index to compare to: " + indexToCompareTo);
                indexToCompareTo--;
                System.out.println("i: " + i);
                System.out.println("index to compare to: " + indexToCompareTo);
            }
            sortedUntilIndex = i; // Stimmt das?
            // Auf indexToCompareTo die Zahl einfuegen
            // Erst einfuegen
            // Dann als sortiert markieren
            int j = 0;
            // DAS NOCH EINMAL DURCHDENKEN - WAS WILL ICH HIER MACHEN?
            while (j < sortedUntilIndex) {
                int temp1 = nums.get(sortedUntilIndex + 1);
                // Does  not work because indexToCompareTo is -1
                int temp2 = nums.get(indexToCompareTo);
                nums.set(indexToCompareTo, temp1);
                j++;
                sortedUntilIndex = j;
                nums.set(j, temp2);
            }
        }

        System.out.println("Sorted array list: " + nums);
    }
}
