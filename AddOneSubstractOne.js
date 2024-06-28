/*
Add One, Subtract One 

Problem description:
For both parts of today's problem, you'll be dealing with array representations of (potentially) very larger numbers. Each element in one of these arrays will be a digit (integer from 0 to 9).

For example, [5, 0, 0, 0, 1, 2, 3] represents 5,000,123.

Part 1: Add one
Given a digit array representing a positive number, mutate that array so that it represents the value after adding 1 to that number. 

addOne([2, 4, 5]) should return [2, 4, 6]
addOnce([9] should return [1, 0])

---
Write summary, implementation, time complexity, space complexity
*/

// Summary: If digit is between 0 and 8, add 1 and return. If digit is a 9, set it to 0 and note carry. Set the next number that is not a 9 to number + 1 and return. If there are only 9s, set them to 0 and add 1 to beginning of array.
function addOne(array) {
  let nextPowerOfTen = false;

  for (let i = array.length - 1; i >= 0; i--) {
    let number = array[i];

    // If the digit is 9, set it to zero and set `nextPowerOfTen` to true to signify that there is a carryover of 1
    if (number === 9) {
      array[i] = 0;
      nextPowerOfTen = true;
    // If the digit is 0 to 8, add 1 and return the array
    } else if (number !== 9) {
        array[i] = ++number;
        return array;
    }
  }

  // If the first digit of the array was 9, it was set to 0. As there is still a carryover of 1, add 1 to the beginning of the array.
  if (nextPowerOfTen === true) {
    array.unshift(1);
  }

  return array;
}

// Time complexity: O(n)
// Space complexity: O(n)