/*
InitializeArray(array
    Set int array size to 10 x 10
        // later: let user choose array size
    Set array to
    010
    001
    111
    (live cells spread across 3 x 3 array, starting in top left corner)

        // Later:
            number of live cells: create random number
            start in top left corner, array size: (number of live cells / 2) x (number of live cells / 2)

    generations = 5
        // Later: generations = Let user choose number of generations
        // Or end game if user cancels

    Print array

for the given number of generations:
nextGeneration = createNextGeneration(field)

5 times:
    field =
    nextGeneration = createNextGeneration(field)
    Print nextGeneration
    array = nextGeneration // how to pass in the correct array to the next generation?



createNextGeneration(array):
    newField: Make copy of array (values, no references)
    For each row in array (the whole array, not just the 3 x 3 portion that holds the live cells:
        For each cell in row:
            Check 8 surrounding cells and count live neighbours
            // liveNeighbours = countLiveNeighbours()
            If cell has 0 || 1 || >= 4 live neighbours:
                Set cell in newField to 0
            Else if cell has 3 live neighbours:
                Set cell in newField to 1
            Else:
                Leave cell in newField as it is

    Return newField

countLiveNeighbours(array, rowIndex, cellIndex)
    For each row in array, from rowIndex - 1 to rowIndex + 1:
        // Check that you are not stepping outside the array
        if current index > 0 && current index < array.length:
                For each cell in row, from cellIndex - 1 to cellIndex + 1:
                    // Check that you are not stepping outside the array
                    if rowIndex !== row index of current cell && if current index > 0 && current index < row.length:
                        If cellIndex !== cell index of current cell:
                            if cell == 1:
                                liveNeighbours++

    Return liveNeighbours



 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ConwayGameOfLifeV2 {
    public static void main(String[] args) {
        int[] fieldSize = letUserChooseFieldSize();
        int fieldLength = fieldSize[0];
        int fieldWidth = fieldSize[1];

        // Randomly choose number of live cells
        Random random = new Random();
        int numberOfLiveCells = random.nextInt(0, (int) (fieldLength * fieldWidth) / 4);
        System.out.println("numberOfLiveCells: " + numberOfLiveCells);

        int[][] field = initializeArray(fieldLength, fieldWidth, numberOfLiveCells);

        // Let user choose number of generations
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of generations you would like to play Game of Life (integers only).");
        int generations = scanner.nextInt();
        System.out.println("Number of generations: " + generations);

        // Play Game of Life `generations` times:
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

        // === TODO: randomly spread `numberOfLiveCells` live cells throughout field ===
        /*
        numberOfLiveCells times:
            for each cell starting from starting cell (fieldLength - (int) sqrrt(numberOfCells) / 2
                create double
                if double > 0.3:
                    make cell a 1


         */


        // === OPTIONAL: only spread them within certain part of array ===
        // Live cells and their positions
//        int[][] cellNumbers = {
//                {0, 1, 0},
//                {1, 1, 1},
//                {0, 1, 0}
//        };
//
//        // Fill in live cells into field
//        for (int i = 0; i < cellNumbers.length; i++) {
//            for (int j = 0; j < cellNumbers[i].length; j++) {
//                // Position the live cells in cellNumbers in the center of the array, so there is as much space for them to grow as possible
//                int startingRow = (int) Math.floor((fieldLength - cellNumbers[0].length) / 2);
//                int startingColumn = (int) Math.floor((fieldWidth - cellNumbers.length) / 2);
//                field[startingRow + i][startingColumn + j] = cellNumbers[i][j];
//            }
//        }

//        System.out.println(Arrays.deepToString(field));
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
        // Now, newField can be changed without field changing - tested. (Arrays.copyOf() only seems to work with primitive types.)
        System.out.println("newField: " + Arrays.deepToString(newField));

        // Count live neighbours and change newField accordingly
        for (int i = 0; i < field.length; i++) {
            int[] row = field[i];
            for (int j = 0; j < row.length ; j++) {
                // Check 8 surrounding cells and count live neighbours
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
            // Check that you are not stepping outside the array
            if (i >= 0 && i < field.length) {
                for (int j = cellIndex - 1; j <= cellIndex + 1 ; j++) {
                    // Check that you are not stepping outside the array
                    if (j >= 0 && j < field[i].length) {
                        // Skip the cell whose neighbours we are checking for live cells
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
        System.out.println("Please choose the field length (integers only).");
        int fieldLength = scanner.nextInt();
        System.out.println("Please choose the field width (integers only).");
        int fieldWidth = scanner.nextInt();
        int[] fieldSize = {fieldLength, fieldWidth};
        return fieldSize;
    }

    public static int[][] randomlyMarkCellsLive(int[][] field, int numberOfLiveCells) {
        int i = 0;
        while (i < numberOfLiveCells) {
            for (int j = 0; j < field.length; j++) {
                for (int k = 0; k < field[j].length; k++) {
                    Random random = new Random();
                    double randomNum = random.nextDouble(0, 1);
                    if (randomNum > 0.3) {
                        field[j][k] = 1;
                        i++;
                    }
                }
            }
        }
        return field;
    }
}
