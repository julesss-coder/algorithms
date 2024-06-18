/*
# Problem description

You'll be dealing with array representations of (potentially) very large numbers. Each element in one of these arrays will be a digit (i.e an integer 0-9).

For example, [5, 0, 0, 0, 1, 2, 3] represents 5,000,123.

## Part 1
Given two 'digit' arrays, determine if the number represented by the first array is larger than the number represented by the second array.
You can assume that there will be no leading zeroes. You should do this without converting the array to a number.
// number1 > number2? if yes => true, if no => false

greaterThan([5, 1, 7], [1, 7, 5]) should return true, because 517 is larger than 175.

## Part 2
Solve the same problem as part 1, but assume that the arrays can contain up to one decimal point character.
You can assume that there will be no leading zeroes, an no trailing zeroes after a decimal point. You should do this without converting the array to a number.

For example, [3, ".", 1, 4] represents 3,14.

greaterThan([5, ",", 0, 1], [5, ".", 0, 7]) should return false. 

Solve without any string or array methods. 

Summary
Implementation
Confidence %
Time Complexity
Space Complexity

===============================

Part 1, strategy 1

Summary: Compare array lengths. If array lengths are equal, compare numbers by place value. 

Outline:
If array1.length === array2.length:
  For each number in array1: 
    If number > number at same index in array 2:
      Return true
    Else if number < number at same index in array2:
      Return false

  // If the numbers in the arrays are the same, in the same order
  Return false
Else if array1.length > array.length:
  Return true
Else if array.length < array2.length:
  Return false // This works because there are no leading zeroes


Trace
[1, 2, 3], [1, 2, 3]
       *          *   

[3, 2, 1], [3, 2, 2] => return false
       *          * 

[1, 1], [1]
 

[1], [1, 1]

Time complexity: 4 + array1.length.times * 2 => O(n), n = array1.length
Space complexity: 1 for function call, 2 for input array memory addresses, 1 for i, 1 for `true` => O(1)
*/ 

function greaterThan(array1, array2) {
  if (array1.length === array2.length) { // 1
    for (let i = 0; i < array1.length; i++) { // array1.length times
      if (array1[i] > array2[i]) { // worst case: 2 instructions (if second condition is true), without return statement
        return true;
      } else if (array1[i] < array2[i]) {
        return false;
      }
    }

    // Case: All numbers in array1 and array2 are the same, in the same order
    return false;
  } else if (array1.length > array2.length) { // 1
    return true;
  } else if (array1.length < array2.length) { // 1
    return false; // 1 return statement counted
  }
}

/*

Part 2, Strategy 1

Summary: Track decimal point index. If equal, compare numbers before decimal point. If equal, compare numbers after decimal point.

Outline:

decimalPointIndex1;
decimalPointIndex2;

// Combine getting decimal index and comparing numbers before decimal index?
For each array:
  Get index of decimal point ("." or ",")

If decimalPointIndex1 > decimalPointIndex2:
  return true
If decimalPointIndex1 < decimalPointIndex2:
  return false
// If numbers before decimal point have same length:
Else if decimalPointIndex1 === decimalPointIndex2:
  For each number in array1 until decimalPointIndex1 (exclusively):
    If number > number at same position in array2:
      Return true
    Else if number < number at same position in array2:
      Return false

  For each number in array, starting after decimalPointIndex1:
    number = if number is not undefined, number is 0
    If number > number at same position in array2:
      Return true
    Else if number < number at same position in array2:
      Return false

  Return false
    
TRACE
decimalPointIndex1 = 1
decimalPointIndex2 = 2

[1, ".", 1, 1], [1, 2, ".", 1, 1]    => returns false
*               *

[1, 2, ".", 1, 1], [1, ".", 1, 1]    => returns true

[1, 2, ".", 1, 1], [1, 2, ".", 1, 1, 2] => returns false
                  *                  *

[1, 2, ".", 1, 2], [1, 2, ".", 1, 1]    => returns true
                  *                  * 

EDGE CASES
Empty arrays
no decimal points
only one array with decimal point
comma instead of decimal point
*/

function greaterThanPart2(array1, array2) {
  let decimalPointIndex1;
  let decimalPointIndex2;

  // Assuming the decimal point is the "." character, not the "," comma
  for (let i = 0; i < array1.length; i++) {
    if (array1[i] === ".") {
      decimalPointIndex1 = i;
      break;
    }
  }

  for (let i = 0; i < array2.length; i++) {
    if (array1[i] === ".") {
      decimalPointIndex2 = i;
      break;
    }
  }

  if (decimalPointIndex1 > decimalPointIndex2) {
    return true;
  } else if (decimalPointIndex1 < decimalPointIndex2) {
    return false;
  } else if (decimalPointIndex1 === decimalPointIndex2) {
    for (let i = 0; i < decimalPointIndex1; i++) {
      if (array1[i] > array2[i]) {
        return true;
      } else if (array1[i] < array2[i]) {
        return false;
      } 
    }

    for (let i = decimalPointIndex1 + 1; i < array1.length; i++) {
      let number1 = (array1[i] === undefined) ? 0 : array1[i];
      let number2 = (array2[i] === undefined) ? 0 : array2[i];

      if (number1 > number2) {
        return true;
      } else if (number1 < number2) {
        return false;
      }
    }

    // The numbers in array1 and array2 are exactly the same
    return false;
  }
}
