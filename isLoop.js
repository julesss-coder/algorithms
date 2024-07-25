/*
Problem description:
Given an array of walking directions ["N", "E", "S", "W"], where each element represents a single step in the specified direction, determine whether the path ends in the same location it starts.

For example:
isLoop(["N", "N", "S", "S"]) should return true
isLoop(["N", "N", "S"]) should return false

Summary:
Map the four geographic directions to a two-dimensional coordinate systems. Trace steps in directions and see where you end up.

*/

// Implementation
function isLoop(directions) {
  if (directions.length === 0) return true;

  // Although the problem does not state that we start at the origin of a grid, it makes sense to define our current position as origin.
  let finalXCoordinate = 0;
  let finalYCoordinate = 0;


  for (let i = 0; i < directions.length; i++) {
    let step = directions[i];

    if (step === "N") {
      finalYCoordinate++;
    } else if (step === "E") {
      finalXCoordinate++;
    } else if (step === "S") {
      finalYCoordinate--;
    } else if (step === "W") {
      finalXCoordinate--;
    }
  }

  if (finalXCoordinate === 0 && finalYCoordinate === 0) {
    return true;
  } else {
    return false;
  }
}

// Time complexity:
// Space complexity: