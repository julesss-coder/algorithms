import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        while (playRound() == 1) {
            playRound();
        }
    }

    static int playRound() {
        // Let user choose a number range
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

        String previousGuesses = "";
        // Only allow 9 guesses
        int guesses = 0;
        // Create random number within given range
        Random random = new Random();
        int randomNum = random.nextInt(rangeStart, rangeEnd + 1);
        int numGuess;
        int anotherRound = 0;

        // Ask user to guess random number in range
        // **** repeat guesses until user guesses correctly
        System.out.println("Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");
        numGuess = scanner.nextInt();
        guesses++;
        while (numGuess < rangeStart || numGuess > rangeEnd) {
            System.out.println("Please try again. Enter an integer between " + rangeStart + " and " + rangeEnd + " .");
            numGuess = scanner.nextInt();
        }

        while (numGuess != randomNum && guesses <= 9) {
            previousGuesses = checkUserGuess(numGuess, randomNum, previousGuesses);
            System.out.println("Try again and guess an integer between " + rangeStart + " and " + rangeEnd + ".");
            numGuess = scanner.nextInt();
            guesses++;
        }

        if (guesses > 9) {
            System.out.println("You have guesses too many times. Game over.");
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

    static String checkUserGuess(int numGuess, int randomNum, String previousGuesses) {
        if (numGuess > randomNum) {
            System.out.println("The number you guessed is greater than the random number.");
        } else if (numGuess < randomNum) {
            System.out.println("The number you guessed is smaller than the random number.");
        }

        if (numGuess >= randomNum - 5 && numGuess <= randomNum + 5) {
            System.out.println("You are very close!");
        } else if (numGuess >= randomNum - 15 && numGuess <= randomNum + 15) {
            System.out.println("You are relatively close.");
        } else if (numGuess >= randomNum - 25 && numGuess <= randomNum + 25) {
            System.out.println("You are not very close.");
        } else {
            System.out.println("You are way off!");
        }

        previousGuesses += "" + numGuess + ", ";
        System.out.println("Your guesses so far: " + previousGuesses);
        return previousGuesses;
//        System.out.println("Please guess an integer between " + rangeStart + " and " + rangeEnd + " .");
//        numGuess = scanner.nextInt();
    }
}
