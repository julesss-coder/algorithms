/*
* TODOS
* - [ ] rename variables
* - [ ] create methods
* changing an array or object in a method changes it globally, as it is passed by reference
* This does not apply to primitive values
* - [ ] Add "game over" when a user exceeds 9 guesses
*
* QUESTIONS:
* - Is it even possible to change int[] numRange from within a method? Only possible when I initialize numRange
*   within main(), or elsewhere, as well?
*
* BUGS:
*  - String guessesSoFar is reset every time a player makes a guess.
*       => Add each guess to arrayList guessesSOFar and print them after each guess. Pass them into the methods to change them.
*  - Improve formatting with ===, as it's hard to see the computer's guesses.
*  - "Current player: user" is printed twice in a row.
*  - I am not checking who won!!

* How to slice an array in Java (when changing numRange)?
* STRATEGY 1
*
* =======================
* While anotherRound === 1:
    // METHOD: PLAY ROUND
    * Players: User, computer
    * userAttempts = 0
    * computerAttempts = 0
    * guessesSoFar = ""
    *
    * ===================
    * // Generate an integer range
    * a, b = ask user to enter two integers
    * Array numRange = [a, b] // number range between a and b (both inclusively)
    *
    * randomNum = Generate randomNum within numRange
    * Inform user that randomNum has been generated
    *
    * // Decide who will start playing
    * startsFirst = generate random int between 0 and 1
    * numberGuessed = false
    *   If startsFirst === 0:
    *       While numberGuessed === false:
    *           While userAttempts <= 9:
        *           userGuess = ask user to enter an integer within numRange
        *           // METHOD: USER'S TURN
        *           -------------------
        *           // general METHOD: CHECK GUESS(currentUser (user, computer), int currentGuess, String guessesSoFar, int randomNum)
        *           // Call this method for user and computer
        *               // Return guessesSoFar
        *               // if player is user: userAttempts++
        *               // else if player is computer: computerAttempts++
    *               -------------------
        *           Check user guess:
        *               // If userGuess is incorrect
        *               if userGuess > randomNum:
        *                   your num is > randomNum
        *                   numRange = [a, userGuess - 1]
        *               else if userGuess < randomNum:
        *                   your num is < randomNum
        *                   numRange = [userGuess + 1, b]
        *
        *               userAttempts++
        *               guessesSoFar += userGuess
        *               print guessesSoFar
        *
        *               // Else if userGuess is correct
        *               If userGuess === randomNum:
        *                   numberGuessed = true
        *                   You guessed correctly
        *                   Game over. User won.
        *                   // Exit loop
    *
    *           While computerAttempts <= 9:
        *           computerGuess = generate random int within numRange
        *           // METHOD: COMPUTER'S TURN
        *               Check computer guess
        *               // If computer guess is incorrect:
        *                   if computerGuess > randomNum:
        *                   the computer's num is > randomNum
        *                   numRange = [a, computerGuess - 1]
        *               else if computerGuess < randomNum:
        *                   the computer's num is < randomNum
        *                   numRange = [computerGuess + 1, b]
        *
        *               computerAttempts++
        *               guessesSoFar += computerGuess
        *               print guessesSoFar
        *
        *               // If computer guess is correct:
        *               If computerGuess === randomNum:
        *                   numberGuessed = true
        *                   You guessed correctly
        *                   Game over. Computer won.
        *                   // Exit loop
    *
    *   Else if startsFirst === 1:
    *       // Same as above, but computer comes first:
    *       // Computer's turn
    *       // User's turn
    *
    * anotherRound = Ask user if he would like to play another round, and enter 1 (yes) or 0 (no)
    * while anotherRound < 0 || > 1:
    *   anotherRound = ask user again
* */


import java.util.Random;
import java.util.Scanner;

public class GuessNumberAdvanced {
    public static void main(String[] args) {
        // Check this
        while (playRound() == 1) {
            playRound();
        }
    }

