/*
TODO
- [ ] Add option for user to cancel game (i.e. game runs indefinitely, until user cancels) - does that make sense?
- [ ] Check if number entered by user is integer.

BUGS
- [ ] numberOfLiveCells does not correspond to the actual number of 1s in generated field

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ConwayGameOfLifeV2 {
    public static void main(String[] args) {
        int[] fieldSize = letUserChooseFieldSize();
        int fieldLength = fieldSize[0];
        int fieldWidth = fieldSize[1];

        // Set number of live cells to random number
        Random random = new Random();
        int numberOfLiveCells = random.nextInt(0, (int) (fieldLength * fieldWidth) / 2);
        System.out.println("numberOfLiveCells: " + numberOfLiveCells);

        int[][] field = initializeArray(fieldLength, fieldWidth, numberOfLiveCells);

        // Let user choose number of generations (rounds) to play game
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of generations you would like to play Game of Life (integers only).");
        int generations = scanner.nextInt();
        System.out.println("Number of generations: " + generations);

        // Play game `generations` times:
        int counter = 0;
        while (counter < generations) {
            int[][] nextGeneration = createNextGeneration(field, fieldLength, fieldWidth);
            System.out.println("nextgeneration: ");
            for (int i = 0; i < nextGeneration.length; i++) {
                System.out.println(Arrays.toString(nextGeneration[i]));
            }
            field = nextGeneration;
            counter++;
        }
        System.out.println("Game ends.");
    }

    public static int[][] initializeArray(int fieldLength, int fieldWidth, int numberOfLiveCells) {
        int[][] field = new int[fieldLength][fieldWidth];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }

        field = randomlyMarkCellsLive(field, numberOfLiveCells);

        for (int i = 0; i < field.length; i++) {
            System.out.println(Arrays.toString(field[i]));
        }
        return field;
    }

    public static int[][] createNextGeneration(int[][] field, int fieldLength, int fieldWidth) {
        // Make a copy of field, without references
        int[][] newField = new int[fieldLength][fieldWidth];
        for (int i = 0; i < field.length; i++) {
            // Make a deep copy of each int array
            newField[i] = Arrays.copyOf(field[i], field[i].length);
        }
        // Now, `newField` can be changed without `field` changing - tested. (Arrays.copyOf() only seems to work with primitive types.)
        System.out.println("newField: " + Arrays.deepToString(newField));

        // Check 8 surrounding cells and count live neighbours
        for (int i = 0; i < field.length; i++) {
            int[] row = field[i];
            for (int j = 0; j < row.length ; j++) {
                int liveNeighbours = countLiveNeighbours(field, i, j);
                if (liveNeighbours == 0 || liveNeighbours == 1 || liveNeighbours >= 4) {
                    newField[i][j] = 0;
                } else if (liveNeighbours == 3) {
                    newField[i][j] = 1;
                }
            }
        }

        return newField;
    }

    public static int countLiveNeighbours(int[][] field, int rowIndex, int cellIndex) {
        int liveNeighbours = 0;
        for (int i = rowIndex - 1; i <= rowIndex + 1; i++) {
            // Check that you stay within the existing rows
            if (i >= 0 && i < field.length) {
                for (int j = cellIndex - 1; j <= cellIndex + 1 ; j++) {
                    // Check that you stay within the existing columns
                    if (j >= 0 && j < field[i].length) {
                        // Skip current cell whose neighbours you are checking
                        if (!(i == rowIndex && j == cellIndex)) {
                            if (field[i][j] == 1) {
                                liveNeighbours++;
                            }
                        }
                    }
                }
            }
        }

        return liveNeighbours;
    }

    public static int[] letUserChooseFieldSize() {
        Scanner scanner = new Scanner(System.in);
        int fieldLength, fieldWidth;

        System.out.println("Please choose the field length (integers only).");
        fieldLength = scanner.nextInt();

        System.out.println("Please choose the field width (integers only).");
        fieldWidth = scanner.nextInt();

        int[] fieldSize = {fieldLength, fieldWidth};
        return fieldSize;
    }

    // rewrite method so that while loop works, and there is only one return statement
    public static int[][] randomlyMarkCellsLive(int[][] field, int numberOfLiveCells) {
        int cellCounter = 0;
        for (int j = 0; j < field.length; j++) {
            for (int k = 0; k < field[j].length; k++) {
                Random random = new Random();
                double randomNum = random.nextDouble(0, 1);
                if (randomNum > 0.3) {
                    field[j][k] = 1;
                    cellCounter++;
                    if (cellCounter == numberOfLiveCells) {
                        return field;
                    }
                }
            }
        }
        return field;
    }
}
