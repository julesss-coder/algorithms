/* Strategy 1
*
* string = B  I  N  G  O
* i        *
* a = 1
* b = 15
* bingoNums = [ [], [], [], [], [] ]
* bingoCard = ""
*
* // Create the numbers to be printed on Bingo Card:
* 5 times (from 0 to 5):
*   Create 5 random numbers between a and b (both inclusive):
*       Create a random number between a and b (both inclusive):
*       While random number is in current array: // using. [].contains()
*           Create random number between a and b
*       Add random number to current array
*
*   a = b + 1
*   b = b + 15
*
* replace bingoNums[2][2] with "X" // for "free space"
*
* // Generate Bingo Card:
* bingoCard += string + \n
*
* 5 times:
*   5 times: // j = 0, while j < 5
*       for each array in bingoNums:
*           bingoCard += array[j] + " "
*       bingoCard += \n
*       j++
*
* Print bingoCard to console
*
*
* TRACE
*
* a = 61
* b = 75
* bingoNums = [ [1, 2, 3, 4, 5], [16, 17, 18, 19, 20], [31, 32, X, 34, 35], [46, 47, 48, 49, 50], [61, 62, 63, 64, 65] ]
* j =               *
* bingoCard = "B  I  N  G  O
*              1 16 31 46 61\n
*              2 17 32 47 62\n
*
*
*
* =============
* BUGS
* === OPEN ===
* - Formatting is wrong
*   => Use string formatter with width
*
* === SOLVED ===
* - bingoNums[2][2] should be empty, but bingoNums is an int array and does not take a String as an argument
*       => turn all ints into Strings
* - Arrays contain duplicate numbers
* =========
* */

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class BingoCard {
    public static void main(String[] args) {
        String string = "B  I  N  G  O";
        int a = 1;
        int b = 15;
        String[][] bingoNums = new String[5][5];
        String bingoCard = "";
        
        // Create the numbers to be printed on Bingo Card:
        for (int j = 0; j < bingoNums.length ; j++) {
            int i = 0;
            while (i < 5) {
                Random random = new Random();
                boolean found;
                int randomNum;
                do {
                    found =false;
                    randomNum = random.nextInt(a, b + 1); // Does this generate the correct range?
                    // Check if current array already has randomNum
                    for (int k = 0; k < i; k++) {
                        // Only works if I convert randomNum to String
                        if (String.valueOf(bingoNums[j][k]).equals(String.valueOf(randomNum))) {
                            found = true;
                            System.out.printf("%b: ", found);
                            break;
                        }
                    }
                } while (found == true);

                bingoNums[j][i] = Integer.toString(randomNum);
                i++;
            }

            a = b + 1;
            b = b + 15;
        }

        // delete bingoNums[2][2]; // for "free space"
        bingoNums[2][2] = " ";

        // Generate Bingo Card:
        bingoCard += string + "\n";
        System.out.println(bingoCard);

        // OPTION: Add check for empty field in bingoNums[2][2] here instead of when creating arrays
        int l = 0;
        while (l < 5) {
            for (int j = 0; j < bingoNums.length; j++) {
                bingoCard += bingoNums[j][l] + " ";
            }
            bingoCard += "\n";
            l++;
        }


        System.out.println(bingoCard);

    }
}
