/*
STRATEGY 1

field size:
    let user choose

cells with x:
    create randomly

number of generations:
    let user choose
    if user cancels:
        end game

fieldArray = [
    [., X, .],
    [., ., X],
    [X, X, X]
]

// newFieldArray = copy of fieldArray
newFieldArray = [
    [., X, .],
    [., ., X],
    [X, X, X]
]
// Check fieldArray itself
For each subarray in fieldArray:
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




 */

public class ConwayGameOfLife {
    public static void main(String[] args) {

    }
}
