/*
* TODOS
* - [x] rename variables
* - [x] create methods
* changing an array or object in a method changes it globally, as it is passed by reference
* This does not apply to primitive values
* - [x] Add "game over" when a user exceeds 9 guesses
*
* QUESTIONS:
*   - Variables that need to be global:
*       - userAttempts
*       - computerAttempts
*   - Variables that could be global, but are currently local
*       - arrayList guessesSoFar
*       - int[] numRange
*   - When declaring global variables, do I have to pass them into the method that changes them?
*     Or can I just change them directly via ClassName.variableName?
*     It seems that I don't have to access them with ClassName.variableName - why not?
*
* BUGS:
* --- SOLVED ---
*  - String guessesSoFar is reset every time a player makes a guess.
*       => Add each guess to arrayList guessesSOFar and print them after each guess. Pass them into the methods to change them.
* SOLUTION: Used arrayList instead of String, add new guesses to it and print it after every guess
*  userAttempts seems to be reset on every call of one of the methods
*       SOLUTION: Made userAttempts and computerAttempts global variables.
* --------

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

// Methoden kleinschreiben
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberAdvanced {
    public static int userAttempts = 0;
    public static int computerAttempts = 0;
    public static Boolean numberGuessed = false;

    public static void main(String[] args) {
        // Check this
        while (playRound() == 1) {
            playRound();
        }

    }

    static int playRound() {
        int userGuess;
        int computerGuess;
        ArrayList <Integer> guessesSoFar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Generate an integer range
        System.out.println("Let's create an integer range! Enter the first integer.");
        int rangeStart = scanner.nextInt();
        System.out.println("Enter another integer that is different from the first.");
        int rangeEnd = scanner.nextInt();
        while (rangeStart >= rangeEnd) {
            System.out.println("The second integer needs to be greater than the first one.\nPlease try again and enter another integer.");
            rangeEnd = scanner.nextInt();
        }
        System.out.println("The two integers entered by the user: " + rangeStart + " and " + rangeEnd);
        int[] numRange = {rangeStart, rangeEnd};

        // Create random number within numRange
        Random random = new Random();
        // Formula: random.nextInt(max - min + 1) + min
        int randomNum = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
        System.out.println("Random number: " + randomNum);
        System.out.println("A random integer between " + rangeStart + " and " + rangeEnd + " has been generated.");

        // Decide who will start playing
        // Randomly create either 0 or 1:
        int startsFirst = random.nextInt(2);

        while (!numberGuessed) {
            // If user starts the round:
            if (startsFirst == 0) {
                if (GuessNumberAdvanced.userAttempts < 9) {
                    // --- Extract into method UserPlays() --- // returns Boolean numberGuessed
                    numberGuessed = userPlays(randomNum, guessesSoFar, numRange);
                    if (numberGuessed) {
                        System.out.println("Congratulations to the user! You won!");
                    }
                } else {
                    System.out.println("You have had 9 attempts. Game over.");
                }

                if (GuessNumberAdvanced.computerAttempts < 9) {
                    // If the user guessed incorrectly, it's the computer's turn:
                    if (numberGuessed == false) {
                        // Let computer play
                        numberGuessed = computerPlays(randomNum, guessesSoFar, numRange);
                        System.out.println("computer attempts: " + computerAttempts);
                        if (numberGuessed == true) {
                            System.out.println("The computer won!");
                        }
                    }
                } else {
                    System.out.println("The computer has had 9 attempts. Game over for the computer.");
                }

                // If computer starts the round:
            } else if (startsFirst == 1) {
                if (GuessNumberAdvanced.computerAttempts < 9) {
                    // Let computer guess
                    numberGuessed = computerPlays(randomNum, guessesSoFar, numRange);
                    if (numberGuessed == true) {
                        System.out.println("The computer won!");
                    }
                } else {
                    System.out.println("The computer has had 9 attempts. Game over for the computer.");
                }

                if (GuessNumberAdvanced.userAttempts < 9) {
                    // If the computer guessed incorrectly, it's the user's turn:
                    if (numberGuessed == false) {
                        // Let the user play
                        numberGuessed = userPlays(randomNum, guessesSoFar, numRange);
                        if (numberGuessed == true) {
                            System.out.println("Congratulations to the user! You won!");
                        }
                    }
                } else {
                    System.out.println("You have had 9 attempts. Game over.");
                }
            }
        }

        // Is there a shorter version of this?
        int anotherRound;
        do {
            System.out.println("Would you like to play another round? Press 1 for yes and 0 for no.");
            anotherRound = scanner.nextInt();
        } while (anotherRound < 0 || anotherRound > 1);

        return anotherRound;
    }

    static int letUserGuess(int randomNum, ArrayList<Integer> guessesSoFar, int[] numRange) {
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
        GuessNumberAdvanced.userAttempts++;
        System.out.println("user attempts: " + userAttempts);
        return userGuess;
    }

    static boolean checkPlayerGuess(int playerGuess, int randomNum, int[] numRange) {
        if (playerGuess > randomNum) {
            System.out.println("The number you guessed is greater than the random number.");
            // numRange = [rangeStart, userGuess - 1]
            // Does this edit numRange in playRound? Should I put numRange in main()?
            //ChangeNumRange(numRange, playerGuess - 1, 1);
            numRange[1] = playerGuess - 1;

        } else if (playerGuess < randomNum) {
            System.out.println("The number you guessed is smaller than the random number.");
            // numRange = [userGuess + 1, rangeEnd]
            // Does this edit numRange in playRound? Should I put numRange in main()?
            //ChangeNumRange(numRange, playerGuess + 1, 0);
            numRange[0] = playerGuess + 1;
        }

        if (playerGuess == randomNum) {
            numberGuessed = true;
        }

        return numberGuessed;
    }

    /*static int[] ChangeNumRange(int[] numRange, int newRangeBorder, int indexToChange) {
        numRange[indexToChange] = newRangeBorder;
        return numRange;
    }*/

    static boolean userPlays(int randomNum, ArrayList<Integer> guessesSoFar, int[] numRange) {
        int userGuess;
        System.out.println("=================\nCurrent player: user.\n=================");
        // let user guess (returns userGuess)
        userGuess = letUserGuess(randomNum, guessesSoFar, numRange);
        guessesSoFar.add(userGuess);
        System.out.println("Both players' guesses so far: " + guessesSoFar);
        // Check user's guess (returns true or false)
        numberGuessed = checkPlayerGuess(userGuess, randomNum, numRange);
        return numberGuessed;
    }

    static boolean computerPlays(int randomNum, ArrayList<Integer> guessesSoFar, int[] numRange) {
        int computerGuess;
        System.out.println("=================\nCurrent player: computer.\n=================");
        // Let computer guess
        Random random = new Random();
        System.out.println("Please guess an integer between " + numRange[0] + " and " + numRange[1] + " .");
        computerGuess = random.nextInt(numRange[0], numRange[1] + 1);
        GuessNumberAdvanced.computerAttempts++;
        // Do I have to address computerAttempts by adding the className before?
        System.out.println("computer attempts: " + computerAttempts);
        System.out.println("The computer's guess: " + computerGuess);
        guessesSoFar.add(computerGuess);
        System.out.println("Both players' guesses so far: " + guessesSoFar);
        // Check user's guess (returns true or false)
        numberGuessed = checkPlayerGuess(computerGuess, randomNum, numRange);
        return numberGuessed;
    }

}
