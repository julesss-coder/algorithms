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
// Check if empty cells outside arrayField will be filled:
For each cell in top row:
    numberOfX = 0
    If cell === X:
        numberOfX++
        If numberOfX === 3:
            // Time to add an extra row:
            If no extra row has been added:
                Add an extra subarray of empty cells (.) before current row (length is the same as the others)
            Set cell at position cell index - 1 to X
            numberOfX = 2 // Continuing to count Xs after the sequence of 3 Xs we just found
    Else if cell is empty:
        numberOfX = 0

For each cell in bottom row:
    same as above, but add extra row below current one

For each cell in left column:
    same as above, but add extra column before current one

For each cell in right column:
    same as above, but add extra column after current one

==================================================

IDEAS
Turn into website (Vanilla JS or React)

 */

/*
BUGS:
UNSOLVED:
- [ ] When debugging the code from the second row, the first row in `field` has been changed to [., ., .]. These
      changes should have been made in `newField`, not in the original field. I.e. using an incorrect reference point.
- [ ] First cell in second row does not get changed to #. Possible reason: Am I not adding up the neighbours of ONE cell?
      Am I resetting the number of neighbours with (some/each)function call(s)?
 */

import java.util.ArrayList;
import java.util.Arrays;

public class ConwayGameOfLife {
    public static void main(String[] args) {
        // Create nested ArrayList
        ArrayList<ArrayList<Character>> field = new ArrayList<ArrayList<Character>>();
        // Add three rows
        field.add(new ArrayList<Character>(Arrays.asList('.', '#', '.')));
        field.add(new ArrayList<Character>(Arrays.asList('.', '.', '#')));
        field.add(new ArrayList<Character>(Arrays.asList('#', '#', '#')));

        for (int i = 0; i < field.size(); i++) {
            System.out.println(field.get(i));
        }

        // Create copy of field
        // Use original field to check if cells are populated
        // Use new field to make changes to cells and create next generation of cells
        ArrayList<ArrayList<Character>> newField = (ArrayList)field.clone();
        for (int i = 0; i < newField.size(); i++) {
            System.out.println(field.get(i));
        }

        // Check field itself (not the spaces outside)
//        For each subarray in original field:
        for (int i = 0; i < field.size(); i++) {
//          For each cell in subarray:
            ArrayList<Character> row = field.get(i);
            int neighbours = 0;
            for (int j = 0; j < row.size(); j++) {
//              If cell is empty:
                if (row.get(j) == '.') {
//                  // Check 8 surrounding cells:
                    neighbours = checkNeighbours(field, i, j);
                    System.out.println("Coordinates of cell I am checking for neighbours: " + i + " " + j);
                    System.out.println("Number of neighbours of current cell: " + neighbours);
//                  If this empty cell has three neighbours:
                    if (neighbours == 3) {
//                      Make cell an #
                        newField.get(i).set(j, '#');
                    }
//              Else if cell is an #:
                } else if (row.get(j) == '#') {
//                  // Check 8 surrounding cells
                    neighbours = checkNeighbours(field, i, j);
                    System.out.println("Coordinates of cell I am checking for neighbours: " + i + " " + j);
                    System.out.println("Number of neighbours of current cell: " + neighbours);
                    if (neighbours <= 1 || neighbours >= 4) {
                        newField.get(i).set(j, '.');
                    }
//                  If neighbours === 2 || neighbours === 3: Leave cell as it is
                }
            }
        }

        System.out.println("New field, before having checked the cells outside the field: ");
        for (int i = 0; i < newField.size(); i++) {
            System.out.println(newField.get(i));
        }
    }

    // Does this method need to be static?
    public static int checkNeighbours(ArrayList<ArrayList<Character>> originalField, int rowIndex, int cellIndex) {
        int neighbours = 0;
        int rowBeginIndex, rowEndIndex;
        // If current cell is in first row, check only current and next row
        if (rowIndex == 0) {
            rowBeginIndex = 0;
            rowEndIndex = 1;
            neighbours = countNeighbours(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
            // Else if current cell is in last row, check only previous and last row
        } else if (rowIndex == originalField.get(rowIndex).size() - 1) {
            rowBeginIndex = originalField.get(rowIndex).size() - 2;
            rowEndIndex = originalField.get(rowIndex).size() - 1;
            neighbours = countNeighbours(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
            // Else, check previous, current and next row
        } else {
            rowBeginIndex = rowIndex - 1;
            rowEndIndex = rowIndex + 1;
            neighbours = countNeighbours(originalField, rowBeginIndex, rowEndIndex, rowIndex, cellIndex);
        }
        return neighbours;
    }

    // Does this method need to be static?
    public static int countNeighbours(ArrayList<ArrayList<Character>> originalField, int rowBeginIndex, int rowEndIndex, int rowIndex, int cellIndex) {
        int neighbours = 0; // should I reset this on every function call?
        int cellBeginIndex, cellEndIndex;
        for (int i = rowBeginIndex; i <= rowEndIndex ; i++) {
            ArrayList<Character> row = originalField.get(i);
            // If current cell is the first in its row, check only current and next cell:
            if (cellIndex == 0) {
                cellBeginIndex = 0;
                cellEndIndex = 1;
                // call checkCells
                neighbours = checkCells(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
            // Else if current cell is the last in its row, check only the previous and the last cell:
            } else if (cellIndex == originalField.get(rowIndex).size() - 1) {
                cellBeginIndex = originalField.get(rowIndex).size() - 2;
                cellEndIndex = originalField.get(rowIndex).size() - 1;
                neighbours = checkCells(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
            // Else, check the previous, current and next cell:
            } else {
                cellBeginIndex = cellIndex - 1;
                cellEndIndex = cellIndex + 1 ;
                neighbours = checkCells(row, cellBeginIndex, cellEndIndex, rowIndex, cellIndex, i, neighbours);
            }
        }

        return neighbours;
    }

    // Does this method need to be static?
    public static int checkCells(ArrayList<Character> row, int cellBeginIndex, int cellEndIndex, int rowIndex, int cellIndex, int currentRowIndex, int neighbours) {
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