    static int playRound() {
        // Players: User, computer
        int userGuess;
        int computerGuess;
        int userAttempts = 0;
        int computerAttempts = 0;
        String guessesSoFar = "";
        Scanner scanner = new Scanner(System.in);
        Boolean numberGuessed = false;

        // Generate an integer range
        System.out.println("Enter an integer.");
        int rangeStart = scanner.nextInt();
        System.out.println("Enter another integer that is different from the first.");
        int rangeEnd = scanner.nextInt();
        while (rangeStart >= rangeEnd) {
            System.out.println("The second integer needs to be greater than the first one.\nPlease try again and enter another integer.");
            rangeEnd = scanner.nextInt();
        }
        System.out.println("The two integers entered by the user: " + rangeStart + " and " + rangeEnd);
        int[] numRange = { rangeStart, rangeEnd }; // "reassigned local variable" - what does that mean?

        // Create random number within numRange
        Random random = new Random();
        // Does this create a random number within numRange?
        int randomNum = random.nextInt(rangeStart, rangeEnd + 1);
        System.out.println("A random integer between " + rangeStart + " and " + rangeEnd + " has been generated.");
        System.out.println("random integer: " + randomNum);

        // Decide who will start playing
        // Does this create a random int between 0 and 1?
        int startsFirst = random.nextInt(0, 2);

        while (numberGuessed == false) {
            // If user starts the round:
            if (startsFirst == 0) {
                // --- Extract into method UserPlays() --- // returns Boolean numberGuessed
                numberGuessed = UserPlays(randomNum, userAttempts, guessesSoFar, numRange, numberGuessed);
                if (numberGuessed == true) {
                    System.out.println("Congratulations to the user! You won!");
                }
//                System.out.println("Current player: user.");
//                // let user guess (returns userGuess)
//                userGuess = LetUserGuess(randomNum, userAttempts, guessesSoFar, numRange);
//                guessesSoFar += userGuess + ", ";
//                System.out.println("Both players' guesses so far: " + guessesSoFar);
//                // Check user's guess (returns true or false)
//                numberGuessed = CheckPlayerGuess(userGuess, randomNum, numberGuessed, numRange);
                // ---- End of method UserPlays() ----
                // If the user guessed incorrectly, it's the computer's turn:
                if (numberGuessed == false) {
                    // Let computer play
                    System.out.println("Current player: computer.");
                    numberGuessed = ComputerPlays(randomNum, computerAttempts, guessesSoFar, numRange, numberGuessed);
                    if (numberGuessed == true) {
                        System.out.println("The computer won!");
                    }
//                    // Let computer guess
//                    computerGuess = random.nextInt(numRange[0], numRange[1] + 1);
//                    System.out.println("The computer's guess: " + computerGuess);
//                    guessesSoFar += computerGuess + ", ";
//                    System.out.println("Both players' guesses so far: " + guessesSoFar);
//                    // Check user's guess (returns true or false)
//                    numberGuessed = CheckPlayerGuess(computerGuess, randomNum, numberGuessed, numRange);
                }

            // If computer starts the round:
            } else if (startsFirst == 1) {
                System.out.println("Current player: computer.");
                // Let computer guess
                numberGuessed = ComputerPlays(randomNum, computerAttempts, guessesSoFar, numRange, numberGuessed);
                if (numberGuessed == true) {
                    System.out.println("The computer won!");
                }
//                computerGuess = random.nextInt(numRange[0], numRange[1] + 1);
//                System.out.println("The computer's guess: " + computerGuess);
//                guessesSoFar += computerGuess + ", ";
//                System.out.println("Both players' guesses so far: " + guessesSoFar);
//                // Check user's guess (returns true or false)
//                numberGuessed = CheckPlayerGuess(computerGuess, randomNum, numberGuessed, numRange);

                // If the computer guessed incorrectly, it's the user's turn:
                if (numberGuessed == false) {
                    // Let the user play
                    System.out.println("Current player: user.");
                    numberGuessed = UserPlays(randomNum, userAttempts, guessesSoFar, numRange, numberGuessed);
                    if (numberGuessed == true) {
                        System.out.println("Congratulations to the user! You won!");
                    }
//                    // let user guess (returns userGuess)
//                    userGuess = LetUserGuess(randomNum, userAttempts, guessesSoFar, numRange);
//                    guessesSoFar += userGuess + ", ";
//                    System.out.println("Both players' guesses so far: " + guessesSoFar);
//                    // Check user's guess (returns true or false)
//                    numberGuessed = CheckPlayerGuess(userGuess, randomNum, numberGuessed, numRange);
                }
            }
        }

        if (numberGuessed == true) {

        }

        // Is there a shorter version of this?
        int anotherRound;
        do {
            System.out.println("Would you like to play another round? Press 1 for yes and 0 for no.");
            anotherRound = scanner.nextInt();
        } while (anotherRound < 0 || anotherRound > 1);

        return anotherRound;
    }

    static int LetUserGuess(int randomNum, int userAttempts, String guessesSoFar, int[] numRange) {
        // Let user guess a number
        System.out.println("Please guess an integer between " + numRange[0] + " and " + numRange[1] + " .");
        // Ask user to guess random number in range
        // **** repeat guesses until user guesses correctly
        Scanner scanner = new Scanner(System.in);
        int userGuess = scanner.nextInt();
        while (userGuess < numRange[0] || userGuess > numRange[1]) {
            // New " after \n necessary?
            System.out.println("The number you entered is not within the given number range.\n" +
                    "Please try again and enter an integer between " + numRange[0] + " and " + numRange[1] + " .");
            userGuess = scanner.nextInt();
        }
        // User guesses out of numRange do not count towards userAttempts number
        userAttempts++;
        return userGuess;
    }

    static Boolean CheckPlayerGuess(int playerGuess, int randomNum, Boolean numberGuessed, int[] numRange) {
        if (playerGuess > randomNum) {
            System.out.println("The number you guessed is greater than the random number.");
            // numRange = [rangeStart, userGuess - 1]
            // Does this edit numRange in playRound? Should I put numRange in main()?
            ChangeNumRange(numRange, playerGuess - 1, 1);

        } else if (playerGuess < randomNum) {
            System.out.println("The number you guessed is smaller than the random number.");
            // numRange = [userGuess + 1, rangeEnd]
            // Does this edit numRange in playRound? Should I put numRange in main()?
            ChangeNumRange(numRange, playerGuess + 1, 0);
        }

        if (playerGuess == randomNum) {
            numberGuessed = true;
        }

        return numberGuessed;
    }

    static int[] ChangeNumRange(int[] numRange, int newRangeBorder, int indexToChange) {
        numRange[indexToChange] = newRangeBorder;
        return numRange;
    }

    static Boolean UserPlays(int randomNum, int userAttempts, String guessesSoFar, int[] numRange, Boolean numberGuessed) {
        int userGuess;
        System.out.println("Current player: user.");
        // let user guess (returns userGuess)
        userGuess = LetUserGuess(randomNum, userAttempts, guessesSoFar, numRange);
        guessesSoFar += userGuess + ", ";
        System.out.println("Both players' guesses so far: " + guessesSoFar);
        // Check user's guess (returns true or false)
        numberGuessed = CheckPlayerGuess(userGuess, randomNum, numberGuessed, numRange);
        return numberGuessed;
    }

