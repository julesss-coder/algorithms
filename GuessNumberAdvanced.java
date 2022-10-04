/*

* changing an array or object in a method changes it globally, as it is passed by reference
* This does not apply to primitive values

* How to slice an array in Java (when changing numberRange)?
STRATEGY 1
*
* User, computer
* userGuesses = 0
* computerGuesses = 0
* guessesSoFar = ""
*
* // Generate an integer range
* a, b = ask user to enter two integers
* Array numberRange = [a, b] // number range between a and b (both inclusively)
*
* // Generate randomNum within numberRange
* Inform user that randomNum has been generated
*
* // Decide who will start playing
* startsFirst = generate random int between 0 and 1
*   If startsFirst === 0:
*       // userGuesses()
*           userGuess = ask user to enter an integer within numberRange
*           Check user guess: // use method
*               if userGuess > randomNum:
*                   your num is > randomNum
*                   numberRange = [a, userGuess - 1]
*               else if userGuess < randomNum:
*                   your num is < randomNum
*                   numberRange = [userGuess + 1, b]
*               else if userGuess === randomNum:
*                   You guessed correctly
*                   Game over. User won. Would you like to play another round?
*               userGuesses++
*               guessesSoFar += userGuess
*   Else if startsFirst === 1:
*       // computerGuesses()
*           computerGuess = generate random int within numberRange
*               Check computer guess // Use method
*               // Same as above, but for computerGuess
*
* Method userGuesses(numberRange):
*
*
* Method computerGuesses(numberRange):
*
* */


import java.util.Random;
import java.util.Scanner;

public class GuessNumberAdvanced {
    public static void main(String[] args) {
        while (playRound() == 1) {
            playRound();
        }
    }

    static int playRound() {
        int userGuess;
        int computerGuess;
        int userGuesses = 0;
        int computerGuesses = 0;

        // Let user choose an integer range
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an integer.");
        int rangeStart = scanner.nextInt();
        System.out.println("Please enter another integer, greater than the first one.");
        int rangeEnd = scanner.nextInt();
        while (rangeStart == rangeEnd) {
            System.out.println("The second integer should be different from the first. Please try again and enter another integer.");
            rangeEnd = scanner.nextInt();
        }

        while (rangeStart > rangeEnd) {
            System.out.println("The second integer should be greater than the first. Please try again and enter another integer.");
            rangeEnd = scanner.nextInt();
        }

        int numberRange[] = { rangeStart, rangeEnd };

        String previousGuesses = "";

        // Create random number within numberRange
        Random random = new Random();
        int randomNum = random.nextInt(rangeStart, rangeEnd + 1);
        System.out.println("A random integer between " + rangeStart + " " + rangeEnd + " has been generated. Time to play!");
        int anotherRound = 0;

        // Decide who will start playing
        int startsFirst = random.nextInt(0, 2);
        System.out.println("startsFirst: " + startsFirst);
        if (startsFirst == 0) {
            // user starts playing // extract into method userGuesses() later
            System.out.println("Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");

            // Ask user to guess random number in range
            // **** repeat guesses until user guesses correctly
            userGuess = scanner.nextInt();
            userGuesses++;
            while (userGuess < rangeStart || userGuess > rangeEnd) {
                System.out.println("Please try again. Enter an integer between " + rangeStart + " and " + rangeEnd + " .");
                userGuess = scanner.nextInt();
            }

            while (userGuess != randomNum && userGuesses <= 9) {
                previousGuesses = checkUserGuess(userGuess, randomNum, previousGuesses, numberRange);
                System.out.println("Try again and guess an integer between " + rangeStart + " and " + rangeEnd + ".");
                userGuess = scanner.nextInt();
                userGuesses++;
            }

        } else if (startsFirst == 1) {
            // computer starts playing
        }



        if (guesses > 9) {
            System.out.println("You have guessed too many times. Game over.");
        }

        if (numGuess == randomNum) {
            previousGuesses += "" + numGuess + ", ";
            System.out.println("Your guesses so far: " + previousGuesses);
            System.out.println("You guessed the number correctly! Well done!");
            System.out.println("Would you like to play another round? Press 1 for yes and 0 for no.");
            anotherRound = scanner.nextInt();
        }

        return anotherRound;
    }



    static String checkUserGuess(int userGuess, int randomNum, String previousGuesses, int[] numberRange) {
        if (userGuess > randomNum) {
            System.out.println("The number you guessed is greater than the random number.");
            // changeNumberRange()
        } else if (userGuess < randomNum) {
            System.out.println("The number you guessed is smaller than the random number.");
            // changeNumberRange()
        }

        previousGuesses += "" + userGuess + ", ";
        System.out.println("Your guesses so far: " + previousGuesses);
        return previousGuesses;
        // return numberRange
//        System.out.println("Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");
//        numGuess = scanner.nextInt();
    }

    static String checkComputerGuess(int computerGuess, int randomNum, String previousGuesses, int[] numberRange) {
        if (computerGuess > randomNum) {
            System.out.println("The number you guessed is greater than the random number.");
        } else if (computerGuess < randomNum) {
            System.out.println("The number you guessed is smaller than the random number.");
        }

        previousGuesses += "" + computerGuess + ", ";
        System.out.println("Your guesses so far: " + previousGuesses);
        return previousGuesses;
        // return numberRange
    }

    static int[] changeNumberRange(int[] numberRange) {
        // numberRange = [a, userGuess - 1] OR
        // numberRange = [userGuess + 1, b]
    }
}
