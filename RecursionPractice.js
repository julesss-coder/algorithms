/*
You are given an integer N. Print numbers from 1 to N without the help of loops.

Examples:

Input: N = 5
Output: 1 2 3 4 5
Explanation: We have to print numbers from 1 to 5.

Input: N = 10
Output: 1 2 3 4 5 6 7 8 9 10
Explanation: We have to print numbers from 1 to 10.


Source URL: https://www.geeksforgeeks.org/top-50-interview-problems-on-recursion-algorithm/
*/

function printNumsToN(n) {
  if (n === 0) {
      return;
  } else if (n > 0) {
      printNumsToN(n - 1);
      console.log(n);
  }
}

// Time complexity: O(n)
// Space complexity: O(n)

// ===============================
/*

You are given an integer N. Print numbers from N to 1 without the help of loops.
*/

function printNumsFromNTo1(n) {
  if (n === 0) {
    return;
  } else if (n > 0) {
    console.log(n);
    printNumsFromNTo1(n - 1);
  }
}

// Time complexity: O(n)
// Space complexity: O(n)

//===============================

/*

Mean of array using recursion


To find the mean of the elements of the array. 

Mean = (Sum of elements of the Array) /
       (Total no of elements in Array)

*/

function getSum(array) {
  if (array.length === 1) {
    return array[0];
  } else {
    return array[0] + getSum(array.slice(1));
  }
}

function getMean(array) {
  return getSum(array) / array.length;
}

// ==========================
/*
Sum of natural numbers using recursion
Given a number n, find sum of first n natural numbers. To calculate the sum, we will use a recursive function recur_sum().
Examples : 
 

Input : 3
Output : 6
Explanation : 1 + 2 + 3 = 6

Input : 5
Output : 15
Explanation : 1 + 2 + 3 + 4 + 5 = 15
*/

function sumUpToN(n) {
  if (n === 0) {
    return 0;
  } else {
    return n + sumUpToN(n - 1);
  }
}

// ===========
/*
Print reverse of a string using recursion
Write a recursive function to print the reverse of a given string. 

*/

function reverseString(string) {
  if (string.length === 1) {
    console.log(string[0]);
    return;
  } else {
    reverseString(string.slice(1));
    console.log(string[0]);
  }
}