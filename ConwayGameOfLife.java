/*
Checking for live/dead cells is unnecessary
 */

/*
STRATEGY 1

field size: 3 x 3
    // later: let user choose

cells with x: user pattern as given at https://playgameoflife.com/info
    // later: create randomly

number of generations: 10
    // later:
        let user choose
        if user cancels:
            end game

field = [
    [., X, .],
    [., ., X],
    [X, X, X]
]

// newField = copy of field
newFieldy = [
    [., X, .],
    [., ., X],
    [X, X, X]
]
// Check field itself
For each subarray in field:
    For each cell in subarray:
        If cell is empty:
            // Check 8 surrounding cells: // Extract in method checkNeighbours
            If cell has three neighbours:
                Make cell an X
        Else if cell is an X:
            // Check 8 surrounding cells (checkNeighbours())
            If neighbours <= 1 || neighbours >= 4:
                Make cell a `.`
            Else if neighbours === 2 || neighbours === 3:
                Leave cell as it is

// Method checkNeighbours(subarrayIndex, cellIndex):
neighbours = 0
For each subarray from i - 1 to i + 1:
    If subarray !== undefined:
        For each cell, except current cell:
            If cell !== undefined:
                If cell === X
                    neighbours++
Return neighbours


// =========== TO DO ============
// Check if empty cells outside field will be filled:
For each cell in top row:
    numberOfX = 0
    If cell === X:
        numberOfX++
        If numberOfX === 3:
            // Time to add an extra row, addExtraRow(index before top row)
            If no extra row has been added:
                Add an extra subarray of empty cells (.) before current row (length is the same as the others)
            Set cell at position cell index - 1 to X
            numberOfX = 2 // Continuing to count Xs after the sequence of 3 Xs we just found
    Else if cell is empty:
        numberOfX = 0

For each cell in bottom row:
    addExtraRow(index after bottom row): same as above, but add extra row below current one

For each cell in left column:
    addExtra Cell(index before first cell): same as above, but add extra column before current one

For each cell in right column:
    addExtraCell(index after last cell): same as above, but add extra column after current one

==================================================

IDEAS
Turn into website (Vanilla JS or React)

 */

