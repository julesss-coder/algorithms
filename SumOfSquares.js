/*
For a positive integer `n`, get the sum of squares of all numbers <= `n`.
- iterative approach
- recursive approach

*/

function getSumOfSquaresRecursive(n) {
  if (n % 1 !== 0) return; 

  // base case
  if (n === 1) {
    return 1;
  // recursive case
  } else {
    // return sum of the value of `n` in current "frame" plus sum of squares up to `n` - 1.
    // Upon returning from the top of the recursive tree, the number returned here is passed along to the next lowest "frame" on the call stack as the return value of `getSumOfSquaresRecursive(n - 1)`.
    return n * n + getSumOfSquaresRecursive(n - 1);
  }
}


function getSumOfSquaresIterative(n) {
  if (n % 1 !== 0) return; 
  
  let sumOfSquares = 0;
  for (let i = 1; i <= n; i++) {
    sumOfSquares += i * i;
  }
  
  return sumOfSquares;
}

console.log(getSumOfSquaresIterative(5));
console.log(getSumOfSquaresRecursive(5));
