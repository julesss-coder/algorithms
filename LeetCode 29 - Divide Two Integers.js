/*
LeetCode 29. Divide Two Integers
URL: https://leetcode.com/problems/divide-two-integers/description/

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−2**31, 2**31 − 1]. For this problem, if the quotient is strictly greater than 2**31 - 1, then return 2**31 - 1, and if the quotient is strictly less than -2**31, then return -2**31.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.
 

Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0

========================

### Edge cases
divisor = 0 
divisor = 1
divisor = -1

*/

var divide = function(dividend, divisor) {
  let counter = 0;
  let quotientIsNegative = false;

  if (divisor === 0) {
    return;
  }

  // Deal with integers outside the 32-bit signed integer range
  if (dividend == -2147483648 && divisor == -1) {
    return 2147483647;
  }

  if (divisor === 1) {
    return dividend;
  } else if (divisor === -1) {
    return -dividend;
  }

  if (
    dividend < 0 && divisor > 0 || 
    dividend > 0 && divisor < 0) {
    quotientIsNegative = true;
  }

  dividend = Math.abs(dividend);
  divisor = Math.abs(divisor);

  while (dividend >= divisor) {
    dividend = dividend - divisor;
    counter++;
  }

  if (quotientIsNegative) {
    counter = -counter;
  }

  return counter;
};
