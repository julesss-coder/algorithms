/*
LeetCode 29. Divide Two Integers
URL: https://leetcode.com/problems/divide-two-integers/description/

*/

/* ============ VERSION 1: SUBTRACTING DIVISOR REPEATEDLY========== */

var divide = function(dividend, divisor) {
  let counter = 0;
  let quotientIsNegative = false;

  if (divisor === 0) {
    return;
  }

  // Deal with integers outside the 32-bit signed integer range
  // The result of -2147483648 ÷ -1 would be 2147483648, which is outside the integer range (ranges until 2**31 - 1, i.e. 2147483647)
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


/* ============ VERSION 2: SUBTRACTING MULTIPLE OF DIVISOR ========== */



var divideTwoIntegers = function(dividend, divisor) {
  if (divisor === 0) {
    return;
  }

  // Deal with integers outside the 32-bit signed integer range
  // The result of -2147483648 ÷ -1 would be 2147483648, which is outside the integer range (ranges until 2**31 - 1, i.e. 2147483647)
  if (dividend == -2147483648 && divisor == -1) {
    return 2147483647;
  }

  if (divisor === 1) {
    return dividend;
  } else if (divisor === -1) {
    return -dividend;
  }


  let quotientIsNegative = false;

  if (
    dividend < 0 && divisor > 0 || 
    dividend > 0 && divisor < 0) {
    quotientIsNegative = true;
  }


  dividend = Math.abs(dividend);
  divisor = Math.abs(divisor);
  let quotient = 0;
  let copiesOfDivisor = 0;
  
  while (dividend >= divisor) {
    // Dividend fits into divisor at least once
    copiesOfDivisor = 1;
    let value = divisor;
  
    // If also divisor * 2 fits into the dividend:
    while (value + value <= dividend) {
      value += value;
      copiesOfDivisor += copiesOfDivisor;
    }
  
    quotient += copiesOfDivisor;
    dividend -= value;
  }
  
  if (quotientIsNegative) {
    quotient = -quotient;
  }

  return quotient;
}  