/*
BUGS:
UNSOLVED:
- [ ] When debugging the code from the second row, the first row in `field` has been changed to [., ., .]. These
      changes should have been made in `newField`, not in the original field. I.e. using an incorrect reference point.
      PROBLEM:  Changing newField changes field, too. Using clone() to make a copy
      of field created a copy with reference, but I need a copy of the values only.
      TEMPORARY SOLUTION: Create newField separately, exactly like field.

---
Use 1 and 0 instead of chars?

Clean solution: https://www.youtube.com/watch?v=YZ-W5DrKPQ0 , but not in-place
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ConwayGameOfLifeV1 {
    public static void main(String[] args) {
        // Create nested ArrayList
        int[][] arr = new int[10][10];



        ArrayList<ArrayList<Character>> field = new ArrayList<ArrayList<Character>>();
        // Add three rows
        field.add(new ArrayList<Character>(Arrays.asList('.', '#', '.')));
        field.add(new ArrayList<Character>(Arrays.asList('.', '.', '#')));
        field.add(new ArrayList<Character>(Arrays.asList('#', '#', '#')));

//        field.add(new ArrayList<Character>(Arrays.asList('#', '.', '#')));
//        field.add(new ArrayList<Character>(Arrays.asList('.', '#', '#')));
//        field.add(new ArrayList<Character>(Arrays.asList('.', '#', '.')));

//        for (int i = 0; i < field.size(); i++) {
//            System.out.println(field.get(i));
//        }

        ArrayList<Integer> a = new ArrayList<>();

        Integer.parseInt("3");

        ArrayList<ArrayList<Character>> field2 = new ArrayList<>(field);
        field2.get(0).set(0, 'D');
        System.out.println("field");
        for (int i = 0; i < field.size(); i++) {
            System.out.println(field.get(i));
        }
        System.out.println("field2");
        for (int i = 0; i < field2.size(); i++) {
            System.out.println(field2.get(i));
        }


        // Create copy of field === WHAT IS THE BEST WAY TO DO THIS? ===
        // clone() creates a copy with reference, but I need a copy of the values only
        // Use original field to check if cells are populated
        // Use new field to make changes to cells and create next generation of cells
        ArrayList<ArrayList<Character>> newField = new ArrayList<ArrayList<Character>>();
        // Add three rows
        newField.add(new ArrayList<Character>(Arrays.asList('.', '#', '.')));
        newField.add(new ArrayList<Character>(Arrays.asList('.', '.', '#')));
        newField.add(new ArrayList<Character>(Arrays.asList('#', '#', '#')));

        for (int i = 0; i < newField.size(); i++) {
            System.out.println(field.get(i));
        }

        // Check field itself (not the spaces outside)
        // For each subarray in original field:
        for (int i = 0; i < field.size(); i++) {
            // For each cell in subarray:
            ArrayList<Character> row = field.get(i);
            int neighbours = 0;
            for (int j = 0; j < row.size(); j++) {
                // If cell is empty:
                if (row.get(j) == '.') {
                    // Check 8 surrounding cells:
                    neighbours = checkNeighbouringRows(field, i, j);
                    System.out.println("Coordinates of cell I am checking for neighbours: " + i + " " + j);
                    System.out.println("Number of neighbours of current cell: " + neighbours);
                    // If this empty cell has three neighbours:
                    if (neighbours == 3) {
                        // Make cell an #
                        newField.get(i).set(j, '#');
                        System.out.println("Setting cell: " + i + " " + j + " to " + " #");
                    }
                    // Else if cell is populated:
                } else if (row.get(j) == '#') {
                    // Check 8 surrounding cells
                    neighbours = checkNeighbouringRows(field, i, j);
                    System.out.println("Coordinates of cell I am checking for neighbours: " + i + " " + j);
                    System.out.println("Number of neighbours of current cell: " + neighbours);
                    if (neighbours <= 1 || neighbours >= 4) {
                        newField.get(i).set(j, '.');
                        System.out.println("Setting cell: " + i + " " + j + " to " + " .");
                    }
                    // If neighbours === 2 || neighbours === 3: Leave cell as it is
                }
            }
            System.out.println("Field: " + field + " newField: " + newField);
        }

        System.out.println("New field, before having checked the cells outside the field: ");
        for (int i = 0; i < newField.size(); i++) {
            System.out.println(newField.get(i));
        }

        // Check if any of the cells surrounding `field` has 3 neighbours and therefore will be populated
        // Check top row:
        ArrayList<Character> topRow = field.get(0);
        for (int i = 0; i < topRow.size(); i++) {
            int populatedCells = 0;
            char cell = topRow.get(i);
            if (cell == '#') {
                populatedCells++;
                if (populatedCells == 3) {
                    // Time to add an extra row, addExtraRow(index before top row)
                    System.out.println("Add extra row before top row");
                    // HOW DO I ADD AN EXTRA ARRAYLIST BEFORE THE FIRST ARRAYLIST? COULD NOT FIND A METHOD TO DO THIS!
                    // NOT POSSIBLE TO ADD IT AT INDEX -1
                    // ADD ROW IN THE END AND SHIFT ALL VALUES TO THE NEXT ARRAY??
                    newField.add(-1, new ArrayList<Character>(Arrays.asList('.', '.', '.')));
                }
            }
        }
    }

    // Does this method need to be static?
    public static int checkNeighbouringRows(ArrayList<ArrayList<Character>> originalField, int rowIndex, int cellIndex) {
        int neighbours = 0;
        int rowBeginIndex, rowEndIndex;
        // If current cell is in first row, check only current and next row
        if (rowIndex == 0) {
            rowBeginIndex = 0;
            rowEndIndex = 1;
            neighbours = checkNeighbouringCells(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
            // Else if current cell is in last row, check only previous and last row
        } else if (rowIndex == originalField.get(rowIndex).size() - 1) {
            rowBeginIndex = originalField.get(rowIndex).size() - 2;
            rowEndIndex = originalField.get(rowIndex).size() - 1;
            neighbours = checkNeighbouringCells(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
            // Else, check previous, current and next row
        } else {
            rowBeginIndex = rowIndex - 1;
            rowEndIndex = rowIndex + 1;
            neighbours = checkNeighbouringCells(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
        }
        return neighbours;
    }

    // Does this method need to be static?
    public static int checkNeighbouringCells(ArrayList<ArrayList<Character>> originalField, int rowBeginIndex, int rowEndIndex, int rowIndex, int cellIndex) {
        int neighbours = 0;
        int cellBeginIndex, cellEndIndex;
        for (int i = rowBeginIndex; i <= rowEndIndex ; i++) {
            ArrayList<Character> row = originalField.get(i);
            // If current cell is the first in its row, check only current and next cell:
            if (cellIndex == 0) {
                cellBeginIndex = 0;
                cellEndIndex = 1;
                // call checkCells
                neighbours = countNeighbours(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
                // Else if current cell is the last in its row, check only the previous and the last cell:
            } else if (cellIndex == originalField.get(rowIndex).size() - 1) {
                cellBeginIndex = originalField.get(rowIndex).size() - 2;
                cellEndIndex = originalField.get(rowIndex).size() - 1;
                neighbours = countNeighbours(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
                // Else, check the previous, current and next cell:
            } else {
                cellBeginIndex = cellIndex - 1;
                cellEndIndex = cellIndex + 1 ;
                neighbours = countNeighbours(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
            }
        }

        return neighbours;
    }

    // Does this method need to be static?
    public static int countNeighbours(ArrayList<Character> row, int cellBeginIndex, int cellEndIndex, int rowIndex, int cellIndex, int currentRowIndex, int neighbours) {
        // Go through each cell:
        for (int j = cellBeginIndex; j <= cellEndIndex; j++) {
            if (row.get(j) == '#') {
                // Skip current cell when looking for '#'
                if (!(currentRowIndex == rowIndex && j == cellIndex)) {
                    neighbours++;
                }
            }
        }
        return neighbours;
    }

    // Which rows and cells to check depends on the location of the cell whose neigbours we are checking:
    // i.e. beginIndex and endIndex differ from case to case
        /*
            Extract check for rows and cells into two separate methods
            ROWS checkRow(field, rowIndex)
            if rowIndex === 0 (first row):
                beginIndex = rowIndex, endIndex = rowIndex + 1
                only check rows i and i + 1
            else if last row: i === field.size() - 1:
                only check rows i - 1 and i
            else if other row: i > 0 && i < field.size() - 1:
                check rows i - 1, i, i + 1

            CELLS checkCell(row, cellIndex, beginIndex, endIndex)
            if first cell: j === 0:
                beginIndex = j, endIndex = j + 1
                // do actual check
            else if last cell: j === row.size() - 1:
                only check cells j - 1, j
            else if other cells: j > 0 && j < row.size() - 1:
                check cells j - 1, j, j + 1

        */
    // Count populated cells (#) among current cell's neighbours:
    // Go through each row
    // pass in rowBeginIndex for i, rowEndIndex for i <=
    // pass in cellBeginIndex for j, cellEndIndex for j <=
//        for (int i = |rowIndex - 1|; i <= |rowIndex + 1| ; i++) {
//            ArrayList<Character> row = field.get(i);
//            // Go through each cell:
//            for (int j = 0; j < row.size(); j++) {
//                if (row.get(j) == '#') {
//                    // Skip current cell when looking for '#'
//                    if (i != rowIndex && j != cellIndex) {
//                        neighbours++;
//                    }
//                }
//            }
//        }


}
