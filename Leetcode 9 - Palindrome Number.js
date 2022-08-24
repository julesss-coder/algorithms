// <!-- 9. Palindrome Number
// Easy

// 6476

// 2224

// Add to List

// Share
// Given an integer x, return true if x is palindrome integer.

// An integer is a palindrome when it reads the same backward as forward.

// For example, 121 is a palindrome while 123 is not.
 

// Example 1:

// Input: x = 121
// Output: true
// Explanation: 121 reads as 121 from left to right and from right to left.
// Example 2:

// Input: x = -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
// Example 3:

// Input: x = 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

// Constraints:

// -2**31 <= x <= 2**31 - 1
 

// Follow up: Could you solve it without converting the integer to a string? 


/* 

if number x is negative, return false.
if number x has one digit only, return true.

digitsArray = Turn x into array of digits
// Due to the constraints of the problem, number x can have 3 digits at the most. In case of 3 digits, the first and last have to be equal for x to be a palindrome number.
// In case of two digits, both numbers have to be equal.
If digitsArray[i] === digitsArray[digitsArray.length - 1]: 
  return true
Else:
  Return false

*/

var isPalindrome = function(x) {
  if (x < 0) return false;
  // If x has only one digit, it is a palindrome number
  if (x < 10) return true;  

  // Turn x into an array of digits
  let digitsArray = [...x+''].map(digit => +digit);

  let i = 0;
  // Iterate only over first half of digits that comprise x, as the following code checks the second half of the digits, as well
  while (i < Math.round(digitsArray.length / 2)) {
    if (digitsArray[i] !== digitsArray[digitsArray.length - 1 - i]) {
      return false;
    }
    i++;
  }

  return true;
};


// 1, 2, 3,4
//    *       while i < (length / 2) === while i < Math.round(length / 2)
// 1, 2, 3, 4, 5
//       *       while i < Math.round(length / 2)


// ========

var isPalindrome = function(x) {
  if (x < 0) return false;
  // If x has only one digit, it is a palindrome number
  if (x < 10) return true;  

  // Turn x into an array of digits
  let digitsArray = [...x+''].map(digit => +digit);

  // Iterate over digitsArray from left and right and compare digits
  let left = 0;
  let right = digitsArray.length - 1;

  while (left <= right) {
    if (digitsArray[left] !== digitsArray[right]) {
      return false;
    }

    left++;
    right--;
  }

  return true;
};