    static Boolean ComputerPlays(int randomNum, int userAttempts, String guessesSoFar, int[] numRange, Boolean numberGuessed) {
        int computerGuess;
        // Let computer guess
        Random random = new Random();
        System.out.println("Please guess an integer between " + numRange[0] + " and " + numRange[1] + " .");
        computerGuess = random.nextInt(numRange[0], numRange[1] + 1);
        System.out.println("The computer's guess: " + computerGuess);
        guessesSoFar += computerGuess + ", ";
        System.out.println("Both players' guesses so far: " + guessesSoFar);
        // Check user's guess (returns true or false)
        numberGuessed = CheckPlayerGuess(computerGuess, randomNum, numberGuessed, numRange);
        return numberGuessed;
    }

//    static int playRound() {
//        int userGuess;
//        int computerGuess;
//        int userAttempts = 0;
//        int computerAttempts = 0;
//        String previousGuesses = "";
//
//        // Let user choose an integer range
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter an integer.");
//        int rangeStart = scanner.nextInt();
//        // OPTION: Let user enter two integers, sort them and add the to number range in ascending order
//        System.out.println("Please enter another integer, greater than the first one.");
//        int rangeEnd = scanner.nextInt();
//        while (rangeStart == rangeEnd) {
//            System.out.println("The second integer should be different from the first. Please try again and enter another integer.");
//            rangeEnd = scanner.nextInt();
//        }
//
//        while (rangeStart > rangeEnd) {
//            System.out.println("The second integer should be greater than the first. Please try again and enter another integer.");
//            rangeEnd = scanner.nextInt();
//        }
//
//        int numRange[] = { rangeStart, rangeEnd };
//
//        // Create random number within numRange
//        Random random = new Random();
//        // Does this create a random number within numRange?
//        int randomNum = random.nextInt(rangeStart, rangeEnd + 1);
//        System.out.println("A random integer between " + rangeStart + " " + rangeEnd + " has been generated. Time to play!");
//        // What do I need this for?
//        int anotherRound = 0;
//
//        // Decide who will start playing
//        // Does this create only 0 and 1?
//        // Are there easier ways to create either a true or false/ 1 or 0?
//        int startsFirst = random.nextInt(0, 2);
//        System.out.println("startsFirst: " + startsFirst);
//        if (startsFirst == 0) {
//            // user starts playing // extract into method userAttempts() later
//            System.out.println("User: Your turn. Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");
//            // Ask user to guess random number in range
//            // **** repeat guesses until user guesses correctly
//            userGuess = scanner.nextInt();
//            while (userGuess < rangeStart || userGuess > rangeEnd) {
//                // New " after \n necessary?
//                System.out.println("The number you entered is not within the given number range.\n" +
//                        "Please try again and enter an integer between " + rangeStart + " and " + rangeEnd + " .");
//                userGuess = scanner.nextInt();
//            }
//            // User guesses out of numRange do not count towards userAttempts number
//            userAttempts++;
//
//
//
//            while (userGuess != randomNum && userAttempts <= 9) {
//                previousGuesses = checkUserGuess(userGuess, randomNum, previousGuesses, numRange);
//                System.out.println("Try again and guess an integer between " + rangeStart + " and " + rangeEnd + ".");
//                userGuess = scanner.nextInt();
//                userAttempts++;
//            }
//
//        } else if (startsFirst == 1) {
//            // computer starts playing
//        }
//
//
//
//        if (guesses > 9) {
//            System.out.println("You have guessed too many times. Game over.");
//        }
//
//        if (numGuess == randomNum) {
//            previousGuesses += "" + numGuess + ", ";
//            System.out.println("Your guesses so far: " + previousGuesses);
//            System.out.println("You guessed the number correctly! Well done!");
//            System.out.println("Would you like to play another round? Press 1 for yes and 0 for no.");
//            anotherRound = scanner.nextInt();
//        }
//
//        return anotherRound;
//    }
//
//
//
//    static String checkUserGuess(int userGuess, int randomNum, String previousGuesses, int[] numRange) {
//        if (userGuess > randomNum) {
//            System.out.println("The number you guessed is greater than the random number.");
//            // changenumRange()
//        } else if (userGuess < randomNum) {
//            System.out.println("The number you guessed is smaller than the random number.");
//            // changenumRange()
//        }
//
//        previousGuesses += "" + userGuess + ", ";
//        System.out.println("Your guesses so far: " + previousGuesses);
//        return previousGuesses;
//        // return numRange
////        System.out.println("Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");
////        numGuess = scanner.nextInt();
//    }
//
//    static String checkComputerGuess(int computerGuess, int randomNum, String previousGuesses, int[] numRange) {
//        if (computerGuess > randomNum) {
//            System.out.println("The number you guessed is greater than the random number.");
//        } else if (computerGuess < randomNum) {
//            System.out.println("The number you guessed is smaller than the random number.");
//        }
//
//        previousGuesses += "" + computerGuess + ", ";
//        System.out.println("Your guesses so far: " + previousGuesses);
//        return previousGuesses;
//        // return numRange
//    }

//    static int[] changenumRange(int[] numRange) {
//        // numRange = [a, userGuess - 1] OR
//        // numRange = [userGuess + 1, b]
//    }
}


/*
TRACE

user
computer
* computerAttempts = 0
* guessesSoFar = "11, 1, 21"
userAttempts = 2
computerAttempts = 1
numberGuessed = true
randomNum = 20
userGuess = 21
computerGuess = 20
numRange = [15, 20]

a = 10
b = 50
startsFirst = 0
anotherRound = 1

=====

EDGE CASES

 */
